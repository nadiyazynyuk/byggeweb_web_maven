package dk.byggeweb.project.publicationspace.files.update;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import io.qameta.allure.Link;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DistributeFile extends ProjectTestBase {

    @Link(url = "https://itwofm.atlassian.net/browse/TSB-70")

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToDistributionSpace();
        dsFolderSteps.navigateToFolderInDocumentListInDistributionList(data.getDistributionListName(), data.getDocumentListName(), data.getDocumentListFolderName());

        try {
            dsFileSteps.cancelFileDistribution(data.getTestFileName());
        } catch (com.codeborne.selenide.ex.ElementNotFound ignored) {
        }

        projectHomePage.navigateToPublicationSpace();
        psFolderSteps.navigateToFolderInDocumentList(data.getDocumentListName(), data.getDocumentListFolderName());
        uploadFileIfMNotPresentInDocumentListFolder(data.getFileToUploadPath(), data.getTestFileName());
    }

    @Test(description = "Distribute file from Document list")
    public void distributeFile() {
        psFileSteps.distributeFile(data.getTestFileName(), data.getDistributionListName());
        projectHomePage.navigateToDistributionSpace();
        dsFileSteps.verifyFileIsPresent(data.getTestFileName());
    }

}