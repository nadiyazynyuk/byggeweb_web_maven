package dk.byggeweb.steps.project.publicationspace;

import com.codeborne.selenide.WebDriverRunner;
import dk.byggeweb.objects.project.publicationspace.modals.PSMonitorFolderEditPopup;
import dk.byggeweb.objects.project.publicationspace.panels.PSMonitoredFoldersContentPanel;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;

public class PSMonitorFoldersSteps {

    @Step("Stop monitor folder in Publication space")
    public void stopMonitorFolder(String name) {
        String winHandleBefore = WebDriverRunner.getWebDriver().getWindowHandle();
        PSMonitoredFoldersContentPanel psMonitoredFoldersContentPanel = new PSMonitoredFoldersContentPanel();
        psMonitoredFoldersContentPanel.getFolderByName(name).click();
        psMonitoredFoldersContentPanel.switchToNewWindow();
        PSMonitorFolderEditPopup PSMonitorFolderEditPopup = new PSMonitorFolderEditPopup();
        PSMonitorFolderEditPopup.getDeleteButton().click();
        WebDriverRunner.getWebDriver().switchTo().window(winHandleBefore);
    }

    @Step("Verify folder is not present in the list in Publication space")
    public void verifyFolderIsNotPresent(String name) {
        PSMonitoredFoldersContentPanel psMonitoredFoldersContentPanel = new PSMonitoredFoldersContentPanel();
        psMonitoredFoldersContentPanel.getFolderByName(name).shouldNotHave(text(name));
    }

    @Step("Verify folder is present in the list in Publication space")
    public void verifyFolderIsPresent(String name) {
        PSMonitoredFoldersContentPanel psMonitoredFoldersContentPanel = new PSMonitoredFoldersContentPanel();
        psMonitoredFoldersContentPanel.getFolderByName(name).shouldHave(text(name));
    }

}
