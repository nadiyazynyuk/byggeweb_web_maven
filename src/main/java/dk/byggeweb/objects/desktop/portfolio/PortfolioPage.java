package dk.byggeweb.objects.desktop.portfolio;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.desktop.HomePage;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class PortfolioPage extends HomePage {

    private final SelenideElement masterProjectLink = $(byXpath("//*[@id='case_list']"));
    private final SelenideElement closedMasterProjectsLink = $(byXpath("//*[@id='case_closedlist']"));

    @Step("Click on Master Project link")
    public void clickOnMasterProject() {
        masterProjectLink.click();
    }

    @Step("Click on Closed Master Projects link")
    public void clickOnClosedMasterProjects() {
        closedMasterProjectsLink.click();
    }
}
