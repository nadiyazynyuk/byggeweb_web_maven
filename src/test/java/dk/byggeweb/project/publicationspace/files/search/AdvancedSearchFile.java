package dk.byggeweb.project.publicationspace.files.search;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AdvancedSearchFile extends ProjectTestBase {

    // https://itwofm.atlassian.net/browse/TSB-58

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToPublicationSpace();
        psFolderSteps.navigateToFolderInDocumentList(data.getDocumentListName(), data.getDocumentListFolderName());
        uploadFileIfMNotPresentInDocumentListFolder(data.getFileToUploadPath(), data.getTestFileName());
    }

    @Test(description = "Advanced search for the file by filename in Publication space")
    public void advancedSearchFileByName() {
        searchSteps.advancedSearchFileByNameInPublicationSpace(data.getTestFileName());
        psFileSteps.verifyFileIsPresent(data.getTestFileName());
    }

}
