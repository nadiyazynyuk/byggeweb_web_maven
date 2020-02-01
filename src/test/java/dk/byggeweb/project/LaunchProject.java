package dk.byggeweb.project;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import dk.byggeweb.objects.project.ProjectHomePage;
import org.testng.annotations.Test;

public class LaunchProject extends ProjectTestBase {

    @Test(description = "Launch project")
    public void launchProject() {
        projectHomePage = new ProjectHomePage(data.getProjectName());
        projectHomePage.verifyProjectTitle(data.getProjectName());
    }
}
