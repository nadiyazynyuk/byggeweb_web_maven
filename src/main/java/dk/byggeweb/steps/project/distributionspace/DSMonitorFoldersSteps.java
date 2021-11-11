package dk.byggeweb.steps.project.distributionspace;

import com.codeborne.selenide.WebDriverRunner;
import dk.byggeweb.objects.project.distributionspace.modals.DSMonitorFolderEditPopup;
import dk.byggeweb.objects.project.distributionspace.panels.DSMonitoredFoldersContentPanel;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;

public class DSMonitorFoldersSteps {

    @Step("Stop monitor folder in Publication space")
    public void stopMonitorFolder(String name) {
        String winHandleBefore = WebDriverRunner.getWebDriver().getWindowHandle();
        DSMonitoredFoldersContentPanel dsMonitoredFoldersContentPanel = new DSMonitoredFoldersContentPanel();
        dsMonitoredFoldersContentPanel.getFolderByName(name).click();
        dsMonitoredFoldersContentPanel.switchToNewWindow();
        DSMonitorFolderEditPopup dsMonitorFolderEditPopup = new DSMonitorFolderEditPopup();
        dsMonitorFolderEditPopup.getDeleteButton().click();
        WebDriverRunner.getWebDriver().switchTo().window(winHandleBefore);
    }

    @Step("Verify folder is not present in the list in Publication space")
    public void verifyFolderIsNotPresent(String name) {
        DSMonitoredFoldersContentPanel dsMonitoredFoldersContentPanel = new DSMonitoredFoldersContentPanel();
        dsMonitoredFoldersContentPanel.getFolderByName(name).shouldNotBe(visible);
    }

    @Step("Verify folder is present in the list in Publication space")
    public void verifyFolderIsPresent(String name) {
        DSMonitoredFoldersContentPanel dsMonitoredFoldersContentPanel = new DSMonitoredFoldersContentPanel();
        dsMonitoredFoldersContentPanel.getFolderByName(name).shouldBe(visible);
    }

}
