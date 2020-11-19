package dk.byggeweb.objects.desktop.applications;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.desktop.HomePage;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class ApplicationsPage extends HomePage {

    private final SelenideElement projectsLink = $(byXpath("//li[@id='docia_project']"));
    private final SelenideElement vaultLink = $(byXpath("//li[@id='docia_vault']"));
    private final SelenideElement tenderLink = $(byXpath("//li[@id='docia_tender']"));
    private final SelenideElement captureLink = $(byXpath("//li[@id='deficiency_list']"));
    private final SelenideElement documentationLink = $(byXpath("//li[@id='documentation']"));
    private final SelenideElement archiveLink = $(byXpath("//li[@id='docia_archive']"));
    private final SelenideElement digitalHandoverLink = $(byXpath("//li[@id='corefm_digitalhandover']"));
    private final SelenideElement iTWOfmLink = $(byXpath("//li[@id='corefm_portofolio']"));
    private final SelenideElement moreAppsLink = $(byXpath("//li[@id='moreapps']"));

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

    @Step("Click on Vault link")
    public void clickOnVault() {
        vaultLink.click();
    }

    @Step("Click on Digital Handover link")
    public void clickOnDigitalHandover() {
        digitalHandoverLink.click();
    }

    @Step("Click on iTWOfm link")
    public void clickOniTWOfm() {
        iTWOfmLink.click();
    }

    @Step("Click on Archive link")
    public void clickOnArchive() {
        archiveLink.click();
    }

    @Step("Click on Documentation link")
    public void clickOnDocumentation() {
        documentationLink.click();
    }

    @Step("Click on More applications")
    public void clickOnMoreApplications() {
        moreAppsLink.click();
    }
}
