package dk.byggeweb.project.workspace.folders;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import dk.byggeweb.steps.project.workspace.FolderSteps;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateNewFolder extends ProjectTestBase {

    // https://itwofm.atlassian.net/browse/TSB-20

    @BeforeClass
    public void deleteFolderIfExists() {
        projectHomePage.navigateToWorkspaceModule();
        folderSteps = new FolderSteps();
        folderSteps.navigateToFolder(data.getFolderName());

        while (true) {
            try {
                folderSteps.navigateToFolder(data.getCreateFolderName());
                folderSteps.deleteFolder(data.getFolderName());
            } catch (com.codeborne.selenide.ex.ElementNotFound e) {
                break;
            }
        }

        while (true) {
            try {
                folderSteps.navigateToFolder(data.getRenameFolderName());
                folderSteps.deleteFolder(data.getFolderName());
            } catch (com.codeborne.selenide.ex.ElementNotFound e) {
                break;
            }
        }
    }

    @Test(description = "Create folder in root folder")
    public void createFolder() {
        folderSteps.navigateToFolder(data.getFolderName());
        folderSteps.createFolder(data.getFolderName(), data.getCreateFolderName());
        folderSteps.verifyFolderIsPresent(data.getCreateFolderName());
    }

    @Test(dependsOnMethods = "createFolder", description = "Rename folder")
    public void renameFolder() {
        folderSteps.navigateToFolder(data.getCreateFolderName());
        folderSteps.renameFolder(data.getCreateFolderName(), data.getRenameFolderName());
        folderSteps.verifyFolderIsPresent(data.getRenameFolderName());
    }

    @Test(dependsOnMethods = "renameFolder", description = "Delete folder")
    public void deleteFolder() {
        folderSteps.navigateToFolder(data.getRenameFolderName());
        folderSteps.deleteFolder(data.getFolderName());
        folderSteps.verifyFolderIsNotPresent(data.getRenameFolderName());
    }

}
