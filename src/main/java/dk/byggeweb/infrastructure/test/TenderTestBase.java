package dk.byggeweb.infrastructure.test;

import dk.byggeweb.infrastructure.test.testdata.model.TenderTestDataModel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public abstract class TenderTestBase extends TestBase {

    public TenderTestDataModel data;

    @Parameters("testData")
    @BeforeClass
    public void setUp(String testData) {
        data = getXmlObject(getEnvironment() + testData, TenderTestDataModel.class);
    }

}
