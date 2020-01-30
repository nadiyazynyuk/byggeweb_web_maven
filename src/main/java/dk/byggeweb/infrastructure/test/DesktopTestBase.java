package dk.byggeweb.infrastructure.test;

import dk.byggeweb.infrastructure.test.testdata.model.DesktopTestDataModel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public abstract class DesktopTestBase extends TestBase {

    public DesktopTestDataModel data;

    @Parameters("testData")
    @BeforeClass
    public void setUp(String testData) {
        data = getXmlObject(testData, DesktopTestDataModel.class);
    }

}
