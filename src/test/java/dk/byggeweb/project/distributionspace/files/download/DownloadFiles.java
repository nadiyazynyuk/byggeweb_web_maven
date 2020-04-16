package dk.byggeweb.project.distributionspace.files.download;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import io.qameta.allure.Link;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DownloadFiles extends ProjectTestBase {

    @Link(url = "https://itwofm.atlassian.net/browse/TSB-78")

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToPublicationSpace();
        psFolderSteps.navigateToFolderInDocumentList(data.getDocumentListName(), data.getDocumentListFolderName());

        projectHomePage.navigateToDistributionSpace();
        dsFolderSteps.navigateToFolderInDocumentListInDistributionList(data.getDistributionListName(), data.getDocumentListName(), data.getDocumentListFolderName());

        try {
            dsFileSteps.verifyFileIsPresent(data.getTestFileName());
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            projectHomePage.navigateToPublicationSpace();
            uploadFileIfNotPresentInDocumentListFolder(data.getFileToUploadPath(), data.getTestFileName());
            psFileSteps.distributeFile(data.getTestFileName(), data.getDistributionListName());
            projectHomePage.navigateToDistributionSpace();
        }

        try {
            dsFileSteps.verifyFileIsPresent(data.getTestFileName2());
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            projectHomePage.navigateToPublicationSpace();
            uploadFileIfNotPresentInDocumentListFolder(data.getFileToUploadPath2(), data.getTestFileName2());
            psFileSteps.distributeFile(data.getTestFileName2(), data.getDistributionListName());
            projectHomePage.navigateToDistributionSpace();
        }

    }

    @Test(description = "Download multiple files (generate download files link) from Document list folder")
    public void downloadFiles() {
        dsFileSteps.generateDownloadFilesLink(data.getTestFileName());
    }

}
