package dk.byggeweb.project.distributionspace.files.distribute;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import io.qameta.allure.Link;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CancelFileDistribution extends ProjectTestBase {

    @Link(url = "https://itwofm.atlassian.net/browse/TSB-76")

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToDistributionSpace();
        dsFolderSteps.navigateToFolderInDocumentListInDistributionList(data.getDistributionListName(), data.getDocumentListName(), data.getDocumentListFolderName());

        try {
            dsFileSteps.cancelFileDistribution(data.getTestFileName());
        } catch (com.codeborne.selenide.ex.ElementNotFound ignored) {}

        projectHomePage.navigateToPublicationSpace();
        psFolderSteps.navigateToFolderInDocumentList(data.getDocumentListName(), data.getDocumentListFolderName());
        uploadFileIfNotPresentInDocumentListFolder(data.getFileToUploadPath(), data.getTestFileName());

        projectHomePage.navigateToDistributionSpace();
        dsFolderSteps.navigateToDistributionList(data.getDistributionListName());
        dsFolderSteps.distributeFile(data.getTestFileName());
        dsFileSteps.verifyFileIsPresent(data.getTestFileName());
    }

    @Test(description = "Cancel file distribution")
    public void cancelFileDistribution() {
        dsFileSteps.cancelFileDistribution(data.getTestFileName());
        dsFileSteps.verifyFileIsNotPresent(data.getTestFileName());
    }

}
