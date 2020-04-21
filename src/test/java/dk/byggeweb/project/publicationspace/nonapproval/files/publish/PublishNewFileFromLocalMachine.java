package dk.byggeweb.project.publicationspace.nonapproval.files.publish;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import io.qameta.allure.Link;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PublishNewFileFromLocalMachine extends ProjectTestBase {

    @Link(url = "https://itwofm.atlassian.net/browse/TSB-37")

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToPublicationSpace();
        psFolderSteps.navigateToFolderInDocumentList(data.getDocumentListName(), data.getDocumentListFolderName());
        deleteFileIfPresentInDocumentListFolder(data.getTestFileName());
    }

    @Test(description = "Publish new file from Local machine into Document list folder")
    public void publishNewFileFromLocalMachine() {
        psFileSteps.publishFileFromLocalMachine(getAbsolutePath(data.getFileToUploadPath()), data.getTestFileName());
        psFileSteps.verifyFileIsPresent(data.getTestFileName());
    }
}