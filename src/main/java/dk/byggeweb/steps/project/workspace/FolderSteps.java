package dk.byggeweb.steps.project.workspace;

import com.codeborne.selenide.WebDriverRunner;
import dk.byggeweb.objects.project.workspace.modals.FolderCreatePopup;
import dk.byggeweb.objects.project.workspace.modals.FolderDeletePopup;
import dk.byggeweb.objects.project.workspace.panels.FolderContentPanel;
import dk.byggeweb.objects.project.workspace.panels.FolderInformationPanel;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;

import static com.codeborne.selenide.Condition.text;

@Log4j
public class FolderSteps {
    @Step("Select folder")
    public void navigateToFolder(String name) {
        FolderContentPanel folderContentPanel = new FolderContentPanel();
        folderContentPanel.getFolderByName(name).click();
        log.info("Folder " + name + " was selected");
        new FolderContentPanel(name);
    }

    @Step("Create folder")
    public void createFolder(String parentFolderName, String createFolderName) {
        String winHandleBefore = WebDriverRunner.getWebDriver().getWindowHandle();
        FolderContentPanel folderContentPanel = new FolderContentPanel(parentFolderName);
        folderContentPanel.getCreateFolderButton().click();
        folderContentPanel.switchToNewWindow();
        FolderCreatePopup folderCreatePopup = new FolderCreatePopup();
        folderCreatePopup.createFolder(createFolderName);
        WebDriverRunner.getWebDriver().switchTo().window(winHandleBefore);
        new FolderContentPanel(createFolderName);
    }

    @Step("Rename folder")
    public void renameFolder(String fromFolderName, String toFolderName) {
        String winHandleBefore = WebDriverRunner.getWebDriver().getWindowHandle();
        FolderContentPanel folderContentPanel = new FolderContentPanel(fromFolderName);
        folderContentPanel.getRenameFolderButton().click();
        folderContentPanel.switchToNewWindow();
        FolderCreatePopup folderCreatePopup = new FolderCreatePopup();
        folderCreatePopup.renameFolder(toFolderName);
        WebDriverRunner.getWebDriver().switchTo().window(winHandleBefore);
        new FolderContentPanel(); // TODO: => bug, after fix use constructor with name parameter
    }

    @Step("Delete folder")
    public void deleteFolder(String parentFolderName) {
        String winHandleBefore = WebDriverRunner.getWebDriver().getWindowHandle();
        FolderContentPanel folderContentPanel = new FolderContentPanel();
        folderContentPanel.getDeleteFolderButton().click();
        folderContentPanel.switchToNewWindow();
        FolderDeletePopup folderDeletePopup = new FolderDeletePopup();
        folderDeletePopup.deleteFolder();
        WebDriverRunner.getWebDriver().switchTo().window(winHandleBefore);
        new FolderInformationPanel(parentFolderName);
    }

    @Step("Verify folder is present in the list")
    public void verifyFolderIsPresent(String name) {
        FolderContentPanel folderContentPanel = new FolderContentPanel(); // TODO: => bug, after fix use constructor with name parameter
        folderContentPanel.getFolderByName(name).shouldHave(text(name));
    }

    @Step("Verify folder is not present in the list")
    public void verifyFolderIsNotPresent(String name) {
        FolderContentPanel folderContentPanel = new FolderContentPanel();
        folderContentPanel.getFolderByName(name).shouldNotHave(text(name));
    }
}
