package dk.byggeweb.project.publicationspace.files.download;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import dk.byggeweb.steps.GeneralSteps;
import io.qameta.allure.Link;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DownloadFile extends ProjectTestBase {

    @Link(url = "https://itwofm.atlassian.net/browse/TSB-41")

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToPublicationSpace();
        psFolderSteps.navigateToFolderInDocumentList(data.getDocumentListName(), data.getDocumentListFolderName());
        uploadFileIfNotPresentInDocumentListFolder(data.getFileToUploadPath(), data.getTestFileName());
        GeneralSteps.deleteFileFromDirectory(data.getTestFileName(), getAbsolutePath(getOutputDirectory()));
    }

    @Test(description = "Download single file from Document list folder")
    public void downloadFile() {
        psFileSteps.downloadFile(data.getTestFileName());
        GeneralSteps.waitForTheFileToDownload(data.getTestFileName(), getAbsolutePath(getOutputDirectory()));
        Assert.assertTrue(GeneralSteps.isFilePresentInDirectory(data.getTestFileName(), getAbsolutePath(getOutputDirectory())));
    }
}
