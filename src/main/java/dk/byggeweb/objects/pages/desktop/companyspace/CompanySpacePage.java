package dk.byggeweb.objects.pages.desktop.companyspace;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.pages.desktop.HomePage;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class CompanySpacePage extends HomePage {

    private SelenideElement sharedFoldersLink = $(byXpath("//*[@id='company_folders']"));
    private SelenideElement companyInfoLink = $(byXpath("//*[@id='company_information']"));
    private SelenideElement companyUsersLink = $(byXpath("//*[@id='company_users']"));
    private SelenideElement companyContactsLink = $(byXpath("//*[@id='contacts']"));
    private SelenideElement websiteTemplatesLink = $(byXpath("//*[@id='webtemplate_list']"));
    private SelenideElement backgroundImageLink = $(byXpath("//*[@id='background_image']"));

    @Step("Navigate to Company Space > Shared folders")
    public void navigateToSharedFolders() {
        sharedFoldersLink.click();
    }

    @Step("Navigate to Company Space > Company Information")
    public void navigateToCompanyInformation() {
        companyInfoLink.click();
    }

    @Step("Navigate to Company Space > Company Users")
    public void navigateToCompanyUsers() {
        companyUsersLink.click();
    }

    @Step("Navigate to Company Space > Company Contacts")
    public void navigateToCompanyContacts() {
        companyContactsLink.click();
    }

    @Step("Navigate to Company Space > Website Templates")
    public void navigateToWebsiteTemplates() {
        websiteTemplatesLink.click();
    }

    @Step("Navigate to Company Space > Background Image")
    public void navigateToBackgroundImage() {
        backgroundImageLink.click();
    }

}
