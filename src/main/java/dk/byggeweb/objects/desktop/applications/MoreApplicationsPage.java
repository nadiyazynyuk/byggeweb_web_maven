package dk.byggeweb.objects.desktop.applications;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.desktop.HomePage;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class MoreApplicationsPage extends HomePage {

    private final SelenideElement handoverDatabaseLink = $(byXpath("//li[@id='corefm_handoverdatabase']"));
    private final SelenideElement photoLink = $(byXpath("//li[@id='photo_list']"));
    private final SelenideElement budgetLink = $(byXpath("//li[@id='docia_budget']"));
    private final SelenideElement propertyLink = $(byXpath("//li[@id='docia_property']"));
    private final SelenideElement scribbleLink = $(byXpath("//li[@id='scribble']"));

    @Step("Click on Handover Database link")
    public void clickOnHandoverDatabase() {
        handoverDatabaseLink.click();
    }

    @Step("Click on Photo link")
    public void clickOnPhoto() {
        photoLink.click();
    }

    @Step("Click on Budget link")
    public void clickOnBudget() {
        budgetLink.click();
    }

    @Step("Click on Property link")
    public void clickOnProperty() {
        propertyLink.click();
    }

    @Step("Click on Scribble link")
    public void clickOnScribble() {
        scribbleLink.click();
    }

}
