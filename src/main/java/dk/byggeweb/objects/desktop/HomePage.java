package dk.byggeweb.objects.desktop;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.PageBase;
import io.qameta.allure.Step;
import lombok.Getter;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class HomePage extends PageBase {

    private final SelenideElement userLabel = $(byXpath("//div[@id = 'companypage-top-user']/p"));
    private final SelenideElement personalSpace = $(byXpath("//*[@id='tab_personalspace']"));
    private final SelenideElement companySpace = $(byXpath("//*[@id='tab_companyspace']"));
    private final SelenideElement applications = $(byXpath("//*[@id='tab_applications']"));
    private final SelenideElement portfolio = $(byXpath("//*[@id='tab_cases']"));
    private final SelenideElement communication = $(byXpath("//*[@id='tab_communication']"));
    private final SelenideElement support = $(byXpath("//*[@id='tab_support']"));
    private final SelenideElement logoffButton = $(byXpath("//*[@class='logOff']"));

    @Step("Verify that user is logged in")
    public void verifyCurrentUser(String username) {
        userLabel.shouldHave(text(username));
    }

    @Step("Verify page is loaded")
    public void verifyPageIsLoaded(SelenideElement element) {
        element.should(visible);
    }

    @Step("Navigate to Personal Space")
    public void navigateToPersonalSpace() {
        personalSpace.click();
    }

    @Step("Navigate to Company Space")
    public void navigateToCompanySpace() {
        companySpace.click();
    }

    @Step("Navigate to Applications")
    public void navigateToApplications() {
        applications.click();
    }

    @Step("Navigate to Portfolio")
    public void navigateToPortfolio() {
        portfolio.click();
    }

    @Step("Navigate to Communication")
    public void navigateToCommunication() {
        communication.click();
    }

    @Step("Navigate to Support")
    public void navigateToSupport() {
        support.click();
    }

    @Step("Logoff")
    public void logoff() {
        logoffButton.click();
    }

    @Step("Verify page title")
    public void verifyPageTitle(HomePage page, String expectedPageTitle) {
        String title = page.getPageTitle();
        Assert.assertTrue(title.contains(expectedPageTitle), "Wrong page title");
    }

    public HomePage(String user) {
        userLabel.shouldHave(text(user));
    }

    public HomePage() {}
}



