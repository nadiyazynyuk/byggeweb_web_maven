package dk.byggeweb.project.versionsets;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import io.qameta.allure.Link;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddRemoveFileFromWorkspace extends ProjectTestBase {

    @Link(url = "https://itwofm.atlassian.net/browse/TSB-49")

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToWorkspaceModule();
        projectHomePage.getWorkspaceNodesPanel().openVersionSets();
        versionSetsSteps.openVersionSetWorkspace(data.getVersionSetName());

        try {
            versionSetsSteps.removeFileFromWorkspaceVersionSet(data.getFolderName(), data.getTestFileName());
        } catch (com.codeborne.selenide.ex.ElementNotFound ignored) {
        }

        wsFolderSteps.navigateToFolder(data.getFolderName());
        uploadFileIfNotPresentInWorkspaceFolder(data.getFileToUploadPath(), data.getTestFileName());
    }

    @Test(description = "Add file to version set")
    public void addFileToVersionSet() {
        wsFileSteps.addFileToVersionSet(data.getTestFileName(), data.getVersionSetName());
        projectHomePage.getWorkspaceNodesPanel().navigateToVersionSets();
        versionSetsSteps.navigateToVersionSetWorkspace(data.getVersionSetName());
        versionSetsSteps.verifyFileIsPresent(data.getFolderName(), data.getTestFileName());
    }

    @Test(dependsOnMethods = "addFileToVersionSet", description = "Remove file from version set")
    public void removeFileFromVersionSet() {
        versionSetsSteps.removeFileFromWorkspaceVersionSet(data.getFolderName(), data.getTestFileName());
        versionSetsSteps.verifyFileIsNotPresent(data.getFolderName(), data.getTestFileName());
    }

}