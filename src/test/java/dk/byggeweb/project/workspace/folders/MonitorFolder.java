package dk.byggeweb.project.workspace.folders;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import io.qameta.allure.Link;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MonitorFolder extends ProjectTestBase {

    @Link(url = "https://itwofm.atlassian.net/browse/TSB-43")

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToWorkspaceModule();
        projectHomePage.getWorkspaceNodesPanel().navigateToMonitoredFolders();

        try {
            wsMonitorFoldersSteps.stopMonitorFolder(data.getFolderName());
            wsMonitorFoldersSteps.verifyFolderIsNotPresent(data.getFolderName());
        } catch (com.codeborne.selenide.ex.ElementNotFound ignored) {
        }
    }

    @Test(description = "Start Workspace folder monitoring")
    public void monitorFolder() {
        projectHomePage.getWorkspaceNodesPanel().navigateToFolder(data.getFolderName());
        wsFolderSteps.startMonitorFolder();
        projectHomePage.getWorkspaceNodesPanel().navigateToMonitoredFolders();
        wsMonitorFoldersSteps.verifyFolderIsPresent(data.getFolderName());
    }
}