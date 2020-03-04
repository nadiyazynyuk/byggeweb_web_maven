package dk.byggeweb.project.navigation;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import org.testng.annotations.Test;

public class PersonalOverviewsNavigation extends ProjectTestBase {

    @Test(description = "Navigate through Personal overviews module nodes")
    public void personalOverviewsNavigation() {
        projectHomePage.navigateToPersonalOverviews();

        projectHomePage.getPersonalOverviewsNodesPanel().navigateToProjectSettings();
        projectHomePage.getPersonalOverviewsNodesPanel().navigateToPrintOrders();
        projectHomePage.getPersonalOverviewsNodesPanel().navigateToUserLog();
        projectHomePage.getPersonalOverviewsNodesPanel().navigateToBackupOrders();
    }
}
