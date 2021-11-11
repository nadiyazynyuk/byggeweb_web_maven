package dk.byggeweb.steps.project.workspace;

import dk.byggeweb.objects.project.workspace.panels.WSFileInformationPanel;
import dk.byggeweb.objects.project.workspace.panels.WSMonitoredFilesContentPanel;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;

public class WSMonitorFilesSteps {

    @Step("Select file")
    public void selectFile(String fileName) {
        WSMonitoredFilesContentPanel panel = new WSMonitoredFilesContentPanel();
        panel.getFileByName(fileName).click();
        new WSFileInformationPanel(fileName);
    }

    @Step("Stop monitor file")
    public void stopMonitorFile(String filename) {
        selectFile(filename);
        WSMonitoredFilesContentPanel panel = new WSMonitoredFilesContentPanel();
        panel.getFileMonitorButton().click();
    }

    @Step("Verify file is not present in the list")
    public void verifyFileIsNotPresent(String name) {
        WSMonitoredFilesContentPanel panel = new WSMonitoredFilesContentPanel();
        panel.getFileByName(name).shouldNotBe(visible);
    }

    @Step("Verify file is present in the list")
    public void verifyFileIsPresent(String name) {
        WSMonitoredFilesContentPanel panel = new WSMonitoredFilesContentPanel();
        panel.getFileByName(name).shouldBe(visible);
    }

}
