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
                wsMonitorFilesSteps.stopMonitorFile(data.getTestFileName());
                wsMonitorFilesSteps.verifyFileIsNotPresent(data.getTestFileName());
            } catch (com.codeborne.selenide.ex.ElementNotFound e) {
                break;
            }
        }
        wsFolderSteps.navigateToFolder(data.getFolderName());
        uploadFileIfNotPresentInWorkspaceFolder(data.getFileToUploadPath(), data.getTestFileName());
    }

    @Test(description = "Start file monitoring")
    public void monitorFile() {
        wsFileSteps.startMonitorFile(data.getTestFileName());
        projectHomePage.getWorkspaceNodesPanel().navigateToMonitoredFiles();
        wsMonitorFilesSteps.verifyFileIsPresent(data.getTestFileName());
    }

}
