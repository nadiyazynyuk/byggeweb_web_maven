package dk.byggeweb.project.publicationspace.withapproval.files.search;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import io.qameta.allure.Link;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class QuickSearchFile extends ProjectTestBase {

    @Link(url = "https://itwofm.atlassian.net/browse/TSB-57")

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToPublicationSpace();
        psFolderSteps.navigateToFolderInDocumentList(data.getDocumentListName(), data.getDocumentListFolderName());
        uploadFileIfNotPresentInDocumentListWithApprovalFolder(data.getFileToUploadPath(), data.getTestFileName());
    }

    @Test(description = "Quick search for the file in Publication space")
    public void quickSearchFile() {
        searchSteps.quickSearchFileInPublicationSpace(data.getTestFileName());
        psFileSteps.verifyFileIsPresent(data.getTestFileName());
    }
}
