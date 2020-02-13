package dk.byggeweb.steps.project.workspace;

import dk.byggeweb.objects.project.workspace.panels.FileInformationPanel;
import dk.byggeweb.objects.project.workspace.panels.FolderContentPanel;
import dk.byggeweb.objects.project.workspace.panels.MonitoredFilesContentPanel;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;

public class MonitoredFilesSteps {

    @Step("Select file")
    public void selectFile(String fileName) {
        FolderContentPanel folderContentPanel = new FolderContentPanel();
        folderContentPanel.getFileByName(fileName).click();
        new FileInformationPanel(fileName);
    }

    @Step("Stop monitor file")
    public void stopMonitorFile(String filename) {
        selectFile(filename);
        MonitoredFilesContentPanel panel = new MonitoredFilesContentPanel();
        panel.getFileMonitorButton().click();
    }

    @Step("Verify file is not present in the list")
    public void verifyFileIsNotPresent(String name) {
        MonitoredFilesContentPanel panel = new MonitoredFilesContentPanel();
        panel.getFileByName(name).shouldNotHave(text(name));
    }

    @Step("Verify file is present in the list")
    public void verifyFileIsPresent(String name) {
        FolderContentPanel folderContentPanel = new FolderContentPanel();
        folderContentPanel.getFileByName(name).shouldHave(text(name));
    }

}
