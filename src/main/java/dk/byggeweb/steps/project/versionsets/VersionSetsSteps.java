package dk.byggeweb.steps.project.versionsets;

import com.codeborne.selenide.WebDriverRunner;
import dk.byggeweb.objects.project.versionsets.modals.VSCreatePopup;
import dk.byggeweb.objects.project.versionsets.modals.VSDeletePopup;
import dk.byggeweb.objects.project.versionsets.modals.VSEditPopup;
import dk.byggeweb.objects.project.versionsets.modals.VSRemoveFilePopup;
import dk.byggeweb.objects.project.versionsets.panels.VSWorkspaceFileInformationPanel;
import dk.byggeweb.objects.project.versionsets.panels.VSSpaceContentPanel;
import dk.byggeweb.objects.project.versionsets.panels.VersionSetsContentPanel;
import dk.byggeweb.objects.project.versionsets.panels.VersionSetsOverviewPanel;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;

import static com.codeborne.selenide.Condition.text;

@Log4j
public class VersionSetsSteps {

    @Step("Select file")
    public void selectFileInWorkspace(String path, String name) {
        new VSSpaceContentPanel().getFileByFolderAndName(path, name).click();
        log.info("File " + name + " was selected");
        new VSWorkspaceFileInformationPanel(name);
    }

    @Step("Select version set")
    public void navigateToVersionSet(String name) {
        VersionSetsOverviewPanel versionSetsOverviewPanel = new VersionSetsOverviewPanel();
        versionSetsOverviewPanel.getVersionSetByName(name).click();
        log.info("Version set " + name + " was selected");
        new VersionSetsContentPanel(name);
    }

    @Step("Open version set")
    public void openVersionSet(String name) {
        VersionSetsOverviewPanel versionSetsOverviewPanel = new VersionSetsOverviewPanel();
        versionSetsOverviewPanel.getVersionSetByName(name).doubleClick();
        log.info("Version set " + name + " was opened");
    }

    @Step("Navigate to space in version set")
    public void navigateToVersionSetSpace(String name) {
        VersionSetsOverviewPanel versionSetsOverviewPanel = new VersionSetsOverviewPanel();
        versionSetsOverviewPanel.getVersionSetByName(name).click();
        log.info("Version set " + name + " was selected");
        VersionSetsContentPanel versionSetsContentPanel = new VersionSetsContentPanel(name);
        versionSetsContentPanel.getWorkspaceInVersionSet().click();
        new VSSpaceContentPanel();
    }

    @Step("Open space in version set")
    public void openVersionSetSpace(String name) {
        VersionSetsOverviewPanel versionSetsOverviewPanel = new VersionSetsOverviewPanel();
        versionSetsOverviewPanel.getVersionSetByName(name).doubleClick();
        log.info("Version set " + name + " was opened");
        VersionSetsContentPanel versionSetsContentPanel = new VersionSetsContentPanel(name);
        versionSetsContentPanel.getWorkspaceInVersionSet().click();
        new VSSpaceContentPanel();
    }

    @Step("Create new Version set")
    public void createVersionSet(String createName) {
        String winHandleBefore = WebDriverRunner.getWebDriver().getWindowHandle();
        VersionSetsOverviewPanel versionSetsOverviewPanel = new VersionSetsOverviewPanel();
        versionSetsOverviewPanel.getNewVersionSetButton().click();
        log.info("Create Version set button was clicked");
        versionSetsOverviewPanel.switchToNewWindow();
        VSCreatePopup vsCreatePopup = new VSCreatePopup();
        vsCreatePopup.createVersionSet(createName);
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
        VSEditPopup vsEditPopup = new VSEditPopup();
        vsEditPopup.renameVersionSet(renameName);
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
        VSDeletePopup vsDeletePopup = new VSDeletePopup();
        vsDeletePopup.deleteVersionSet();
        log.info("Version set was deleted");
        WebDriverRunner.getWebDriver().switchTo().window(winHandleBefore);
        new VersionSetsOverviewPanel();
    }

    @Step("Remove file from version set")
    public void removeFileFromVersionSet(String path, String name) {
        String winHandleBefore = WebDriverRunner.getWebDriver().getWindowHandle();
        selectFileInWorkspace(path, name);
        VSSpaceContentPanel vsSpaceContentPanel = new VSSpaceContentPanel();
        vsSpaceContentPanel.getRemoveFromVersionSetButton().click();
        VSRemoveFilePopup vsRemoveFilePopup = new VSRemoveFilePopup();
        vsSpaceContentPanel.switchToNewWindow();
        vsRemoveFilePopup.removeFile();
        WebDriverRunner.getWebDriver().switchTo().window(winHandleBefore);
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

    @Step("Verify file is present in version set")
    public void verifyFileIsPresent(String path, String name) {
        VSSpaceContentPanel vsSpaceContentPanel = new VSSpaceContentPanel();
        vsSpaceContentPanel.getFileByFolderAndName(path, name).shouldHave(text(name));
    }

    @Step("Verify file is not present in version set")
    public void verifyFileIsNotPresent(String path, String name) {
        VSSpaceContentPanel vsSpaceContentPanel = new VSSpaceContentPanel();
        vsSpaceContentPanel.getFileByFolderAndName(path, name).shouldNotHave(text(name));
    }
}