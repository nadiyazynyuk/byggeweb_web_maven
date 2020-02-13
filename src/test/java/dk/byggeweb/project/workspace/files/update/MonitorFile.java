package dk.byggeweb.project.workspace.files.update;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MonitorFile extends ProjectTestBase {

    // https://itwofm.atlassian.net/browse/TSB-29

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToWorkspaceModule();
        projectHomePage.getWorkspaceNodesPanel().navigateToMonitoredFiles();
        while (true) {
            try {
                monitoredFilesSteps.stopMonitorFile(data.getTestFileName());
                monitoredFilesSteps.verifyFileIsNotPresent(data.getTestFileName());
            } catch (com.codeborne.selenide.ex.ElementNotFound e) {
                break;
            }
        }
        uploadFileIfNotPresentInWorkspaceFolder(data.getFolderName(), data.getFileToUploadPath(), data.getTestFileName());
    }

    @Test(description = "Start file monitoring")
    public void monitorFile() {
        fileSteps.startMonitorFile(data.getTestFileName());
        projectHomePage.getWorkspaceNodesPanel().navigateToMonitoredFiles();
        monitoredFilesSteps.verifyFileIsPresent(data.getTestFileName());
    }

}
