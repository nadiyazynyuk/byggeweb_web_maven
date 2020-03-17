package dk.byggeweb.steps.project.versionsets;

import com.codeborne.selenide.WebDriverRunner;
import dk.byggeweb.objects.project.versionsets.modals.VersionSetCreatePopup;
import dk.byggeweb.objects.project.versionsets.modals.VersionSetDeletePopup;
import dk.byggeweb.objects.project.versionsets.modals.VersionSetEditPopup;
import dk.byggeweb.objects.project.versionsets.panels.VersionSetsContentPanel;
import dk.byggeweb.objects.project.versionsets.panels.VersionSetsOverviewPanel;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;

import static com.codeborne.selenide.Condition.text;

@Log4j
public class VersionSetsSteps {

    @Step("Select version set")
    public void navigateToVersionSet(String name) {
        VersionSetsOverviewPanel versionSetsOverviewPanel = new VersionSetsOverviewPanel();
        versionSetsOverviewPanel.getVersionSetByName(name).click();
        log.info("Version set " + name + " was selected");
        new VersionSetsContentPanel(name);
    }

    @Step("Create new Version set")
    public void createVersionSet(String createName) {
        String winHandleBefore = WebDriverRunner.getWebDriver().getWindowHandle();
        VersionSetsOverviewPanel versionSetsOverviewPanel = new VersionSetsOverviewPanel();
        versionSetsOverviewPanel.getNewVersionSetButton().click();
        log.info("Create Version set button was clicked");
        versionSetsOverviewPanel.switchToNewWindow();
        VersionSetCreatePopup versionSetCreatePopup = new VersionSetCreatePopup();
        versionSetCreatePopup.createVersionSet(createName);
        log.info("Version set " + createName + " was created");
        WebDriverRunner.getWebDriver().switchTo().window(winHandleBefore);
        new VersionSetsContentPanel(createName);
    }

    @Step("Rename Version set")
    public void renameVersionSet(String createName, String renameName) {
        String winHandleBefore = WebDriverRunner.getWebDriver().getWindowHandle();
        VersionSetsContentPanel versionSetsContentPanel = new VersionSetsContentPanel(createName);
        versionSetsContentPanel.getEditVersionSetButton().click();
        log.info("Create Version set button was clicked");
        versionSetsContentPanel.switchToNewWindow();
        VersionSetEditPopup versionSetEditPopup = new VersionSetEditPopup();
        versionSetEditPopup.renameVersionSet(renameName);
        log.info("Version set " + createName + " was renamed to " + renameName);
        WebDriverRunner.getWebDriver().switchTo().window(winHandleBefore);
        new VersionSetsContentPanel(renameName);
    }

    @Step("Delete Version set")
    public void deleteVersionSet(String name) {
        String winHandleBefore = WebDriverRunner.getWebDriver().getWindowHandle();
        VersionSetsContentPanel versionSetsContentPanel = new VersionSetsContentPanel(name);
        versionSetsContentPanel.getDeleteVersionSetButton().click();
        log.info("Delete Version set button was clicked");
        versionSetsContentPanel.switchToNewWindow();
        VersionSetDeletePopup versionSetDeletePopup = new VersionSetDeletePopup();
        versionSetDeletePopup.deleteVersionSet();
        log.info("Version set was deleted");
        WebDriverRunner.getWebDriver().switchTo().window(winHandleBefore);
        new VersionSetsOverviewPanel();
    }

    @Step("Verify version set is present in the list")
    public void verifyVersionSetIsPresent(String name) {
        VersionSetsContentPanel versionSetsContentPanel = new VersionSetsContentPanel(name);
        versionSetsContentPanel.getVersionSetByName(name).shouldHave(text(name));
    }

    @Step("Verify version set is not present in the list")
    public void verifyVersionSetIsNotPresent(String name) {
        VersionSetsOverviewPanel versionSetsOverviewPanel = new VersionSetsOverviewPanel();
        versionSetsOverviewPanel.getVersionSetByName(name).shouldNotHave(text(name));
    }
}
