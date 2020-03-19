package dk.byggeweb.infrastructure.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import dk.byggeweb.infrastructure.environment.EnvironmentProperties;
import dk.byggeweb.infrastructure.test.testdata.JaxbDataReader;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.Getter;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import java.nio.file.Path;
import java.nio.file.Paths;

@Listeners(TestListener.class)
public abstract class TestBase {

    @Getter
    private String outputDirectory = EnvironmentProperties.getInstance().getProperty("outputDirectory");

    @Getter
    private String environment;

    @Parameters("environment")
    @BeforeClass
    public void setUp(String env) {
        environment = env;
        if (env.equals("production")) {
            Configuration.baseUrl = EnvironmentProperties.getInstance().getProperty("prodBaseUrl");
            Configuration.timeout = EnvironmentProperties.getInstance().getIntProperty("prodTimeout");
        }
        if (env.equals("testserver")) {
            Configuration.baseUrl = EnvironmentProperties.getInstance().getProperty("testBaseUrl");
            Configuration.timeout = EnvironmentProperties.getInstance().getIntProperty("testTimeout");
        }

        Configuration.browser = EnvironmentProperties.getInstance().getProperty("browser");
        Configuration.headless = EnvironmentProperties.getInstance().getBooleanProperty("headless");

        setOutputDirectory(getAbsolutePath(outputDirectory));

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));

        Selenide.open("");
        WebDriverRunner.getWebDriver().manage().window().setSize(new Dimension(1600, 1200));
    }

    @AfterClass
    public void tearDown() {
        if (WebDriverRunner.getWebDriver() != null) {
            WebDriverRunner.getWebDriver().quit();
        }
    }

    protected String getAbsolutePath(String propertiesPath) {
        Path path = Paths.get(propertiesPath);
        return path.toAbsolutePath().toString();
    }

    protected <T> T getXmlObject(String path, Class<? extends T> type) {
        return JaxbDataReader.getData(path, type);
    }

    private void setOutputDirectory(String directory) {
        if (EnvironmentProperties.getInstance().getProperty("browser").equals("chrome")) {
            System.setProperty("chromeoptions.prefs", "profile.default_content_settings.popups=0,download.default_directory=" + directory);
        }
    }

    private void setInternetExplorerConfiguration() {
        if (EnvironmentProperties.getInstance().getProperty("browser").equals("ie")) {
            DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
            caps.setCapability("initialBrowserUrl", Configuration.baseUrl);
            Configuration.browserCapabilities.merge(caps);
        }
    }

}
