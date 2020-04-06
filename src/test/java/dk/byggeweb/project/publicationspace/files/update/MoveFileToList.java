package dk.byggeweb.project.publicationspace.files.update;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MoveFileToList extends ProjectTestBase {

    // https://itwofm.atlassian.net/browse/TSB-69

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToPublicationSpace();

        psFolderSteps.navigateToFolderInDocumentList(data.getDocumentList2Name(), data.getDocumentListFolder2Name());
        deleteFileIfPresentInDocumentListFolder(data.getTestFileName());

        psFolderSteps.navigateToFolderInDocumentList(data.getDocumentListName(), data.getDocumentListFolderName());
        uploadFileIfMNotPresentInDocumentListFolder(data.getFileToUploadPath(), data.getTestFileName());
    }

    @Test(description = "Move file to the folder in another Document list")
    public void moveFileToAnotherList() {
        psFileSteps.moveFile(data.getTestFileName(), data.getDocumentListFolder2Name());
        psFileSteps.verifyFileIsNotPresent(data.getTestFileName());

        psFolderSteps.navigateToFolderInsideDocumentList(data.getDocumentListFolder2Name());
        psFileSteps.verifyFileIsPresent(data.getTestFileName());
    }
}
