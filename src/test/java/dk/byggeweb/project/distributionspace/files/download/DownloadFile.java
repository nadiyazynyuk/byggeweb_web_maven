package dk.byggeweb.project.distributionspace.files.download;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import dk.byggeweb.steps.GeneralSteps;
import io.qameta.allure.Link;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DownloadFile extends ProjectTestBase {

    @Link(url = "https://itwofm.atlassian.net/browse/TSB-77")

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToDistributionSpace();
        dsFolderSteps.navigateToFolderInDocumentListInDistributionList(data.getDistributionListName(), data.getDocumentListName(), data.getDocumentListFolderName());

        try {
            dsFileSteps.verifyFileIsPresent(data.getTestFileName());
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            projectHomePage.navigateToPublicationSpace();
            psFolderSteps.navigateToFolderInDocumentList(data.getDocumentListName(), data.getDocumentListFolderName());
            uploadFileIfMNotPresentInDocumentListFolder(data.getFileToUploadPath(), data.getTestFileName());
            psFileSteps.distributeFile(data.getTestFileName(), data.getDistributionListName());
            projectHomePage.navigateToDistributionSpace();
        }

        GeneralSteps.deleteFileFromDirectory(data.getTestFileName(), getAbsolutePath(getOutputDirectory()));
    }

    @Test(description = "Download single file from Distribution space Document list list folder")
    public void downloadFile() {
        dsFileSteps.downloadFile(data.getTestFileName());
        GeneralSteps.waitForTheFileToDownload(data.getTestFileName(), getAbsolutePath(getOutputDirectory()));
        Assert.assertTrue(GeneralSteps.isFilePresentInDirectory(data.getTestFileName(), getAbsolutePath(getOutputDirectory())));
    }
}
