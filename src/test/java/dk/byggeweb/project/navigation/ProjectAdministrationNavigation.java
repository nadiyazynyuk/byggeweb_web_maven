package dk.byggeweb.project.navigation;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import org.testng.annotations.Test;

public class ProjectAdministrationNavigation extends ProjectTestBase {

    @Test(description = "Navigate through Project administration module nodes")
    public void projectAdministrationNavigation() {
        projectHomePage.navigateToProjectAdministration();

        projectHomePage.getProjectAdministrationNodesPanel().navigateToSystemInformation();
        projectHomePage.getProjectAdministrationNodesPanel().navigateToApproval();
        projectHomePage.getProjectAdministrationNodesPanel().navigateToBackupOrders();
        projectHomePage.getProjectAdministrationNodesPanel().navigateToPrintOrders();
        projectHomePage.getProjectAdministrationNodesPanel().navigateToGroups();
        projectHomePage.getProjectAdministrationNodesPanel().navigateToUsers();
    }
}
