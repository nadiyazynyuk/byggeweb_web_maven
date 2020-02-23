package dk.byggeweb.project.publicationspace.files.delete;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeleteFile extends ProjectTestBase {

    // https://itwofm.atlassian.net/browse/TSB-39

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToPublicationSpace();
        psFolderSteps.navigateToFolderInDocumentList(data.getDocumentListName(), data.getDocumentListFolderName());
        uploadFileIfMNotPresentInDocumentListFolder(getAbsolutePath(data.getFileToUploadPath()), data.getTestFileName());
    }

    @Test(description = "Delete file permanently")
    public void deleteFile() {
        psFileSteps.deleteFile(data.getTestFileName());
        psFileSteps.verifyFileIsNotPresent(data.getTestFileName());
    }
}
