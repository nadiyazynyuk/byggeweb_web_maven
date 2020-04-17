package dk.byggeweb.project.publicationspace.folders;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import io.qameta.allure.Link;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MonitorFolder extends ProjectTestBase {

    @Link(url = "https://itwofm.atlassian.net/browse/TSB-66")

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToPublicationSpace();
        projectHomePage.getPublicationSpaceNodesPanel().navigateToMonitoredFolders();

        try {
            psMonitorFoldersSteps.stopMonitorFolder(data.getDocumentListFolderName());
            psMonitorFoldersSteps.verifyFolderIsNotPresent(data.getDocumentListFolderName());
        } catch (com.codeborne.selenide.ex.ElementNotFound ignored) {
        }
    }

    @Test(description = "Start Document list folder monitoring")
    public void monitorFolder() {
        psFolderSteps.navigateToFolderInDocumentList(data.getDocumentListName(), data.getDocumentListFolderName());
        psFolderSteps.startMonitorFolder();
        projectHomePage.getPublicationSpaceNodesPanel().navigateToMonitoredFolders();
        psMonitorFoldersSteps.verifyFolderIsPresent(data.getDocumentListFolderName());
    }

}
