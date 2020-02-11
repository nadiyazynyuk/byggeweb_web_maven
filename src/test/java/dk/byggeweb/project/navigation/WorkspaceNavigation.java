package dk.byggeweb.project.navigation;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import org.testng.annotations.Test;

public class WorkspaceNavigation extends ProjectTestBase {

    @Test(description = "Navigate through Workspace nodes")
    public void workspaceNavigation() {
        projectHomePage.navigateToWorkspaceModule();

        projectHomePage.getWorkspaceNodesPanel().navigateToRootFolder();
        projectHomePage.getWorkspaceNodesPanel().navigateToVersionSets();
        projectHomePage.getWorkspaceNodesPanel().navigateToRecycleBin();
        projectHomePage.getWorkspaceNodesPanel().navigateToMonitoredFolders();
        projectHomePage.getWorkspaceNodesPanel().navigateToMonitoredFiles();
        projectHomePage.getWorkspaceNodesPanel().navigateToSinceLastTime();
        projectHomePage.getWorkspaceNodesPanel().navigateToSearchResult();
    }
}
