package dk.byggeweb.project.publicationspace.withapproval.files.publish;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import io.qameta.allure.Link;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ApproveNewFileVersionFromLocalMachine extends ProjectTestBase {

    @Link(url = "https://itwofm.atlassian.net/browse/TSB-86")

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
    }

    @Test(description = "Publish new file from Local machine to the list with approval procedure")
    public void publishNewFileFromLocalMachine() {
        psFileSteps.publishFileFromLocalMachine(getAbsolutePath(data.getFileV1ToUploadPath()), data.getTestFileName(), "A");
        projectHomePage.getPublicationSpaceNodesPanel().navigateToWaitingForApproval();
        psFileSteps.verifyFileIsPresent(data.getTestFileName());
    }

    @Test(dependsOnMethods = "publishNewFileFromLocalMachine", description = "Approve first file version")
    public void approveFileVersion() {
        psFileSteps.approveFile(data.getTestFileName());
        psFolderSteps.navigateToDocumentList(data.getDocumentListName());
        psFolderSteps.navigateToFolderInsideDocumentList(data.getDocumentListFolderName());
        psFileSteps.verifyFileIsPresent(data.getTestFileName());
    }

    @Test(dependsOnMethods = "approveFileVersion", description = "Publish new file version from Local machine to the list with approval procedure")
    public void publishNewFileVersionFromLocalMachine() {
        psFileSteps.publishFileFromLocalMachine(getAbsolutePath(data.getFileV2ToUploadPath()), data.getTestFileName(), "B");
        projectHomePage.getPublicationSpaceNodesPanel().navigateToWaitingForApproval();
        psFileSteps.verifyFileIsPresent(data.getTestFileName());
    }

    @Test(dependsOnMethods = "publishNewFileVersionFromLocalMachine", description = "Approve second file version")
    public void approveNewFileVersion() {
        psFileSteps.approveFile(data.getTestFileName());
        psFolderSteps.navigateToDocumentList(data.getDocumentListName());
        psFolderSteps.navigateToFolderInsideDocumentList(data.getDocumentListFolderName());
        psFileSteps.verifyFileIsPresent(data.getTestFileName());
    }

    @Test(dependsOnMethods = "approveNewFileVersion", description = "Check file content of new version of published file")
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
}
