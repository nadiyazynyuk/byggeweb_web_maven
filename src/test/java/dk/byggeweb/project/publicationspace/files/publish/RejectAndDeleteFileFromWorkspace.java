package dk.byggeweb.project.publicationspace.files.publish;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import dk.byggeweb.objects.project.workspace.panels.WSFileInformationPanel;
import io.qameta.allure.Link;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RejectAndDeleteFileFromWorkspace extends ProjectTestBase {

    @Link(url = "https://itwofm.atlassian.net/browse/TSB-64")

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToWorkspaceModule();
        wsFolderSteps.navigateToFolder(data.getFolderName());
        deleteFileIfPresentInWorkspaceFolder(data.getTestFileName());
        uploadFileIfNotPresentInWorkspaceFolder(data.getFileToUploadPath(), data.getTestFileName());
        editRevisionMetadata();

        projectHomePage.navigateToPublicationSpace();
        projectHomePage.getPublicationSpaceNodesPanel().navigateToWaitingForApproval();

        try {
            psFileSteps.rejectAndDeleteFile(data.getTestFileName());
        } catch (com.codeborne.selenide.ex.ElementNotFound ignored) {
        }

        psFolderSteps.navigateToFolderInDocumentList(data.getDocumentListName(), data.getDocumentListFolderName());
        deleteFileIfPresentInDocumentListFolder(data.getTestFileName());
    }

    @Test(description = "Publish file from Workspace to the list with approval procedure")
    public void publishFileFromWorkspace() {
        psFileSteps.publishFileFromWorkspace(data.getTestFileName(), data.getFolderName());
        projectHomePage.getPublicationSpaceNodesPanel().navigateToWaitingForApproval();
        psFileSteps.verifyFileIsPresent(data.getTestFileName());
    }

    @Test(dependsOnMethods = "publishFileFromWorkspace", description = "Reject and delete file")
    public void rejectAndDeleteFile() {
        psFileSteps.rejectAndDeleteFile(data.getTestFileName());
        psFolderSteps.navigateToDocumentList(data.getDocumentListName());
        psFolderSteps.navigateToFolderInsideDocumentList(data.getDocumentListFolderName());
        psFileSteps.verifyFileIsNotPresent(data.getTestFileName());
    }

    private void editRevisionMetadata() {
        wsFileSteps.selectFile(data.getTestFileName());
        wsFileInformationSteps.editMetadataTextField(
                data.getTestFileName(),
                new WSFileInformationPanel(data.getTestFileName()).getMetadataRevisionField(), "A");
        wsFileSteps.verifyDataIsPresentInTable("A");
    }
}
