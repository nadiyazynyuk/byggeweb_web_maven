package dk.byggeweb.project.publicationspace.files.publish;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PublishNewFileFromLocalMachine extends ProjectTestBase {

    // https://itwofm.atlassian.net/browse/TSB-37

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToPublicationSpace();
        deleteFileIfPresentInDocumentListFolder(data.getDocumentListName(), data.getDocumentListFolderName(), data.getTestFileName());
    }

    @Test(description = "Publish new file from Local machine into Document list folder")
    public void publishNewFileFromLocalMachine() {
        psFileSteps.publishFileFromLocalMachine(getAbsolutePath(data.getFileToUploadPath()), data.getTestFileName());
        psFileSteps.verifyFileIsPresent(data.getTestFileName());
    }
}