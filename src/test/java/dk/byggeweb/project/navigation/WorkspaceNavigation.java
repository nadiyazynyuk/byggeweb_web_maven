package dk.byggeweb.project.navigation;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import dk.byggeweb.objects.project.workspace.panels.*;
import org.testng.annotations.Test;

public class WorkspaceNavigation extends ProjectTestBase {

    @Test(description = "Navigate through Workspace nodes")
    public void workspaceNavigation() {
        projectHomePage.navigateToWorkspaceModule();

        projectHomePage.getWorkspaceNodesPanel().navigateToRootFolder();
        new FolderContentPanel("Project");

        projectHomePage.getWorkspaceNodesPanel().navigateToVersionSets();
        new VersionSetsContentPanel();

        projectHomePage.getWorkspaceNodesPanel().navigateToRecycleBin();
        new RecycleBinContentPanel();

        projectHomePage.getWorkspaceNodesPanel().navigateToMonitoredFolders();
        new MonitoredFoldersContentPanel();

        projectHomePage.getWorkspaceNodesPanel().navigateToMonitoredFiles();
        new MonitoredFilesContentPanel();

        projectHomePage.getWorkspaceNodesPanel().navigateToSinceLastTime();
        new SinceLastTimeContentPanel();

        projectHomePage.getWorkspaceNodesPanel().navigateToSearchResult();
        new SearchResultContentPanel();
    }
}
