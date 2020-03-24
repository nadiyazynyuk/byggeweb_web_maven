package dk.byggeweb.project.publicationspace.lists;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateNewEmptyList extends ProjectTestBase {

    // https://itwofm.atlassian.net/browse/TSB-51

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToPublicationSpace();

        while (true) {
            try {
                psFolderSteps.navigateToDocumentList(data.getCreateListName());
                psFolderSteps.deleteDocumentList();
            } catch (com.codeborne.selenide.ex.ElementNotFound e) {
                break;
            }
        }

        while (true) {
            try {
                psFolderSteps.navigateToDocumentList(data.getRenameListName());
                psFolderSteps.deleteDocumentList();
            } catch (com.codeborne.selenide.ex.ElementNotFound e) {
                break;
            }
        }
    }

    @Test(description = "Create new Document list")
    public void createList() {
        psFolderSteps.createDocumentList(data.getCreateListName());
        psFolderSteps.verifyListIsPresent(data.getCreateListName());
    }

    @Test(dependsOnMethods = "createList", description = "Rename Document list")
    public void renameList() {
        psFolderSteps.renameDocumentList(data.getRenameListName());
        psFolderSteps.verifyListIsPresent(data.getRenameListName());
    }

    @Test(dependsOnMethods = "renameList", description = "Delete Document list")
    public void deleteList() {
        psFolderSteps.deleteDocumentList();
        psFolderSteps.verifyListIsNotPresent(data.getRenameListName());
    }
}
