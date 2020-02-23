package dk.byggeweb.project.workspace.files.delete;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeleteFileViaRecycleBin extends ProjectTestBase {

    // https://itwofm.atlassian.net/browse/TSB-24

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToWorkspaceModule();
        wsFolderSteps.navigateToFolder(data.getFolderName());
        uploadFileIfNotPresentInWorkspaceFolder(getAbsolutePath(data.getFileToUploadPath()), data.getTestFileName());
    }

    @Test(description = "Delete file via Recycle bin")
    public void deleteFile() {
        wsFileSteps.moveFileToRecycleBin(data.getTestFileName());
        wsFileSteps.verifyFileIsNotPresent(data.getTestFileName());
        projectHomePage.getWorkspaceNodesPanel().navigateToRecycleBin();
        while (true) {
            try {
                wsRecycleBinSteps.deleteFileFromRecycleBin(data.getTestFileName());
            } catch (com.codeborne.selenide.ex.ElementNotFound e) {
                break;
            }
        }
        wsRecycleBinSteps.verifyFileIsNotPresent(data.getTestFileName());
    }
}
