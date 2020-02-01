package dk.byggeweb.project.workspace.files.update;

import dk.byggeweb.infrastructure.steps.GeneralSteps;
import dk.byggeweb.infrastructure.test.ProjectTestBase;
import dk.byggeweb.objects.project.ProjectHomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LockFile extends ProjectTestBase {

    @BeforeClass
    public void prepareData() {
        GeneralSteps.loginAsVerifiedUser(data.getUserName(), data.getPassword(), data.getName());
        GeneralSteps.launchProject(data.getProjectLink());

        projectHomePage = new ProjectHomePage(data.getProjectName());
        projectHomePage.navigateToWorkspaceModule();
        uploadFileIfNotPresentInWorkspaceFolder(data.getFolderName(), data.getFileToUploadPath(), data.getTestFileName());
    }

    @Test(description = "Lock/unlock file")
    public void lockFile() {
        String lockComment = data.getLockComment() + data.getName();
        boolean isLocked = workspaceContentPanel.isFileLocked(data.getTestFileName());

        if (isLocked) {
            workspaceContentPanel.unlockFile(data.getTestFileName());
            workspaceContentPanel.verifyFileIsUnlocked(data.getTestFileName());
        } else {
            workspaceContentPanel.lockFile(data.getTestFileName(), lockComment);
            workspaceContentPanel.verifyFileIsLocked(data.getTestFileName());
        }
    }
}
