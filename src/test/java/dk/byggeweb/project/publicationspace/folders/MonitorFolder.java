package dk.byggeweb.project.publicationspace.folders;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MonitorFolder extends ProjectTestBase {

    // https://itwofm.atlassian.net/browse/TSB-66

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToPublicationSpace();
        projectHomePage.getPublicationSpaceNodesPanel().navigateToMonitoredFolders();
        while (true) {
            try {
                pSMonitorFoldersSteps.stopMonitorFolder(data.getDocumentListFolderName());
                pSMonitorFoldersSteps.verifyFolderIsNotPresent(data.getDocumentListFolderName());
            } catch (com.codeborne.selenide.ex.ElementNotFound e) {
                break;
            }
        }
    }

    @Test(description = "Start Document list folder monitoring")
    public void monitorFolder() {
        psFolderSteps.navigateToFolderInDocumentList(data.getDocumentListName(), data.getDocumentListFolderName());
        psFolderSteps.startMonitorFolder();
        projectHomePage.getPublicationSpaceNodesPanel().navigateToMonitoredFolders();
        pSMonitorFoldersSteps.verifyFolderIsPresent(data.getDocumentListFolderName());
    }

}
