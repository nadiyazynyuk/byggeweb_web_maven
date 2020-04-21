package dk.byggeweb.project.publicationspace.nonapproval.files.delete;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import io.qameta.allure.Link;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DiscontinueFile extends ProjectTestBase {

    @Link(url = "https://itwofm.atlassian.net/browse/TSB-40")

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToPublicationSpace();
        psFolderSteps.navigateToFolderInDocumentList(data.getDocumentListName(), data.getDocumentListFolderName());
        deleteDiscontinuedFileIfPresentInDocumentListFolder(data.getTestFileName());
        uploadFileIfNotPresentInDocumentListFolder(data.getFileToUploadPath(), data.getTestFileName());
    }

    @Test(description = "Discontinue file")
    public void discontinueFile() {
        psFileSteps.discontinueFile(data.getTestFileName());
        psFileSteps.verifyFileIsDiscontinued(data.getTestFileName());
    }
}
