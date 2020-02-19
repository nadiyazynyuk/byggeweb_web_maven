package dk.byggeweb.project.workspace.files.publish;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PublishFile extends ProjectTestBase {

    // https://itwofm.atlassian.net/browse/TSB-32

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToPublicationSpace();
        deleteFileIfPresentInDocumentListFolder(data.getDocumentListName(), data.getDocumentListFolderName(), data.getTestFileName());

        projectHomePage.navigateToWorkspaceModule();
        uploadFileIfNotPresentInWorkspaceFolder(data.getFolderName(), data.getFileToUploadPath(), data.getTestFileName());
    }

    @Test(description = "Publish new file from Workspace")
    public void publishFile() {
        wsFileSteps.publishNewFile(data.getTestFileName(), data.getDocumentListFolderName());
        projectHomePage.navigateToPublicationSpace();
        psFileSteps.verifyFileIsPresent(data.getTestFileName());
    }

}