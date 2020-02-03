package dk.byggeweb.project.workspace.files.update;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LockFile extends ProjectTestBase {

    // https://itwofm.atlassian.net/browse/TSB-28

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToWorkspaceModule();
        uploadFileIfNotPresentInWorkspaceFolder(data.getFolderName(), data.getFileToUploadPath(), data.getTestFileName());
    }

    @Test(description = "Lock/unlock file")
    public void lockFile() {
        boolean isLocked = folderContentPanel.isFileLocked(data.getTestFileName());
        folderContentPanel.lockFile(data.getTestFileName());
        if (isLocked) {
            folderContentPanel.verifyFileIsUnlocked(data.getTestFileName());
        } else {
            folderContentPanel.verifyFileIsLocked(data.getTestFileName());
        }
    }
}
