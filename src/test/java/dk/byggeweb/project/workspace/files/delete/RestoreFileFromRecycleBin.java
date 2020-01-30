package dk.byggeweb.project.workspace.files.delete;

import dk.byggeweb.infrastructure.steps.GeneralSteps;
import dk.byggeweb.infrastructure.test.ProjectTestBase;
import dk.byggeweb.objects.pages.project.ProjectHomePage;
import dk.byggeweb.objects.pages.project.workspace.panels.RecycleBinContentPanel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RestoreFileFromRecycleBin extends ProjectTestBase {

    // https://itwofm.atlassian.net/browse/TSB-25

    @BeforeClass
    public void prepareData() {
        GeneralSteps.loginAsVerifiedUser(data.getUserName(), data.getPassword(), data.getName());
        GeneralSteps.launchProject(data.getProjectLink());

        projectHomePage = new ProjectHomePage(data.getProjectName());
        projectHomePage.navigateToWorkspaceModule();

        deleteFileIfPresentInWorkspaceFolder("Recycle bin", data.getTestFileName());
        uploadFileIfNotPresentInWorkspaceFolder(data.getFolderName(), data.getFileToUploadPath(), data.getTestFileName());
        placeFileInRecycleBin();
    }

    @Test(description = "Restore file from Recycle bin")
    public void restoreFile() {
        projectHomePage.getWorkspaceNodesPanel().getRecycleBinNode().click();
        RecycleBinContentPanel recycleBinContentPanel = new RecycleBinContentPanel("Recycle bin");
        recycleBinContentPanel.restoreFile(data.getTestFileName(), data.getFolderName());
        projectHomePage.getWorkspaceNodesPanel().clickOnFolder(data.getFolderName());
        workspaceContentPanel.verifyFileIsPresent(data.getTestFileName());
    }

    private void placeFileInRecycleBin() {
        workspaceContentPanel.moveFileToRecycleBin(data.getTestFileName());
        workspaceContentPanel.verifyFileIsNotPresent(data.getTestFileName());
    }
}
