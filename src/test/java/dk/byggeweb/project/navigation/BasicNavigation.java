package dk.byggeweb.project.navigation;

import dk.byggeweb.infrastructure.steps.GeneralSteps;
import dk.byggeweb.infrastructure.test.ProjectTestBase;
import dk.byggeweb.objects.pages.project.ProjectHomePage;
import org.testng.annotations.Test;

public class BasicNavigation extends ProjectTestBase {

    @Test(description = "Navigation through all modules")
    public void basicNavigation() {
        GeneralSteps.loginAsVerifiedUser(data.getUserName(), data.getPassword(), data.getName());
        GeneralSteps.launchProject(data.getProjectLink());
        ProjectHomePage projectHomePage = new ProjectHomePage(data.getProjectName());
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
