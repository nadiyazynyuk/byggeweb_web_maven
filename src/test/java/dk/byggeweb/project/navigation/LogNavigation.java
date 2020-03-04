package dk.byggeweb.project.navigation;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import org.testng.annotations.Test;

public class LogNavigation extends ProjectTestBase {

    @Test(description = "Navigate through Log module nodes")
    public void logNavigation() {
        projectHomePage.navigateToLog();

        projectHomePage.getLogNodesPanel().navigateToPredefinedLog();
        projectHomePage.getLogNodesPanel().navigateToProjectLog();
        projectHomePage.getLogNodesPanel().navigateToUserLog();
    }
}
