package dk.byggeweb.objects.desktop.personalspace;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.desktop.HomePage;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class PersonalSpacePage extends HomePage {

    private final SelenideElement desktopLink = $(byXpath("//*[@id='desktop']"));
    private final SelenideElement myFoldersLink = $(byXpath("//*[@id='personal_folders']"));
    private final SelenideElement mySettingsLink = $(byXpath("//*[@id='personal_settings']"));
    private final SelenideElement logLink = $(byXpath("//*[@id='user_log']"));
    private final SelenideElement reportsLink = $(byXpath("//*[@id='reports']"));
    private final SelenideElement licenseAgreementLink = $(byXpath("//*[@id='license_agreement']"));

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
