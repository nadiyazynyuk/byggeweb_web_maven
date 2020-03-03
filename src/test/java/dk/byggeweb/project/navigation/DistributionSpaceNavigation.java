package dk.byggeweb.project.navigation;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import org.testng.annotations.Test;

public class DistributionSpaceNavigation extends ProjectTestBase {

    @Test(description = "Navigate through Distribution space nodes")
    public void distributionSpaceNavigation() {
        projectHomePage.navigateToDistributionSpace();

        projectHomePage.getDistributionSpaceNodesPanel().navigateToRootDistributionList();
        projectHomePage.getDistributionSpaceNodesPanel().navigateToVersionSets();
        projectHomePage.getDistributionSpaceNodesPanel().navigateToRecipients();
        projectHomePage.getDistributionSpaceNodesPanel().navigateToInvitedUsers();
        projectHomePage.getDistributionSpaceNodesPanel().navigateToRecentlyReleasedFileVersions();
        projectHomePage.getDistributionSpaceNodesPanel().navigateToPrintDistributionExceptions();
        projectHomePage.getDistributionSpaceNodesPanel().navigateToMonitoredFolders();
        projectHomePage.getDistributionSpaceNodesPanel().navigateToMonitoredFiles();
        projectHomePage.getDistributionSpaceNodesPanel().navigateToSearchResult();

    }
}
