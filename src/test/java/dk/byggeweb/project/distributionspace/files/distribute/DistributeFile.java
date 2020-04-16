package dk.byggeweb.project.distributionspace.files.distribute;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import io.qameta.allure.Link;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DistributeFile extends ProjectTestBase {

    @Link(url = "https://itwofm.atlassian.net/browse/TSB-75")

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToDistributionSpace();
        dsFolderSteps.navigateToFolderInDocumentListInDistributionList(data.getDistributionListName(), data.getDocumentListName(), data.getDocumentListFolderName());

        try {
            dsFileSteps.cancelFileDistribution(data.getTestFileName());
        } catch (com.codeborne.selenide.ex.ElementNotFound ignored) {}

        projectHomePage.navigateToPublicationSpace();
        psFolderSteps.navigateToFolderInDocumentList(data.getDocumentListName(), data.getDocumentListFolderName());
        uploadFileIfMNotPresentInDocumentListFolder(data.getFileToUploadPath(), data.getTestFileName());
    }

    @Test(description = "Distribute file inside Distribution list")
    public void distributeFile() {
        projectHomePage.navigateToDistributionSpace();
        dsFolderSteps.navigateToDistributionList(data.getDistributionListName());
        dsFolderSteps.distributeFile(data.getTestFileName());
        dsFileSteps.verifyFileIsPresent(data.getTestFileName());
    }

}
