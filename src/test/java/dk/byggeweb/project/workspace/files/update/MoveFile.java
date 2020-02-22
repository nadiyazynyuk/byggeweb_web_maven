package dk.byggeweb.project.workspace.files.update;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MoveFile extends ProjectTestBase {

    // https://itwofm.atlassian.net/browse/TSB-26

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToWorkspaceModule();

        wsFolderSteps.navigateToFolder(data.getFolder1Name());
        uploadFileIfNotPresentInWorkspaceFolder(data.getFileToUploadPath(), data.getTestFileName());

        wsFolderSteps.navigateToFolder(data.getFolder2Name());
        deleteFileIfPresentInWorkspaceFolder(data.getTestFileName());
    }

    @Test(description = "Move file to another folder")
    public void moveFile() {
        wsFolderSteps.navigateToFolder(data.getFolder1Name());
        wsFileSteps.moveFileToFolder(data.getTestFileName(), data.getFolder2Name(), data.getFolderName());
        wsFileSteps.verifyFileIsNotPresent(data.getTestFileName());

        wsFolderSteps.navigateToFolder(data.getFolder2Name());
        wsFileSteps.verifyFileIsPresent(data.getTestFileName());
    }
}
