package dk.byggeweb.project.workspace.folders;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import io.qameta.allure.Link;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateNewFolder extends ProjectTestBase {

    @Link(url = "https://itwofm.atlassian.net/browse/TSB-20")

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToWorkspaceModule();
        wsFolderSteps.navigateToFolder(data.getFolderName());

        try {
            wsFolderSteps.navigateToFolder(data.getCreateFolderName());
            wsFolderSteps.deleteFolder(data.getFolderName());
        } catch (com.codeborne.selenide.ex.ElementNotFound ignored) {
        }

        try {
            wsFolderSteps.navigateToFolder(data.getRenameFolderName());
            wsFolderSteps.deleteFolder(data.getFolderName());
        } catch (com.codeborne.selenide.ex.ElementNotFound ignored) {
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
