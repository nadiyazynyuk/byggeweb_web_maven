package dk.byggeweb.project.workspace.files.update;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import dk.byggeweb.objects.project.workspace.panels.MonitoredFilesContentPanel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MonitorFile extends ProjectTestBase {

    // https://itwofm.atlassian.net/browse/TSB-29

    private MonitoredFilesContentPanel monitoredFilesContentPanel;

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToWorkspaceModule();
        projectHomePage.getWorkspaceNodesPanel().navigateToMonitoredFiles();
        monitoredFilesContentPanel = new MonitoredFilesContentPanel("Monitored files");
        while (true) {
            try {
                monitoredFilesContentPanel.stopMonitorFile(data.getTestFileName());
                monitoredFilesContentPanel.verifyFileIsNotPresent(data.getTestFileName());
            } catch (com.codeborne.selenide.ex.ElementNotFound e) {
                break;
            }
        }
        uploadFileIfNotPresentInWorkspaceFolder(data.getFolderName(), data.getFileToUploadPath(), data.getTestFileName());
    }

    @Test(description = "Start file monitoring")
    public void monitorFile() {
        workspaceContentPanel.startMonitorFile(data.getTestFileName());
        projectHomePage.getWorkspaceNodesPanel().navigateToMonitoredFiles();
        monitoredFilesContentPanel = new MonitoredFilesContentPanel("Monitored files");
        monitoredFilesContentPanel.verifyFileIsPresent(data.getTestFileName());
    }

}
