package dk.byggeweb.project.versionsets;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import io.qameta.allure.Link;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateNewVersionSet extends ProjectTestBase {

    @Link(url = "https://itwofm.atlassian.net/browse/TSB-47")

    @BeforeClass
    public void deleteVersionSetIfExists() {
        projectHomePage.navigateToWorkspaceModule();
        projectHomePage.getWorkspaceNodesPanel().openVersionSets();

        try {
            versionSetsSteps.navigateToVersionSet(data.getCreateVersionSetName());
            versionSetsSteps.deleteVersionSet(data.getCreateVersionSetName());
        } catch (com.codeborne.selenide.ex.ElementNotFound ignored) {
        }

        try {
            versionSetsSteps.navigateToVersionSet(data.getRenameVersionSetName());
            versionSetsSteps.deleteVersionSet(data.getRenameVersionSetName());
        } catch (com.codeborne.selenide.ex.ElementNotFound ignored) {
        }
    }

    @Test(description = "Create new version set")
    public void createVersionSet() {
        versionSetsSteps.createVersionSet(data.getCreateVersionSetName());
        versionSetsSteps.verifyVersionSetIsPresent(data.getCreateVersionSetName());
    }

    @Test(dependsOnMethods = "createVersionSet", description = "Rename version set")
    public void renameVersionSet() {
        versionSetsSteps.renameVersionSet(data.getCreateVersionSetName(), data.getRenameVersionSetName());
        versionSetsSteps.verifyVersionSetIsPresent(data.getRenameVersionSetName());
    }

    @Test(dependsOnMethods = "renameVersionSet", description = "Delete version set")
    public void deleteVersionSet() {
        versionSetsSteps.deleteVersionSet(data.getRenameVersionSetName());
        versionSetsSteps.verifyVersionSetIsNotPresent(data.getRenameVersionSetName());
    }
}
