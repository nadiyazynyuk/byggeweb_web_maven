package dk.byggeweb.steps.project.versionsets;

import com.codeborne.selenide.WebDriverRunner;
import dk.byggeweb.objects.project.versionsets.modals.VSCreatePopup;
import dk.byggeweb.objects.project.versionsets.modals.VSDeletePopup;
import dk.byggeweb.objects.project.versionsets.modals.VSRemoveFilePopup;
import dk.byggeweb.objects.project.versionsets.panels.*;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Condition.visible;

@Log4j2
public class VersionSetsSteps {

    @Step("Select file in Version set Workspace")
    public void selectFileInWorkspace(String path, String name) {
        new VSSpaceContentPanel().getFileByFolderAndName(path, name).click();
        log.info("File " + name + " was selected");
        new VSWorkspaceFileInformationPanel(name);
    }

    @Step("Select file in Version set Publication Space")
    public void selectFileInPublicationSpace(String path, String name) {
        new VSSpaceContentPanel().getFileByFolderAndName(path, name).click();
        log.info("File " + name + " was selected");
        new VSPublicationSpaceFileInformationPanel(name);
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

    @Step("Navigate to Workspace in version set")
    public void navigateToVersionSetWorkspace(String name) {
        VersionSetsOverviewPanel versionSetsOverviewPanel = new VersionSetsOverviewPanel();
        versionSetsOverviewPanel.getVersionSetByName(name).click();
        log.info("Version set " + name + " was selected");
        VersionSetsContentPanel versionSetsContentPanel = new VersionSetsContentPanel();
        versionSetsContentPanel.getWorkspaceInVersionSet().click();
        log.info("Workspace in Version set " + name + " was selected");
        new VSSpaceContentPanel();
    }

    @Step("Navigate to Publication Space in version set")
    public void navigateToVersionSetPublicationSpace(String name) {
        VersionSetsOverviewPanel versionSetsOverviewPanel = new VersionSetsOverviewPanel();
        versionSetsOverviewPanel.getVersionSetByName(name).click();
        log.info("Version set " + name + " was selected");
        VersionSetsContentPanel versionSetsContentPanel = new VersionSetsContentPanel();
        versionSetsContentPanel.getPublicationSpaceInVersionSet().click();
        log.info("Publication space in Version set " + name + " was selected");
        new VSSpaceContentPanel();
    }

    @Step("Open Workspace in version set")
    public void openVersionSetWorkspace(String name) {
        VersionSetsOverviewPanel versionSetsOverviewPanel = new VersionSetsOverviewPanel();
        versionSetsOverviewPanel.getVersionSetByName(name).doubleClick();
        log.info("Version set " + name + " was opened");
        VersionSetsContentPanel versionSetsContentPanel = new VersionSetsContentPanel(name);
        versionSetsContentPanel.getWorkspaceInVersionSet().click();
        log.info("Workspace in Version set " + name + " was opened");
        new VSSpaceContentPanel();
    }

    @Step("Open Publication Space in version set")
    public void openVersionSetPublicationSpace(String name) {
        VersionSetsOverviewPanel versionSetsOverviewPanel = new VersionSetsOverviewPanel();
        versionSetsOverviewPanel.getVersionSetByName(name).doubleClick();
        log.info("Version set " + name + " was opened");
        VersionSetsContentPanel versionSetsContentPanel = new VersionSetsContentPanel();
        versionSetsContentPanel.getPublicationSpaceInVersionSet().click();
        log.info("Publication space in Version set " + name + " was opened");
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
        VSCreatePopup vsCreatePopup = new VSCreatePopup();
        vsCreatePopup.renameVersionSet(renameName);
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

    @Step("Remove file from Version set Workspace")
    public void removeFileFromWorkspaceVersionSet(String path, String name) {
        String winHandleBefore = WebDriverRunner.getWebDriver().getWindowHandle();
        selectFileInWorkspace(path, name);
        VSSpaceContentPanel vsSpaceContentPanel = new VSSpaceContentPanel();
        vsSpaceContentPanel.getRemoveFromVersionSetButton().click();
        VSRemoveFilePopup vsRemoveFilePopup = new VSRemoveFilePopup();
        vsSpaceContentPanel.switchToNewWindow();
        vsRemoveFilePopup.removeFile();
        WebDriverRunner.getWebDriver().switchTo().window(winHandleBefore);
    }

    @Step("Remove file from Version set Publication Space")
    public void removeFileFromPublicationSpaceVersionSet(String path, String name) {
        String winHandleBefore = WebDriverRunner.getWebDriver().getWindowHandle();
        selectFileInPublicationSpace(path, name);
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
        versionSetsContentPanel.getVersionSetByName(name).shouldBe(visible);
    }

    @Step("Verify version set is not present in the list")
    public void verifyVersionSetIsNotPresent(String name) {
        VersionSetsOverviewPanel versionSetsOverviewPanel = new VersionSetsOverviewPanel();
        versionSetsOverviewPanel.getVersionSetByName(name).shouldNotBe(visible);
    }

    @Step("Verify file is present in version set")
    public void verifyFileIsPresent(String path, String name) {
        VSSpaceContentPanel vsSpaceContentPanel = new VSSpaceContentPanel();
        vsSpaceContentPanel.getFileByFolderAndName(path, name).shouldBe(visible);
    }

    @Step("Verify file is not present in version set")
    public void verifyFileIsNotPresent(String path, String name) {
        VSSpaceContentPanel vsSpaceContentPanel = new VSSpaceContentPanel();
        vsSpaceContentPanel.getFileByFolderAndName(path, name).shouldBe(visible);
    }

}
