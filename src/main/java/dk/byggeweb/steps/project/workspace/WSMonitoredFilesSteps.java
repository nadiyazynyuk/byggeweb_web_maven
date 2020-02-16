package dk.byggeweb.steps.project.workspace;

import dk.byggeweb.objects.project.workspace.panels.WSFileInformationPanel;
import dk.byggeweb.objects.project.workspace.panels.WSFolderContentPanel;
import dk.byggeweb.objects.project.workspace.panels.WSMonitoredFilesContentPanel;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;

public class WSMonitoredFilesSteps {

    @Step("Select file")
    public void selectFile(String fileName) {
        WSFolderContentPanel wsFolderContentPanel = new WSFolderContentPanel();
        wsFolderContentPanel.getFileByName(fileName).click();
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
        panel.getFileByName(name).shouldNotHave(text(name));
    }

    @Step("Verify file is present in the list")
    public void verifyFileIsPresent(String name) {
        WSFolderContentPanel wsFolderContentPanel = new WSFolderContentPanel();
        wsFolderContentPanel.getFileByName(name).shouldHave(text(name));
    }

}
