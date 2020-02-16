package dk.byggeweb.steps.project.workspace;

import com.codeborne.selenide.WebDriverRunner;
import dk.byggeweb.objects.project.workspace.modals.WSFolderCreatePopup;
import dk.byggeweb.objects.project.workspace.modals.WSFolderDeletePopup;
import dk.byggeweb.objects.project.workspace.panels.WSFolderContentPanel;
import dk.byggeweb.objects.project.workspace.panels.WSFolderInformationPanel;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;

import static com.codeborne.selenide.Condition.text;

@Log4j
public class WSFolderSteps {
    @Step("Select folder")
    public void navigateToFolder(String name) {
        WSFolderContentPanel wsFolderContentPanel = new WSFolderContentPanel();
        wsFolderContentPanel.getFolderByName(name).click();
        log.info("Folder " + name + " was selected");
        new WSFolderContentPanel(name);
    }

    @Step("Create folder")
    public void createFolder(String parentFolderName, String createFolderName) {
        String winHandleBefore = WebDriverRunner.getWebDriver().getWindowHandle();
        WSFolderContentPanel wsFolderContentPanel = new WSFolderContentPanel(parentFolderName);
        wsFolderContentPanel.getCreateFolderButton().click();
        wsFolderContentPanel.switchToNewWindow();
        WSFolderCreatePopup wsFolderCreatePopup = new WSFolderCreatePopup();
        wsFolderCreatePopup.createFolder(createFolderName);
        WebDriverRunner.getWebDriver().switchTo().window(winHandleBefore);
        new WSFolderContentPanel(createFolderName);
    }

    @Step("Rename folder")
    public void renameFolder(String fromFolderName, String toFolderName) {
        String winHandleBefore = WebDriverRunner.getWebDriver().getWindowHandle();
        WSFolderContentPanel wsFolderContentPanel = new WSFolderContentPanel(fromFolderName);
        wsFolderContentPanel.getRenameFolderButton().click();
        wsFolderContentPanel.switchToNewWindow();
        WSFolderCreatePopup wsFolderCreatePopup = new WSFolderCreatePopup();
        wsFolderCreatePopup.renameFolder(toFolderName);
        WebDriverRunner.getWebDriver().switchTo().window(winHandleBefore);
        new WSFolderContentPanel(); // TODO: => bug, after fix use constructor with name parameter
    }

    @Step("Delete folder")
    public void deleteFolder(String parentFolderName) {
        String winHandleBefore = WebDriverRunner.getWebDriver().getWindowHandle();
        WSFolderContentPanel wsFolderContentPanel = new WSFolderContentPanel();
        wsFolderContentPanel.getDeleteFolderButton().click();
        wsFolderContentPanel.switchToNewWindow();
        WSFolderDeletePopup wsFolderDeletePopup = new WSFolderDeletePopup();
        wsFolderDeletePopup.deleteFolder();
        WebDriverRunner.getWebDriver().switchTo().window(winHandleBefore);
        new WSFolderInformationPanel(parentFolderName);
    }

    @Step("Verify folder is present in the list")
    public void verifyFolderIsPresent(String name) {
        WSFolderContentPanel wsFolderContentPanel = new WSFolderContentPanel(); // TODO: => bug, after fix use constructor with name parameter
        wsFolderContentPanel.getFolderByName(name).shouldHave(text(name));
    }

    @Step("Verify folder is not present in the list")
    public void verifyFolderIsNotPresent(String name) {
        WSFolderContentPanel wsFolderContentPanel = new WSFolderContentPanel();
        wsFolderContentPanel.getFolderByName(name).shouldNotHave(text(name));
    }
}
