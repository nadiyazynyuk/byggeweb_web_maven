package dk.byggeweb.desktop.navigation;

import com.codeborne.selenide.WebDriverRunner;
import dk.byggeweb.infrastructure.test.DesktopTestBase;
import dk.byggeweb.objects.desktop.applications.ApplicationsPage;
import dk.byggeweb.objects.desktop.communication.CommunicationPage;
import dk.byggeweb.objects.desktop.companyspace.CompanySpacePage;
import dk.byggeweb.objects.desktop.personalspace.PersonalSpacePage;
import dk.byggeweb.objects.desktop.portfolio.PortfolioPage;
import dk.byggeweb.objects.desktop.support.SupportCenterPage;
import io.qameta.allure.Link;
import org.testng.annotations.Test;

public class BasicNavigation extends DesktopTestBase {

    @Link(url = "https://itwofm.atlassian.net/browse/TSB-8")

    @Test(description = "Basic navigation through main sections")
    public void basicNavigation() {
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
