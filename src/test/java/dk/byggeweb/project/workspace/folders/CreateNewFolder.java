package dk.byggeweb.project.workspace.folders;

import dk.byggeweb.infrastructure.steps.GeneralSteps;
import dk.byggeweb.infrastructure.test.ProjectTestBase;
import dk.byggeweb.objects.project.ProjectHomePage;
import dk.byggeweb.objects.project.workspace.panels.WorkspaceNodesPanel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateNewFolder extends ProjectTestBase {

    // https://itwofm.atlassian.net/browse/TSB-20

    @BeforeClass
    public void deleteFolderIfExists() {
        projectHomePage = new ProjectHomePage(data.getProjectName());
        projectHomePage.navigateToWorkspaceModule();
        projectHomePage.getWorkspaceNodesPanel().clickOnFolder(data.getFolderName());

        while (true) {
            try {
                projectHomePage.getWorkspaceNodesPanel().clickOnFolder(data.getCreateFolderName());
                projectHomePage.getWorkspaceNodesPanel().deleteFolder(data.getFolderName());
            } catch (com.codeborne.selenide.ex.ElementNotFound e) {
                break;
            }
        }

        while (true) {
            try {
                projectHomePage.getWorkspaceNodesPanel().clickOnFolder(data.getRenameFolderName());
                projectHomePage.getWorkspaceNodesPanel().deleteFolder(data.getFolderName());
            } catch (com.codeborne.selenide.ex.ElementNotFound e) {
                break;
            }
        }
    }

    @Test(description = "Create folder in root folder")
    public void createFolder() {
        projectHomePage.getWorkspaceNodesPanel().clickOnFolder(data.getFolderName());
        WorkspaceNodesPanel workspaceNodesPanel = new WorkspaceNodesPanel(data.getFolderName());
        workspaceNodesPanel.createFolder(data.getCreateFolderName());
        workspaceNodesPanel.verifyFolderIsPresent(data.getCreateFolderName());
    }

    @Test(dependsOnMethods = "createFolder", description = "Rename folder")
    public void renameFolder() {
        projectHomePage.getWorkspaceNodesPanel().clickOnFolder(data.getCreateFolderName());
        WorkspaceNodesPanel workspaceNodesPanel = new WorkspaceNodesPanel(data.getCreateFolderName());
        workspaceNodesPanel.renameFolder(data.getRenameFolderName());
        workspaceNodesPanel.verifyFolderIsPresent(data.getRenameFolderName());
    }

    @Test(dependsOnMethods = "renameFolder", description = "Delete folder")
    public void deleteFolder() {
        projectHomePage.getWorkspaceNodesPanel().clickOnFolder(data.getRenameFolderName());
        WorkspaceNodesPanel workspaceNodesPanel = new WorkspaceNodesPanel(data.getRenameFolderName());
        workspaceNodesPanel.deleteFolder(data.getRenameFolderName());
        workspaceNodesPanel.verifyFolderIsNotPresent(data.getRenameFolderName());
    }

}
