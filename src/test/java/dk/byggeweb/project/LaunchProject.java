package dk.byggeweb.project;

import dk.byggeweb.infrastructure.steps.GeneralSteps;
import dk.byggeweb.infrastructure.test.ProjectTestBase;
import dk.byggeweb.objects.pages.project.ProjectHomePage;
import org.testng.annotations.Test;

public class LaunchProject extends ProjectTestBase {

    @Test(description = "Launch project")
    public void launchProject() {
        GeneralSteps.loginAsVerifiedUser(data.getUserName(), data.getPassword(), data.getName());
        GeneralSteps.launchProject(data.getProjectLink());
        ProjectHomePage projectHomePage = new ProjectHomePage(data.getProjectName());
        projectHomePage.verifyProjectTitle(data.getProjectName());
    }
}
