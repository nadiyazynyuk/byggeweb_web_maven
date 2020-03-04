package dk.byggeweb.project.navigation;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import org.testng.annotations.Test;

public class CommunicationNavigation extends ProjectTestBase {

    @Test(description = "Navigate through Communication module nodes")
    public void communicationNavigation() {
        projectHomePage.navigateToCommunication();

        projectHomePage.getCommunicationNodesPanel().navigateToMessages();
        projectHomePage.getCommunicationNodesPanel().navigateToAddressList();
    }
}
