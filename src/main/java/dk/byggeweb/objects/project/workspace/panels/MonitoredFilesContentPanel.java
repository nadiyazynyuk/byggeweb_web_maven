package dk.byggeweb.objects.project.workspace.panels;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;

public class MonitoredFilesContentPanel extends WorkspaceContentPanel {

    @Step("Stop monitor file")
    public void stopMonitorFile(String filename) {
        clickOnFile(filename);
        getFileMonitorButton().click();
    }

    public MonitoredFilesContentPanel(String title) {
        getPanelTitle().shouldHave(text(title));
    }
}
