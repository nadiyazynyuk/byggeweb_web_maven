package dk.byggeweb.project.navigation;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import dk.byggeweb.objects.project.ProjectHomePage;
import org.testng.annotations.Test;

public class BasicNavigation extends ProjectTestBase {

    @Test(description = "Navigation through all modules")
    public void basicNavigation() {
        projectHomePage = new ProjectHomePage(data.getProjectName());
        projectHomePage.verifyProjectTitle(data.getProjectName());

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
