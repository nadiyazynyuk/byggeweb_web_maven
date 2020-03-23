package dk.byggeweb.project.publicationspace.lists;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateNewFolder extends ProjectTestBase {

    // https://itwofm.atlassian.net/browse/TSB-52

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToPublicationSpace();
        psFolderSteps.openDocumentList(data.getDocumentListName());

        while (true) {
            try {
                psFolderSteps.navigateToFolderInsideDocumentList(data.getCreateFolderName());
                psFolderSteps.deleteFolder();
            } catch (com.codeborne.selenide.ex.ElementNotFound e) {
                break;
            }
        }

        while (true) {
            try {
                psFolderSteps.navigateToFolderInsideDocumentList(data.getRenameFolderName());
                psFolderSteps.deleteFolder();
            } catch (com.codeborne.selenide.ex.ElementNotFound e) {
                break;
            }
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
        psFolderSteps.deleteFolder();
        psFolderSteps.verifyFolderIsNotPresent(data.getRenameFolderName());
    }

}
