package dk.byggeweb.steps.project.publicationspace;

import dk.byggeweb.objects.project.publicationspace.panels.PSFileInformationPanel;
import dk.byggeweb.objects.project.publicationspace.panels.PSMonitoredFilesContentPanel;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;

public class PSMonitorFilesSteps {

    @Step("Select file")
    public void selectFile(String fileName) {
        PSMonitoredFilesContentPanel psMonitoredFilesContentPanel = new PSMonitoredFilesContentPanel();
        psMonitoredFilesContentPanel.getFileByName(fileName).click();
        new PSFileInformationPanel(fileName);
    }

    @Step("Stop monitor file")
    public void stopMonitorFile(String filename) {
        selectFile(filename);
        PSMonitoredFilesContentPanel psMonitoredFilesContentPanel = new PSMonitoredFilesContentPanel();
        psMonitoredFilesContentPanel.getFileMonitorButton().click();
    }

    @Step("Verify file is not present in the list")
    public void verifyFileIsNotPresent(String name) {
        PSMonitoredFilesContentPanel psMonitoredFilesContentPanel = new PSMonitoredFilesContentPanel();
        psMonitoredFilesContentPanel.getFileByName(name).shouldNotBe(visible);
    }

    @Step("Verify file is present in the list")
    public void verifyFileIsPresent(String name) {
        PSMonitoredFilesContentPanel psMonitoredFilesContentPanel = new PSMonitoredFilesContentPanel();
        psMonitoredFilesContentPanel.getFileByName(name).shouldBe(visible);
    }

}
