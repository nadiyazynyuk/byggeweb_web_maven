package dk.byggeweb.project.workspace.files.update;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MoveFile extends ProjectTestBase {

    // https://itwofm.atlassian.net/browse/TSB-26

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToWorkspaceModule();
        uploadFileIfNotPresentInWorkspaceFolder(data.getFolder1Name(), data.getFileToUploadPath(), data.getTestFileName());
        deleteFileIfPresentInWorkspaceFolder(data.getFolder2Name(), data.getTestFileName());
    }

    @Test(description = "Move file to another folder")
    public void moveFile() {
        folderSteps.navigateToFolder(data.getFolder1Name());
        fileSteps.moveFileToFolder(data.getTestFileName(), data.getFolder2Name(), data.getFolderName());
        fileSteps.verifyFileIsNotPresent(data.getTestFileName());

        folderSteps.navigateToFolder(data.getFolder2Name());
        fileSteps.verifyFileIsPresent(data.getTestFileName());
    }
}
