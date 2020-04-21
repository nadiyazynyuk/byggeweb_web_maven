package dk.byggeweb.project.publicationspace.nonapproval.files.publish;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import io.qameta.allure.Link;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PublishNewFileFromWorkspace extends ProjectTestBase {

    @Link(url = "https://itwofm.atlassian.net/browse/TSB-54")

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToWorkspaceModule();
        wsFolderSteps.navigateToFolder(data.getFolderName());
        uploadFileIfNotPresentInWorkspaceFolder(data.getFileToUploadPath(), data.getTestFileName());

        projectHomePage.navigateToPublicationSpace();
        psFolderSteps.navigateToFolderInDocumentList(data.getDocumentListName(), data.getDocumentListFolderName());
        deleteFileIfPresentInDocumentListFolder(data.getTestFileName());
    }

    @Test(description = "Publish new file from Workspace into Document list folder")
    public void publishNewFileFromWorkspace() {
        psFileSteps.publishFileFromWorkspace(data.getTestFileName(), data.getFolderName());
        psFileSteps.verifyFileIsPresent(data.getTestFileName());
    }

}
