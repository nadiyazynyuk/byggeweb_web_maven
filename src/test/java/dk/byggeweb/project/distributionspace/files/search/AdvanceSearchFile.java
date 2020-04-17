package dk.byggeweb.project.distributionspace.files.search;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import io.qameta.allure.Link;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AdvanceSearchFile extends ProjectTestBase {

    @Link(url = "https://itwofm.atlassian.net/browse/TSB-80")

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToDistributionSpace();
        dsFolderSteps.navigateToFolderInDocumentListInDistributionList(data.getDistributionListName(), data.getDocumentListName(), data.getDocumentListFolderName());

        try {
            dsFileSteps.verifyFileIsPresent(data.getTestFileName());
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            projectHomePage.navigateToPublicationSpace();
            psFolderSteps.navigateToFolderInDocumentList(data.getDocumentListName(), data.getDocumentListFolderName());
            uploadFileIfNotPresentInDocumentListFolder(data.getFileToUploadPath(), data.getTestFileName());
            psFileSteps.distributeFile(data.getTestFileName(), data.getDistributionListName());
            projectHomePage.navigateToDistributionSpace();
        }
    }

    @Test(description = "Advanced search for the file by filename in Publication space")
    public void advancedSearchFileByName() {
        searchSteps.advancedSearchFileByNameInDistributionSpace(data.getTestFileName());
        dsFileSteps.verifyFileIsPresent(data.getTestFileName());
    }

}
