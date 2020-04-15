package dk.byggeweb.project.workspace.files.update;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import io.qameta.allure.Link;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LockFile extends ProjectTestBase {

    private boolean isLocked;

    @Link(url = "https://itwofm.atlassian.net/browse/TSB-28")

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToWorkspaceModule();
        wsFolderSteps.navigateToFolder(data.getFolderName());
        uploadFileIfNotPresentInWorkspaceFolder(data.getFileToUploadPath(), data.getTestFileName());
        isLocked = wsFileSteps.getFileLockStatus(data.getTestFileName());
    }

    @Test(description = "Lock/unlock file")
    public void lockFile() {
        wsFileSteps.lockFile(data.getTestFileName());
        if (isLocked) {
            wsFileSteps.verifyFileIsUnlocked(data.getTestFileName());
        } else {
            wsFileSteps.verifyFileIsLocked(data.getTestFileName());
        }
    }

}
