package dk.byggeweb.project.publicationspace.files.update;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MonitorFile extends ProjectTestBase {

    // https://itwofm.atlassian.net/browse/TSB-67

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToPublicationSpace();
        projectHomePage.getPublicationSpaceNodesPanel().navigateToMonitoredFiles();
        while (true) {
            try {
                psMonitorFilesSteps.stopMonitorFile(data.getTestFileName());
                psMonitorFilesSteps.verifyFileIsNotPresent(data.getTestFileName());
            } catch (com.codeborne.selenide.ex.ElementNotFound e) {
                break;
            }
        }
        psFolderSteps.navigateToFolderInDocumentList(data.getDocumentListName(), data.getDocumentListFolderName());
        uploadFileIfMNotPresentInDocumentListFolder(data.getFileToUploadPath(), data.getTestFileName());
    }

    @Test(description = "Start Document list file monitoring")
    public void monitorFile() {
        psFileSteps.startMonitorFile(data.getTestFileName());
        projectHomePage.getPublicationSpaceNodesPanel().navigateToMonitoredFiles();
        psMonitorFilesSteps.verifyFileIsPresent(data.getTestFileName());
    }

}
