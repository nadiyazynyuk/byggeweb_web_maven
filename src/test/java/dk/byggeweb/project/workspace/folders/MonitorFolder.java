package dk.byggeweb.project.workspace.folders;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MonitorFolder extends ProjectTestBase {

    // https://itwofm.atlassian.net/browse/TSB-43

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToWorkspaceModule();
        projectHomePage.getWorkspaceNodesPanel().navigateToMonitoredFolders();
        while (true) {
            try {
                wsMonitorFoldersSteps.stopMonitorFolder(data.getFolderName());
                wsMonitorFoldersSteps.verifyFolderIsNotPresent(data.getFolderName());
            } catch (com.codeborne.selenide.ex.ElementNotFound e) {
                break;
            }
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