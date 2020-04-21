package dk.byggeweb.project.publicationspace.withapproval.files.publish;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import dk.byggeweb.objects.project.workspace.panels.WSFileInformationPanel;
import io.qameta.allure.Link;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ApproveNewFileVersionFromWorkspace extends ProjectTestBase {

    @Link(url = "https://itwofm.atlassian.net/browse/TSB-85")

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToPublicationSpace();
        projectHomePage.getPublicationSpaceNodesPanel().navigateToWaitingForApproval();
        try {
            psFileSteps.rejectAndDeleteFile(data.getTestFileName());
        } catch (com.codeborne.selenide.ex.ElementNotFound ignored) {
        }
        psFolderSteps.navigateToFolderInDocumentList(data.getDocumentListName(), data.getDocumentListFolderName());
        deleteFileIfPresentInDocumentListFolder(data.getTestFileName());

        projectHomePage.navigateToWorkspaceModule();
        wsFolderSteps.navigateToFolder(data.getFolderName());
        deleteFileIfPresentInWorkspaceFolder(data.getTestFileName());
    }

    @Test(description = "Upload first file version in Workspace")
    public void uploadFirstFileVersion() {
        wsFileSteps.enhancedUploadSingleFile(getAbsolutePath(data.getFileV1ToUploadPath()));
        wsFileSteps.closeEditFileInformationPopup();
        wsFileSteps.verifyFileIsPresent(data.getTestFileName());
        editRevisionMetadata("A");
    }

    @Test(dependsOnMethods = "uploadFirstFileVersion", description = "Publish new file from Workspace to Document list with approval")
    public void publishFirstFileVersion() {
        wsFileSteps.publishNewFile(data.getTestFileName(), data.getDocumentListFolderName());
        projectHomePage.navigateToPublicationSpace();
        projectHomePage.getPublicationSpaceNodesPanel().navigateToWaitingForApproval();
        psFileSteps.verifyFileIsPresent(data.getTestFileName());
    }

    @Test(dependsOnMethods = "publishFirstFileVersion", description = "Approve first file version")
    public void approveFileVersion() {
        psFileSteps.approveFile(data.getTestFileName());
        psFolderSteps.navigateToDocumentList(data.getDocumentListName());
        psFolderSteps.navigateToFolderInsideDocumentList(data.getDocumentListFolderName());
        psFileSteps.verifyFileIsPresent(data.getTestFileName());
    }

    @Test(dependsOnMethods = "approveFileVersion", description = "Upload second file version in Workspace")
    public void uploadSecondFileVersion() {
        projectHomePage.navigateToWorkspaceModule();
        wsFolderSteps.navigateToFolder(data.getFolderName());
        wsFileSteps.enhancedUploadSingleFile(data.getFileV2ToUploadPath());
        wsFileSteps.closeEditFileInformationPopup();
        wsFileSteps.verifyFileIsPresent(data.getTestFileName());
        editRevisionMetadata("B");
    }

    @Test(dependsOnMethods = "uploadSecondFileVersion", description = "Publish new file version from Workspace to Document list with approval")
    public void publishSecondFileVersion() {
        wsFileSteps.publishNewFileVersion(data.getTestFileName());
        projectHomePage.navigateToPublicationSpace();
        projectHomePage.getPublicationSpaceNodesPanel().navigateToWaitingForApproval();
        psFileSteps.verifyFileIsPresent(data.getTestFileName());
    }

    @Test(dependsOnMethods = "publishSecondFileVersion", description = "Approve second file version")
    public void approveNewFileVersion() {
        psFileSteps.approveFile(data.getTestFileName());
        psFolderSteps.navigateToDocumentList(data.getDocumentListName());
        psFolderSteps.navigateToFolderInsideDocumentList(data.getDocumentListFolderName());
        psFileSteps.verifyFileIsPresent(data.getTestFileName());
    }

    @Test(dependsOnMethods = "publishSecondFileVersion", description = "Check file content of new version of published file")
    public void checkLatestFileVersionContent() {
        psFileSteps.selectFile(data.getTestFileName());
        psFileInformationSteps.openFile(data.getTestFileName(), data.getFileV2Content());
    }

    @Test(dependsOnMethods = "checkLatestFileVersionContent", description = "Check file content of first version published file")
    public void checkFirstFileVersionContent() {
        psFileSteps.selectFile(data.getTestFileName());
        psFileInformationSteps.selectFileVersion(data.getTestFileName(), data.getFileV1VersionIndex());
        psFileInformationSteps.openPreviousFileVersion(data.getTestFileName(), data.getFileV1Content());
    }

    private void editRevisionMetadata(String revision) {
        wsFileSteps.selectFile(data.getTestFileName());
        wsFileInformationSteps.editMetadataTextField(
                data.getTestFileName(),
                new WSFileInformationPanel(data.getTestFileName()).getMetadataRevisionField(), revision);
        wsFileSteps.verifyDataIsPresentInTable(revision);
    }
}
