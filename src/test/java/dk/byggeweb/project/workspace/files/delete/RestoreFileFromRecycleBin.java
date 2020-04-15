package dk.byggeweb.project.workspace.files.delete;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import io.qameta.allure.Link;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RestoreFileFromRecycleBin extends ProjectTestBase {

    @Link(url = "https://itwofm.atlassian.net/browse/TSB-25")

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToWorkspaceModule();

        projectHomePage.getWorkspaceNodesPanel().navigateToRecycleBin();
        deleteFileIfPresentInWorkspaceFolder(data.getTestFileName());

        wsFolderSteps.navigateToFolder(data.getFolderName());
        uploadFileIfNotPresentInWorkspaceFolder(data.getFileToUploadPath(), data.getTestFileName());
        placeFileInRecycleBin();
    }

    @Test(description = "Restore file from Recycle bin")
    public void restoreFile() {
        projectHomePage.getWorkspaceNodesPanel().navigateToRecycleBin();
        wsRecycleBinSteps.restoreFile(data.getTestFileName(), data.getFolderName());
        projectHomePage.getWorkspaceNodesPanel().navigateToFolder(data.getFolderName());
        wsFileSteps.verifyFileIsPresent(data.getTestFileName());
    }

    private void placeFileInRecycleBin() {
        wsFileSteps.moveFileToRecycleBin(data.getTestFileName());
        wsFileSteps.verifyFileIsNotPresent(data.getTestFileName());
    }
}
