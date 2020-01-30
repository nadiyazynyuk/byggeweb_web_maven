package dk.byggeweb.project.workspace.files.update;

import dk.byggeweb.infrastructure.steps.GeneralSteps;
import dk.byggeweb.infrastructure.test.ProjectTestBase;
import dk.byggeweb.objects.pages.project.ProjectHomePage;
import dk.byggeweb.objects.pages.project.workspace.panels.WorkspaceContentPanel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CopyFile extends ProjectTestBase {

    // https://itwofm.atlassian.net/browse/TSB-27

    @BeforeClass
    public void prepareData() {
        GeneralSteps.loginAsVerifiedUser(data.getUserName(), data.getPassword(), data.getName());
        GeneralSteps.launchProject(data.getProjectLink());

        projectHomePage = new ProjectHomePage(data.getProjectName());
        projectHomePage.navigateToWorkspaceModule();

        deleteFileIfPresentInWorkspaceFolder(data.getFolder1Name(), data.getTestFileName());
        deleteFileIfPresentInWorkspaceFolder(data.getFolder2Name(), data.getTestFileName());
        uploadFileIfNotPresentInWorkspaceFolder(data.getFolder1Name(), data.getFileToUploadPath(), data.getTestFileName());
    }

    @Test(description = "Copy file to another folder")
    public void copyFile() {
        projectHomePage.getWorkspaceNodesPanel().clickOnFolder(data.getFolder1Name());
        workspaceContentPanel = new WorkspaceContentPanel(data.getFolder1Name());

        workspaceContentPanel.copyFileToFolder(data.getTestFileName(), data.getFolder2Name(), data.getFolderName());
        workspaceContentPanel.verifyFileIsPresent(data.getTestFileName());

        projectHomePage.getWorkspaceNodesPanel().clickOnFolder(data.getFolder2Name());
        workspaceContentPanel = new WorkspaceContentPanel(data.getFolder2Name());
        workspaceContentPanel.verifyFileIsPresent(data.getTestFileName());
    }

}
