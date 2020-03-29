package dk.byggeweb.project.publicationspace.files.publish;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ApproveFileFromLocalMachine extends ProjectTestBase {

    // https://itwofm.atlassian.net/browse/TSB-60

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToPublicationSpace();
        projectHomePage.getPublicationSpaceNodesPanel().navigateToWaitingForApproval();
        while (true) {
            try {
                psFileSteps.rejectAndDeleteFile(data.getTestFileName());
            } catch (com.codeborne.selenide.ex.ElementNotFound e) {
                break;
            }
        }

        psFolderSteps.navigateToFolderInDocumentList(data.getDocumentListName(), data.getDocumentListFolderName());
        deleteFileIfPresentInDocumentListFolder(data.getTestFileName());
    }

    @Test(description = "Publish file from Local machine to the list with approval procedure")
    public void publishFileFromLocalMachine() {
        psFileSteps.publishFileFromLocalMachine(getAbsolutePath(data.getFileToUploadPath()), data.getTestFileName());
        projectHomePage.getPublicationSpaceNodesPanel().navigateToWaitingForApproval();
        psFileSteps.verifyFileIsPresent(data.getTestFileName());
    }

    @Test(dependsOnMethods = "publishFileFromLocalMachine", description = "Approve file")
    public void approveFile() {
        psFileSteps.approveFile(data.getTestFileName());
        psFolderSteps.navigateToDocumentList(data.getDocumentListName());
        psFolderSteps.navigateToFolderInsideDocumentList(data.getDocumentListFolderName());
        psFileSteps.verifyFileIsPresent(data.getTestFileName());
    }

}