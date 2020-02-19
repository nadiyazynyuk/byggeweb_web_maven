package dk.byggeweb.project.workspace.files.download;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DownloadFiles extends ProjectTestBase {

    // https://itwofm.atlassian.net/browse/TSB-31

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToWorkspaceModule();
        uploadFileIfNotPresentInWorkspaceFolder(data.getFolderName(), data.getFileToUploadPath(), data.getTestFileName());
        uploadFileIfNotPresentInWorkspaceFolder(data.getFolderName(), data.getFileToUploadPath2(), data.getTestFileName2());
    }

    @Test(description = "Download multiple files (generate download files link)")
    public void downloadFiles() {
        wsFileSteps.generateDownloadFilesLink(data.getTestFileName());
    }
}
