package dk.byggeweb.objects.desktop.applications;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.desktop.HomePage;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class ApplicationsPage extends HomePage {

    private SelenideElement projectsLink = $(byXpath("//li[@id='docia_project']"));
    private SelenideElement tenderLink = $(byXpath("//li[@id='docia_tender']"));
    private SelenideElement captureLink = $(byXpath("//li[@id='deficiency_list']"));
    private SelenideElement digitalHandoverLink = $(byXpath("//li[@id='corefm_digitalhandover']"));
    private SelenideElement iTWOfmLink = $(byXpath("//li[@id='corefm_portofolio']"));
    private SelenideElement handoverDatabaseLink = $(byXpath("//li[@id='corefm_handoverdatabase']"));
    private SelenideElement archiveLink = $(byXpath("//li[@id='docia_archive']"));
    private SelenideElement documentationLink = $(byXpath("//li[@id='documentation']"));
    private SelenideElement photoLink = $(byXpath("//li[@id='photo_list']"));
    private SelenideElement budgetLink = $(byXpath("//li[@id='docia_budget']"));
    private SelenideElement propertyLink = $(byXpath("//li[@id='docia_property']"));
    private SelenideElement scribbleLink = $(byXpath("//li[@id='scribble']"));

    @Step("Click on Applications")
    public void clickOnProject() {
        projectsLink.click();
    }

    @Step("Click on Tender link")
    public void clickOnTender() {
        tenderLink.click();
    }

    @Step("Click on Capture link")
    public void clickOnCapture() {
        captureLink.click();
    }

    @Step("Click on Digital Handover link")
    public void clickOnDigitalHandover() {
        digitalHandoverLink.click();
    }

    @Step("Click on iTWOfm link")
    public void clickOniTWOfm() {
        iTWOfmLink.click();
    }

    @Step("Click on Handover Database link")
    public void clickOnHandoverDatabase() {
        handoverDatabaseLink.click();
    }

    @Step("Click on Archive link")
    public void clickOnArchive() {
        archiveLink.click();
    }

    @Step("Click on Documentation link")
    public void clickOnDocumentation() {
        documentationLink.click();
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
