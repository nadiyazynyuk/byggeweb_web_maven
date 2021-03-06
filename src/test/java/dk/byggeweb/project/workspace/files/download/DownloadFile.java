package dk.byggeweb.project.workspace.files.download;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import dk.byggeweb.steps.GeneralSteps;
import io.qameta.allure.Link;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DownloadFile extends ProjectTestBase {

    @Link(url = "https://itwofm.atlassian.net/browse/TSB-30")

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToWorkspaceModule();
        wsFolderSteps.navigateToFolder(data.getFolderName());
        uploadFileIfNotPresentInWorkspaceFolder(data.getFileToUploadPath(), data.getTestFileName());
        GeneralSteps.deleteFileFromDirectory(data.getTestFileName(), getAbsolutePath(getOutputDirectory()));
    }

    @Test(description = "Download single file from Workspace folder")
    public void downloadFile() {
        wsFileSteps.downloadFile(data.getTestFileName());
        GeneralSteps.waitForTheFileToDownload(data.getTestFileName(), getAbsolutePath(getOutputDirectory()));
        Assert.assertTrue(GeneralSteps.isFilePresentInDirectory(data.getTestFileName(), getAbsolutePath(getOutputDirectory())));
    }

}
