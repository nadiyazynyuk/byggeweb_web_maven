package dk.byggeweb.infrastructure.test;

import dk.byggeweb.infrastructure.test.testdata.model.DesktopTestDataModel;
import dk.byggeweb.objects.desktop.HomePage;
import dk.byggeweb.steps.GeneralSteps;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public abstract class DesktopTestBase extends TestBase {

    public DesktopTestDataModel data;
    public HomePage homePage;

    @Parameters("testData")
    @BeforeClass
    public void login(String testData) {
        data = getXmlObject(getEnv() + testData, DesktopTestDataModel.class);
        GeneralSteps.loginAsVerifiedUser(data.getUserName(), data.getPassword(), data.getName());
        homePage = new HomePage(data.getName());
    }

}
