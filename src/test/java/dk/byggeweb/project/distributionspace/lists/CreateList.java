package dk.byggeweb.project.distributionspace.lists;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import io.qameta.allure.Link;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateList extends ProjectTestBase {

    @Link(url = "https://itwofm.atlassian.net/browse/TSB-72")

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToDistributionSpace();

        try {
            dsFolderSteps.navigateToDistributionList(data.getCreateListName());
            dsFolderSteps.deleteDistributionList();
        } catch (com.codeborne.selenide.ex.ElementNotFound ignored) {}

        try {
            dsFolderSteps.navigateToDistributionList(data.getRenameListName());
            dsFolderSteps.deleteDistributionList();
        } catch (com.codeborne.selenide.ex.ElementNotFound ignored) {}

    }

    @Test(description = "Create new Distribution list")
    public void createList() {
        dsFolderSteps.createCoordinatorDistributionList(data.getCreateListName());
        dsFolderSteps.verifyListIsPresent(data.getCreateListName());
    }

    @Test(dependsOnMethods = "createList", description = "Rename Distribution list")
    public void renameList() {
        dsFolderSteps.renameDistributionList(data.getCreateListName(), data.getRenameListName());
        dsFolderSteps.verifyListIsPresent(data.getRenameListName());
    }

    @Test(dependsOnMethods = "renameList", description = "Delete Distribution list")
    public void deleteList() {
        dsFolderSteps.deleteDistributionList();
        dsFolderSteps.verifyListIsNotPresent(data.getRenameListName());
    }

}
