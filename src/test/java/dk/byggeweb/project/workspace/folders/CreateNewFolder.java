package dk.byggeweb.project.workspace.folders;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import dk.byggeweb.objects.project.workspace.panels.FolderContentPanel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateNewFolder extends ProjectTestBase {

    // https://itwofm.atlassian.net/browse/TSB-20

    @BeforeClass
    public void deleteFolderIfExists() {
        projectHomePage.navigateToWorkspaceModule();
        projectHomePage.getWorkspaceNodesPanel().navigateToFolder(data.getFolderName());

        while (true) {
            try {
                projectHomePage.getWorkspaceNodesPanel().navigateToFolder(data.getCreateFolderName());
                projectHomePage.getWorkspaceNodesPanel().deleteFolder(data.getFolderName());
            } catch (com.codeborne.selenide.ex.ElementNotFound e) {
                break;
            }
        }

        while (true) {
            try {
                projectHomePage.getWorkspaceNodesPanel().navigateToFolder(data.getRenameFolderName());
                projectHomePage.getWorkspaceNodesPanel().deleteFolder(data.getFolderName());
            } catch (com.codeborne.selenide.ex.ElementNotFound e) {
                break;
            }
        }
    }

    @Test(description = "Create folder in root folder")
    public void createFolder() {
        projectHomePage.getWorkspaceNodesPanel().navigateToFolder(data.getFolderName());
        FolderContentPanel folderContentPanel = new FolderContentPanel(data.getFolderName());
        folderContentPanel.createFolder(data.getCreateFolderName());
        folderContentPanel.verifyFolderIsPresent(data.getCreateFolderName());
    }

    @Test(dependsOnMethods = "createFolder", description = "Rename folder")
    public void renameFolder() {
        projectHomePage.getWorkspaceNodesPanel().navigateToFolder(data.getCreateFolderName());
        FolderContentPanel folderContentPanel = new FolderContentPanel(data.getCreateFolderName());
        folderContentPanel.renameFolder(data.getRenameFolderName());
        folderContentPanel.verifyFolderIsPresent(data.getRenameFolderName());
    }

    @Test(dependsOnMethods = "renameFolder", description = "Delete folder")
    public void deleteFolder() {
        projectHomePage.getWorkspaceNodesPanel().navigateToFolder(data.getRenameFolderName());
        FolderContentPanel folderContentPanel = new FolderContentPanel(data.getRenameFolderName());
        folderContentPanel.deleteFolder(data.getRenameFolderName());
        folderContentPanel.verifyFolderIsNotPresent(data.getRenameFolderName());
    }

}
