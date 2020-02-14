package dk.byggeweb.infrastructure.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import dk.byggeweb.infrastructure.environment.EnvironmentProperties;
import dk.byggeweb.infrastructure.test.testdata.JaxbDataReader;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import java.nio.file.Path;
import java.nio.file.Paths;

@Listeners(TestListener.class)
public abstract class TestBase {

    public String outputDirectory = EnvironmentProperties.getInstance().getProperty("outputDirectory");

    @Parameters("baseUrl")
    @BeforeClass
    public void setUp(String baseUrl) {
        Configuration.baseUrl = baseUrl;
        Configuration.browser = EnvironmentProperties.getInstance().getProperty("browser");
        Configuration.headless = EnvironmentProperties.getInstance().getBooleanProperty("headless");
        Configuration.timeout = EnvironmentProperties.getInstance().getIntProperty("defaultTimeout");

        setDownloadDirectory(getAbsolutePath(outputDirectory));

        Selenide.open("");
        WebDriverRunner.getWebDriver().manage().window().setSize(new Dimension(1600, 1200));
    }

    protected String getAbsolutePath(String propertiesPath) {
        Path path = Paths.get(propertiesPath);
        return path.toAbsolutePath().toString();
    }

    protected <T> T getXmlObject(String path, Class<? extends T> type) {
        return JaxbDataReader.getData(path, type);
    }

    private void setDownloadDirectory(String directory) {
        System.setProperty("chromeoptions.prefs", "profile.default_content_settings.popups=0,download.default_directory=" + directory);
    }

    private void setInternetExplorerConfiguration() {
        if (EnvironmentProperties.getInstance().getProperty("browser").equals("ie")) {
            DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
            caps.setCapability("initialBrowserUrl", Configuration.baseUrl);
            Configuration.browserCapabilities.merge(caps);
        }
    }

}
