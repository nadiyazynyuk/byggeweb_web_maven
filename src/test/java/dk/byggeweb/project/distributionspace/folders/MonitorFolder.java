package dk.byggeweb.project.distributionspace.folders;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import io.qameta.allure.Link;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MonitorFolder extends ProjectTestBase {

    @Link(url = "https://itwofm.atlassian.net/browse/TSB-83")

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToDistributionSpace();
        projectHomePage.getDistributionSpaceNodesPanel().navigateToMonitoredFolders();

        try {
            dsMonitorFoldersSteps.stopMonitorFolder(data.getDocumentListFolderName());
            dsMonitorFoldersSteps.verifyFolderIsNotPresent(data.getDocumentListFolderName());
        } catch (com.codeborne.selenide.ex.ElementNotFound ignored) {
        }
    }

    @Test(description = "Start Document list folder monitoring in Distribution space")
    public void monitorFolder() {
        dsFolderSteps.navigateToFolderInDocumentListInDistributionList(data.getDistributionListName(), data.getDocumentListName(), data.getDocumentListFolderName());
        dsFolderSteps.startMonitorFolder();
        projectHomePage.getDistributionSpaceNodesPanel().navigateToMonitoredFolders();
        dsMonitorFoldersSteps.verifyFolderIsPresent(data.getDocumentListFolderName());
    }
}
