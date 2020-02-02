package dk.byggeweb.project.navigation;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import org.testng.annotations.Test;

public class BasicNavigation extends ProjectTestBase {

    @Test(description = "Navigation through all modules")
    public void basicNavigation() {
        projectHomePage.navigateToProjectInformation();
        projectHomePage.navigateToWorkspaceModule();
        projectHomePage.navigateToPublicationSpace();
        projectHomePage.navigateToDistributionSpace();
        projectHomePage.navigateToCommunication();
        projectHomePage.navigateToProjectAdministration();
        projectHomePage.navigateToLog();
        projectHomePage.navigateToPersonalOverviews();
    }
}
