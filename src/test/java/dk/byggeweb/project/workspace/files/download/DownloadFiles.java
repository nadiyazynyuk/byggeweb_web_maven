package dk.byggeweb.project.workspace.files.download;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DownloadFiles extends ProjectTestBase {

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToWorkspaceModule();
        uploadFileIfNotPresentInWorkspaceFolder(data.getFolderName(), data.getFileToUploadPath(), data.getTestFileName());
        uploadFileIfNotPresentInWorkspaceFolder(data.getFolderName(), data.getFileToUploadPath2(), data.getTestFileName2());
    }

    @Test(description = "Download files (generate download files link)")
    public void downloadFiles() {
        fileSteps.generateDownloadFilesLink(data.getTestFileName());
    }
}
