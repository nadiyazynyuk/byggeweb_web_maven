package dk.byggeweb.steps.project.workspace;

import com.codeborne.selenide.WebDriverRunner;
import dk.byggeweb.objects.project.workspace.modals.WSEditMonitorFolderPopup;
import dk.byggeweb.objects.project.workspace.panels.WSMonitoredFoldersContentPanel;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;

public class WSMonitorFoldersSteps {

    @Step("Stop monitor folder")
    public void stopMonitorFolder(String name) {
        String winHandleBefore = WebDriverRunner.getWebDriver().getWindowHandle();
        WSMonitoredFoldersContentPanel panel = new WSMonitoredFoldersContentPanel();
        panel.getFolderByName(name).click();
        panel.switchToNewWindow();
        WSEditMonitorFolderPopup wsEditMonitorFolderPopup = new WSEditMonitorFolderPopup();
        wsEditMonitorFolderPopup.getDeleteButton().click();
        WebDriverRunner.getWebDriver().switchTo().window(winHandleBefore);
    }

    @Step("Verify folder is not present in the list")
    public void verifyFolderIsNotPresent(String name) {
        WSMonitoredFoldersContentPanel panel = new WSMonitoredFoldersContentPanel();
        panel.getFolderByName(name).shouldNotHave(text(name));
    }

    @Step("Verify folder is present in the list")
    public void verifyFolderIsPresent(String name) {
        WSMonitoredFoldersContentPanel panel = new WSMonitoredFoldersContentPanel();
        panel.getFolderByName(name).shouldHave(text(name));
    }

}
