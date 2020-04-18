package dk.byggeweb.desktop.navigation;

import dk.byggeweb.infrastructure.test.DesktopTestBase;
import dk.byggeweb.objects.desktop.personalspace.*;
import io.qameta.allure.Link;
import org.testng.annotations.Test;

public class PersonalSpaceNavigation extends DesktopTestBase {

    @Link(url = "https://itwofm.atlassian.net/browse/TSB-11")

    @Test(description = "Navigation through Personal space sections")
    public void personalSpaceNavigation() {
        homePage.navigateToPersonalSpace();
        PersonalSpacePage personalSpacePage = new PersonalSpacePage();

        personalSpacePage.navigateToDesktop();
        DesktopPage desktopPage = new DesktopPage();
        desktopPage.verifyPageIsLoaded(desktopPage.getAddDesktopContentLink());

        personalSpacePage.navigateToMyFolders();
        MyFoldersPage myFoldersPage = new MyFoldersPage();
        myFoldersPage.verifyPageIsLoaded(myFoldersPage.getMyFoldersTableHeader());

        personalSpacePage.navigateToMySettings();
        MySettingsPage mySettingsPage = new MySettingsPage();
        mySettingsPage.verifyPageIsLoaded(mySettingsPage.getMySettingsLabel());

        personalSpacePage.navigateToLog();
        LogPage logPage = new LogPage();
        logPage.verifyPageIsLoaded(logPage.getLogLabel());

        personalSpacePage.navigateToReports();
        ReportsPage reportsPage = new ReportsPage();
        reportsPage.verifyPageIsLoaded(reportsPage.getReportsLabel());

        personalSpacePage.navigateToLicenseAgreement();
        LicenseAgreementPage licenseAgreementPage = new LicenseAgreementPage();
        licenseAgreementPage.verifyPageIsLoaded(licenseAgreementPage.getLicenseAgreementLabel());
    }

}
