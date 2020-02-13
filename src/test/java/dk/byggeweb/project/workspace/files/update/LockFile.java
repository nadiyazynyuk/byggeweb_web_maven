package dk.byggeweb.project.workspace.files.update;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LockFile extends ProjectTestBase {

    // https://itwofm.atlassian.net/browse/TSB-28

    private boolean isLocked;

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToWorkspaceModule();
        uploadFileIfNotPresentInWorkspaceFolder(data.getFolderName(), data.getFileToUploadPath(), data.getTestFileName());
        isLocked = fileSteps.getFileLockStatus(data.getTestFileName());
    }

    @Test(description = "Lock/unlock file")
    public void lockFile() {
        fileSteps.lockFile(data.getTestFileName());
        if (isLocked) {
            fileSteps.verifyFileIsUnlocked(data.getTestFileName());
        } else {
            fileSteps.verifyFileIsLocked(data.getTestFileName());
        }
    }

}
