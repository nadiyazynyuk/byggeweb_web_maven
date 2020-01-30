package dk.byggeweb.desktop.navigation;

import dk.byggeweb.infrastructure.steps.GeneralSteps;
import dk.byggeweb.infrastructure.test.DesktopTestBase;
import dk.byggeweb.objects.desktop.HomePage;
import dk.byggeweb.objects.desktop.companyspace.*;
import org.testng.annotations.Test;

public class CompanySpaceNavigation extends DesktopTestBase {

    // https://itwofm.atlassian.net/browse/TSB-1

    @Test(description = "Navigation through Company space sections")
    public void companySpaceNavigation() {
        HomePage homePage = GeneralSteps.loginAsVerifiedUser(data.getUserName(), data.getPassword(), data.getName());
        homePage.navigateToCompanySpace();
        CompanySpacePage companySpacePage = new CompanySpacePage();

        companySpacePage.navigateToSharedFolders();
        SharedFoldersPage sharedFoldersPage = new SharedFoldersPage();
        sharedFoldersPage.verifyPageIsLoaded(sharedFoldersPage.getSharedFoldersTableHeader());

        companySpacePage.navigateToCompanyInformation();
        CompanyInformationPage companyInformationPage = new CompanyInformationPage();
        companyInformationPage.verifyPageIsLoaded(companyInformationPage.getCompanyInformationLabel());

        companySpacePage.navigateToCompanyUsers();
        CompanyUsersPage companyUsersPage = new CompanyUsersPage();
        companyUsersPage.verifyPageIsLoaded(companyUsersPage.getCompanyUsersLabel());

        companySpacePage.navigateToCompanyContacts();
        CompanyContactsPage companyContactsPage = new CompanyContactsPage();
        companyContactsPage.verifyPageIsLoaded(companyContactsPage.getCompanyContactsLabel());

        companySpacePage.navigateToWebsiteTemplates();
        WebsiteTemplatesPage websiteTemplatesPage = new WebsiteTemplatesPage();
        websiteTemplatesPage.verifyPageIsLoaded(websiteTemplatesPage.getWebsiteTemplatesLabel());

        companySpacePage.navigateToBackgroundImage();
        BackgroundImagePage backgroundImagePage = new BackgroundImagePage();
        backgroundImagePage.verifyPageIsLoaded(backgroundImagePage.getBackgroundImageLabel());
    }

}
