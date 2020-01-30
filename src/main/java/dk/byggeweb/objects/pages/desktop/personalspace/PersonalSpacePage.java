package dk.byggeweb.objects.pages.desktop.personalspace;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.pages.desktop.HomePage;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class PersonalSpacePage extends HomePage {

    private SelenideElement desktopLink = $(byXpath("//*[@id='desktop']"));
    private SelenideElement myFoldersLink = $(byXpath("//*[@id='personal_folders']"));
    private SelenideElement mySettingsLink = $(byXpath("//*[@id='personal_settings']"));
    private SelenideElement logLink = $(byXpath("//*[@id='user_log']"));
    private SelenideElement reportsLink = $(byXpath("//*[@id='reports']"));
    private SelenideElement licenseAgreementLink = $(byXpath("//*[@id='license_agreement']"));

    @Step("Navigate to Personal Space > Desktop")
    public void navigateToDesktop() {
        desktopLink.click();
    }

    @Step("Navigate to Personal Space > My Folders")
    public void navigateToMyFolders() {
        myFoldersLink.click();
    }

    @Step("Navigate to Personal Space > My Settings")
    public void navigateToMySettings() {
        mySettingsLink.click();
    }

    @Step("Navigate to Personal Space > Log")
    public void navigateToLog() {
        logLink.click();
    }

    @Step("Navigate to Personal Space > Reports")
    public void navigateToReports() {
        reportsLink.click();
    }

    @Step("Navigate to Personal Space > License Agreement")
    public void navigateToLicenseAgreement() {
        licenseAgreementLink.click();
    }

}
