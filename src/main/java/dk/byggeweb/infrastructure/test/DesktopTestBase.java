package dk.byggeweb.infrastructure.test;

import dk.byggeweb.infrastructure.steps.GeneralSteps;
import dk.byggeweb.infrastructure.test.testdata.model.DesktopTestDataModel;
import dk.byggeweb.objects.desktop.HomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public abstract class DesktopTestBase extends TestBase {

    public DesktopTestDataModel data;
    public HomePage homePage;

    @Parameters("testData")
    @BeforeClass
    public void setUp(String testData) {
        data = getXmlObject(testData, DesktopTestDataModel.class);
        homePage = GeneralSteps.loginAsVerifiedUser(data.getUserName(), data.getPassword(), data.getName());
    }

}
