package dk.byggeweb.steps.project.distributionspace;

import dk.byggeweb.objects.project.distributionspace.panels.DSFileInformationPanel;
import dk.byggeweb.objects.project.distributionspace.panels.DSMonitoredFilesContentPanel;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;

public class DSMonitorFilesSteps {

    @Step("Select file")
    public void selectFile(String fileName) {
        DSMonitoredFilesContentPanel dsMonitoredFilesContentPanel = new DSMonitoredFilesContentPanel();
        dsMonitoredFilesContentPanel.getFileByName(fileName).click();
        new DSFileInformationPanel(fileName);
    }

    @Step("Stop monitor file")
    public void stopMonitorFile(String filename) {
        selectFile(filename);
        DSMonitoredFilesContentPanel dsMonitoredFilesContentPanel = new DSMonitoredFilesContentPanel();
        dsMonitoredFilesContentPanel.getFileMonitorButton().click();
    }

    @Step("Verify file is not present in the list")
    public void verifyFileIsNotPresent(String name) {
        DSMonitoredFilesContentPanel dsMonitoredFilesContentPanel = new DSMonitoredFilesContentPanel();
        dsMonitoredFilesContentPanel.getFileByName(name).shouldNotHave(text(name));
    }

    @Step("Verify file is present in the list")
    public void verifyFileIsPresent(String name) {
        DSMonitoredFilesContentPanel dsMonitoredFilesContentPanel = new DSMonitoredFilesContentPanel();
        dsMonitoredFilesContentPanel.getFileByName(name).shouldHave(text(name));
    }

}
