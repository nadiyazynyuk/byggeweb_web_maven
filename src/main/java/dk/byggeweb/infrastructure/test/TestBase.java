package dk.byggeweb.infrastructure.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import dk.byggeweb.infrastructure.environment.EnvironmentProperties;
import dk.byggeweb.infrastructure.testdata.JaxbDataReader;
import org.openqa.selenium.Dimension;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import java.nio.file.Path;
import java.nio.file.Paths;

@Listeners(TestListener.class)
public abstract class TestBase {

    @BeforeClass
    public void setUp() {
        Configuration.browser = EnvironmentProperties.getInstance().getProperty("browser");
        Configuration.headless = EnvironmentProperties.getInstance().getBooleanProperty("headless");
        Configuration.baseUrl = EnvironmentProperties.getInstance().getProperty("desktopBaseUrl");
        Configuration.timeout = EnvironmentProperties.getInstance().getIntProperty("defaultTimeout");

        //IE
//        DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
//        caps.setCapability("initialBrowserUrl", Configuration.baseUrl);
//        Configuration.browserCapabilities.merge(caps);

        Selenide.open("/");
        WebDriverRunner.getWebDriver().manage().window().setSize(new Dimension(1600, 1200));
    }

    protected String getAbsolutePath(String propertiesPath) {
        Path path = Paths.get(propertiesPath);
        return path.toAbsolutePath().toString();
    }

    protected <T> T getXmlObject(String path, Class<? extends T> type){
        return  JaxbDataReader.getData(path, type);
    }

}
