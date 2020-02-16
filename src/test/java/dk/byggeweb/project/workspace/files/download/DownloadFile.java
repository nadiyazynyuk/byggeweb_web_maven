package dk.byggeweb.project.workspace.files.download;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import dk.byggeweb.steps.GeneralSteps;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

public class DownloadFile extends ProjectTestBase {

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToWorkspaceModule();
        uploadFileIfNotPresentInWorkspaceFolder(data.getFolderName(), data.getFileToUploadPath(), data.getTestFileName());
        GeneralSteps.clearOutputDirectory(new File(getAbsolutePath(outputDirectory)));
    }

    @Test(description = "Download files")
    public void downloadFile() {
        fileSteps.downloadFile(data.getTestFileName());
        GeneralSteps.waitForTheFileToDownload(data.getTestFileName(), getAbsolutePath(outputDirectory));
        Assert.assertTrue(GeneralSteps.isFilePresentInDirectory(data.getTestFileName(), getAbsolutePath(outputDirectory)));
    }

}
