package dk.byggeweb.desktop.navigation;

import dk.byggeweb.infrastructure.test.DesktopTestBase;
import dk.byggeweb.objects.desktop.applications.*;
import io.qameta.allure.Link;
import org.testng.annotations.Test;

public class ApplicationsNavigation extends DesktopTestBase {

    @Link(url = "https://itwofm.atlassian.net/browse/TSB-9")

    @Test(description = "Navigation through application sections")
    public void applicationsNavigation() {
        homePage.navigateToApplications();
        ApplicationsPage applicationsPage = new ApplicationsPage();

        applicationsPage.clickOnProject();
        ProjectOverviewPage projectOverviewPage = new ProjectOverviewPage();
        projectOverviewPage.verifyPageIsLoaded(projectOverviewPage.getProjectsLabel());

        applicationsPage.clickOnTender();
        TenderOverviewPage tenderOverviewPage = new TenderOverviewPage();
        tenderOverviewPage.verifyPageIsLoaded(tenderOverviewPage.getTendersLabel());

        applicationsPage.clickOnCapture();
        CaptureOverviewPage captureOverviewPage = new CaptureOverviewPage();
        captureOverviewPage.verifyPageIsLoaded(captureOverviewPage.getCaptureLabel());

        applicationsPage.clickOnVault();
        VaultOverviewPage vaultOverviewPage = new VaultOverviewPage();
        vaultOverviewPage.verifyPageIsLoaded(vaultOverviewPage.getVaultLabel());

        applicationsPage.clickOnDigitalHandover();
        DigitalHandoverOverviewPage digitalHandoverOverviewPage = new DigitalHandoverOverviewPage();
        digitalHandoverOverviewPage.verifyPageIsLoaded(digitalHandoverOverviewPage.getDigitalHandoverLabel());

        applicationsPage.clickOniTWOfm();
        iTWOfmOverviewPage iTWOfmOverviewPage = new iTWOfmOverviewPage();
        iTWOfmOverviewPage.verifyPageIsLoaded(iTWOfmOverviewPage.getITWOfmLabel());

        applicationsPage.clickOnHandoverDatabase();
        HandoverDatabaseOverviewPage handoverDatabaseOverviewPage = new HandoverDatabaseOverviewPage();
        handoverDatabaseOverviewPage.verifyPageIsLoaded(handoverDatabaseOverviewPage.getHandoverDatabaseLabel());

        applicationsPage.clickOnArchive();
        ArchiveOverviewPage archiveOverviewPage = new ArchiveOverviewPage();
        archiveOverviewPage.verifyPageIsLoaded(archiveOverviewPage.getArchiveLabel());

        applicationsPage.clickOnDocumentation();
        DocumentationOverviewPage documentationOverviewPage = new DocumentationOverviewPage();
        documentationOverviewPage.verifyPageIsLoaded(documentationOverviewPage.getDocumentationLabel());

        applicationsPage.clickOnPhoto();
        PhotoOverviewPage photoOverviewPage = new PhotoOverviewPage();
        photoOverviewPage.verifyPageIsLoaded(photoOverviewPage.getPhotoLabel());

        applicationsPage.clickOnBudget();
        BudgetOverviewPage budgetOverviewPage = new BudgetOverviewPage();
        budgetOverviewPage.verifyPageIsLoaded(budgetOverviewPage.getBudgetLabel());

        applicationsPage.clickOnProperty();
        PropertyOverviewPage propertyOverviewPage = new PropertyOverviewPage();
        propertyOverviewPage.verifyPageIsLoaded(propertyOverviewPage.getPropertyLabel());

        applicationsPage.clickOnScribble();
        ScribbleOverviewPage scribbleOverviewPage = new ScribbleOverviewPage();
        scribbleOverviewPage.verifyPageIsLoaded(scribbleOverviewPage.getScribbleLabel());

    }
}
