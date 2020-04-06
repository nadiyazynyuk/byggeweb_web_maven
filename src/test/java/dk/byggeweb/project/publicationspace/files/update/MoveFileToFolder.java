package dk.byggeweb.project.publicationspace.files.update;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MoveFileToFolder extends ProjectTestBase {

    // https://itwofm.atlassian.net/browse/TSB-68

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToPublicationSpace();

        psFolderSteps.navigateToFolderInDocumentList(data.getDocumentListName(), data.getDocumentListFolder2Name());
        deleteFileIfPresentInDocumentListFolder(data.getTestFileName());

        psFolderSteps.navigateToFolderInsideDocumentList(data.getDocumentListFolderName());
        uploadFileIfMNotPresentInDocumentListFolder(data.getFileToUploadPath(), data.getTestFileName());
    }

    @Test(description = "Move file to another folder inside one Document list")
    public void moveFileToAnotherFolder() {
        psFileSteps.moveFile(data.getTestFileName(), data.getDocumentListFolder2Name());
        psFileSteps.verifyFileIsNotPresent(data.getTestFileName());

        psFolderSteps.navigateToFolderInsideDocumentList(data.getDocumentListFolder2Name());
        psFileSteps.verifyFileIsPresent(data.getTestFileName());
    }

}
