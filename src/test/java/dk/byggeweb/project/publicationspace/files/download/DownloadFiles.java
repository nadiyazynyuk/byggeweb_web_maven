package dk.byggeweb.project.publicationspace.files.download;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import io.qameta.allure.Link;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DownloadFiles extends ProjectTestBase {

    @Link(url = "https://itwofm.atlassian.net/browse/TSB-42")

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToPublicationSpace();
        psFolderSteps.navigateToFolderInDocumentList(data.getDocumentListName(), data.getDocumentListFolderName());
        uploadFileIfNotPresentInDocumentListFolder(data.getFileToUploadPath(), data.getTestFileName());
        uploadFileIfNotPresentInDocumentListFolder(data.getFileToUploadPath2(), data.getTestFileName2());
    }

    @Test(description = "Download multiple files (generate download files link) from Document list folder")
    public void downloadFiles() {
        psFileSteps.generateDownloadFilesLink(data.getTestFileName());
    }
}
