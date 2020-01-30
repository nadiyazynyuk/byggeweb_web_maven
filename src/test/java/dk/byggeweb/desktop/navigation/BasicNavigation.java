package dk.byggeweb.desktop.navigation;

import com.codeborne.selenide.WebDriverRunner;
import dk.byggeweb.infrastructure.steps.GeneralSteps;
import dk.byggeweb.infrastructure.test.DesktopTestBase;
import dk.byggeweb.objects.pages.desktop.HomePage;
import dk.byggeweb.objects.pages.desktop.applications.ApplicationsPage;
import dk.byggeweb.objects.pages.desktop.communication.CommunicationPage;
import dk.byggeweb.objects.pages.desktop.companyspace.CompanySpacePage;
import dk.byggeweb.objects.pages.desktop.personalspace.PersonalSpacePage;
import dk.byggeweb.objects.pages.desktop.portfolio.PortfolioPage;
import dk.byggeweb.objects.pages.desktop.support.SupportCenterPage;
import org.testng.annotations.Test;

public class BasicNavigation extends DesktopTestBase {

    // https://itwofm.atlassian.net/browse/TSB-8

    @Test(description = "Basic navigation through main sections")
    public void basicNavigation() {
        HomePage homePage = GeneralSteps.loginAsVerifiedUser(data.getUserName(), data.getPassword(), data.getName());

        homePage.navigateToPersonalSpace();
        PersonalSpacePage personalSpacePage = new PersonalSpacePage();
        personalSpacePage.verifyPageIsLoaded(personalSpacePage.getDesktopLink());

        personalSpacePage.navigateToCompanySpace();
        CompanySpacePage companySpacePage = new CompanySpacePage();
        companySpacePage.verifyPageIsLoaded(companySpacePage.getSharedFoldersLink());

        companySpacePage.navigateToApplications();
        ApplicationsPage applicationsPage = new ApplicationsPage();
        applicationsPage.verifyPageIsLoaded(applicationsPage.getProjectsLink());

        applicationsPage.navigateToPortfolio();
        PortfolioPage portfolioPage = new PortfolioPage();
        portfolioPage.verifyPageIsLoaded(portfolioPage.getMasterProjectLink());

        portfolioPage.navigateToCommunication();
        CommunicationPage communicationPage = new CommunicationPage();
        communicationPage.verifyPageIsLoaded(communicationPage.getNotificationsLink());

        communicationPage.navigateToSupport();
        communicationPage.switchToNewWindow();
        SupportCenterPage supportCenterPage = new SupportCenterPage();
        supportCenterPage.verifyPageTitle(supportCenterPage, "SupportCenter");
        WebDriverRunner.getWebDriver().close();
    }

}
