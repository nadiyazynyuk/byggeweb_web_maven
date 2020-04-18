package dk.byggeweb.desktop.navigation;

import dk.byggeweb.infrastructure.test.DesktopTestBase;
import dk.byggeweb.objects.desktop.companyspace.*;
import io.qameta.allure.Link;
import org.testng.annotations.Test;

public class CompanySpaceNavigation extends DesktopTestBase {

    @Link(url = "https://itwofm.atlassian.net/browse/TSB-1")

    @Test(description = "Navigation through Company space sections")
    public void companySpaceNavigation() {
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
