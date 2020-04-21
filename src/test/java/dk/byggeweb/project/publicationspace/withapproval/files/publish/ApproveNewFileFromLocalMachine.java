package dk.byggeweb.project.publicationspace.withapproval.files.publish;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import io.qameta.allure.Link;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ApproveNewFileFromLocalMachine extends ProjectTestBase {

    @Link(url = "https://itwofm.atlassian.net/browse/TSB-60")

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