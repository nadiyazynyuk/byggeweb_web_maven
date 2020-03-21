package dk.byggeweb.project.versionsets;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateNewVersionSet extends ProjectTestBase {

    // https://itwofm.atlassian.net/browse/TSB-47

    @BeforeClass
    public void deleteVersionSetIfExists() {
        projectHomePage.navigateToWorkspaceModule();
        projectHomePage.getWorkspaceNodesPanel().openVersionSets();

        while (true) {
            try {
                versionSetsSteps.navigateToVersionSet(data.getCreateVersionSetName());
                versionSetsSteps.deleteVersionSet(data.getCreateVersionSetName());
            } catch (com.codeborne.selenide.ex.ElementNotFound e) {
                break;
            }
        }

        while (true) {
            try {
                versionSetsSteps.navigateToVersionSet(data.getRenameVersionSetName());
                versionSetsSteps.deleteVersionSet(data.getRenameVersionSetName());
            } catch (com.codeborne.selenide.ex.ElementNotFound e) {
                break;
            }
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
