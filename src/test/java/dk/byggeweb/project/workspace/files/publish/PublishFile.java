package dk.byggeweb.project.workspace.files.publish;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import io.qameta.allure.Link;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PublishFile extends ProjectTestBase {

    @Link(url = "https://itwofm.atlassian.net/browse/TSB-32")

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToPublicationSpace();
        psFolderSteps.navigateToFolderInDocumentList(data.getDocumentListName(), data.getDocumentListFolderName());
        deleteFileIfPresentInDocumentListFolder(data.getTestFileName());

        projectHomePage.navigateToWorkspaceModule();
        wsFolderSteps.navigateToFolder(data.getFolderName());
        uploadFileIfNotPresentInWorkspaceFolder(data.getFileToUploadPath(), data.getTestFileName());
    }

    @Test(description = "Publish new file from Workspace")
    public void publishFile() {
        wsFileSteps.publishNewFile(data.getTestFileName(), data.getDocumentListFolderName());
        projectHomePage.navigateToPublicationSpace();
//        psFolderSteps.navigateToFolderInDocumentList(data.getDocumentListName(), data.getDocumentListFolderName()); // <--- for production???
        psFileSteps.verifyFileIsPresent(data.getTestFileName());
    }

}