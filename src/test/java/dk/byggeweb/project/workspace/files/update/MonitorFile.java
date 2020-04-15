package dk.byggeweb.project.workspace.files.update;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import io.qameta.allure.Link;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MonitorFile extends ProjectTestBase {

    @Link(url = "https://itwofm.atlassian.net/browse/TSB-29")

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToWorkspaceModule();
        projectHomePage.getWorkspaceNodesPanel().navigateToMonitoredFiles();

        try {
            wsMonitorFilesSteps.stopMonitorFile(data.getTestFileName());
            wsMonitorFilesSteps.verifyFileIsNotPresent(data.getTestFileName());
        } catch (com.codeborne.selenide.ex.ElementNotFound ignored) {
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
