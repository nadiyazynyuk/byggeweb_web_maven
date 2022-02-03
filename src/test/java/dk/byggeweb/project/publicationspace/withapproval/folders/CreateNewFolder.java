package dk.byggeweb.project.publicationspace.withapproval.folders;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import io.qameta.allure.Link;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateNewFolder extends ProjectTestBase {

    @Link(url = "https://itwofm.atlassian.net/browse/TSB-52")

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToPublicationSpace();
        psFolderSteps.openDocumentList(data.getDocumentListName());

        try {
            psFolderSteps.navigateToFolderInsideDocumentList(data.getCreateFolderName());
            psFolderSteps.deleteFolder();
        } catch (com.codeborne.selenide.ex.ElementNotFound ignored) {
        }

        try {
            psFolderSteps.navigateToFolderInsideDocumentList(data.getRenameFolderName());
            psFolderSteps.deleteFolder();
        } catch (com.codeborne.selenide.ex.ElementNotFound ignored) {
        }

    }

    @Test(description = "Create folder in Document list")
    public void createFolder() {
        psFolderSteps.createFolder(data.getCreateFolderName());
        psFolderSteps.verifyFolderIsPresent(data.getCreateFolderName());
    }

    @Test(dependsOnMethods = "createFolder", description = "Rename folder in Document list")
    public void renameFolder() {
        psFolderSteps.navigateToFolderInsideDocumentList(data.getCreateFolderName());
        psFolderSteps.renameFolder(data.getRenameFolderName());
        psFolderSteps.verifyFolderIsPresent(data.getRenameFolderName());
    }

    @Test(dependsOnMethods = "renameFolder", description = "Delete folder in Document list")
    void deleteFolder() {
        psFolderSteps.navigateToFolderInsideDocumentList(data.getRenameFolderName());
        psFolderSteps.deleteFolder();
        psFolderSteps.verifyFolderIsNotPresent(data.getRenameFolderName());
    }
}
