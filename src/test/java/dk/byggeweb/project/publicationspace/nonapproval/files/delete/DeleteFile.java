package dk.byggeweb.project.publicationspace.nonapproval.files.delete;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import io.qameta.allure.Link;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeleteFile extends ProjectTestBase {

    @Link(url = "https://itwofm.atlassian.net/browse/TSB-39")

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToPublicationSpace();
        psFolderSteps.navigateToFolderInDocumentList(data.getDocumentListName(), data.getDocumentListFolderName());
        uploadFileIfNotPresentInDocumentListFolder(data.getFileToUploadPath(), data.getTestFileName());
    }

    @Test(description = "Delete file permanently")
    public void deleteFile() {
        psFileSteps.deleteFile(data.getTestFileName());
        psFileSteps.verifyFileIsNotPresent(data.getTestFileName());
    }
}
