package dk.byggeweb.project.workspace.folders;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import dk.byggeweb.steps.project.workspace.WSFolderSteps;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateNewFolder extends ProjectTestBase {

    // https://itwofm.atlassian.net/browse/TSB-20

    @BeforeClass
    public void deleteFolderIfExists() {
        projectHomePage.navigateToWorkspaceModule();
        wsFolderSteps = new WSFolderSteps();
        wsFolderSteps.navigateToFolder(data.getFolderName());

        while (true) {
            try {
                wsFolderSteps.navigateToFolder(data.getCreateFolderName());
                wsFolderSteps.deleteFolder(data.getFolderName());
            } catch (com.codeborne.selenide.ex.ElementNotFound e) {
                break;
            }
        }

        while (true) {
            try {
                wsFolderSteps.navigateToFolder(data.getRenameFolderName());
                wsFolderSteps.deleteFolder(data.getFolderName());
            } catch (com.codeborne.selenide.ex.ElementNotFound e) {
                break;
            }
        }
    }

    @Test(description = "Create folder in root folder")
    public void createFolder() {
        wsFolderSteps.navigateToFolder(data.getFolderName());
        wsFolderSteps.createFolder(data.getFolderName(), data.getCreateFolderName());
        wsFolderSteps.verifyFolderIsPresent(data.getCreateFolderName());
    }

    @Test(dependsOnMethods = "createFolder", description = "Rename folder")
    public void renameFolder() {
        wsFolderSteps.navigateToFolder(data.getCreateFolderName());
        wsFolderSteps.renameFolder(data.getCreateFolderName(), data.getRenameFolderName());
        wsFolderSteps.verifyFolderIsPresent(data.getRenameFolderName());
    }

    @Test(dependsOnMethods = "renameFolder", description = "Delete folder")
    public void deleteFolder() {
        wsFolderSteps.navigateToFolder(data.getRenameFolderName());
        wsFolderSteps.deleteFolder(data.getFolderName());
        wsFolderSteps.verifyFolderIsNotPresent(data.getRenameFolderName());
    }

}
