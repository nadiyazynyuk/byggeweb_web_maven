package dk.byggeweb.project.navigation;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import org.testng.annotations.Test;

public class ProjectInformationNavigation extends ProjectTestBase {

    @Test(description = "Navigate through Project information module nodes")
    public void projectInformationNavigation() {
        projectHomePage.navigateToProjectInformation();

        projectHomePage.getProjectInformationNodesPanel().navigateToProjectDescription();
        projectHomePage.getProjectInformationNodesPanel().navigateToAdministrators();
        projectHomePage.getProjectInformationNodesPanel().navigateToAreasOfResponsibility();
    }
}
