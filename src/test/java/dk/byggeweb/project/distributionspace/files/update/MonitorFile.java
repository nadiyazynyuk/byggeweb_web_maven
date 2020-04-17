package dk.byggeweb.project.distributionspace.files.update;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import io.qameta.allure.Link;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MonitorFile extends ProjectTestBase {

    @Link(url = "https://itwofm.atlassian.net/browse/TSB-82")

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToDistributionSpace();
        projectHomePage.getDistributionSpaceNodesPanel().navigateToMonitoredFiles();

        try {
            dsMonitorFilesSteps.stopMonitorFile(data.getTestFileName());
            dsMonitorFilesSteps.verifyFileIsNotPresent(data.getTestFileName());
        } catch (com.codeborne.selenide.ex.ElementNotFound ignored) {
        }

        dsFolderSteps.navigateToFolderInDocumentListInDistributionList(data.getDistributionListName(), data.getDocumentListName(), data.getDocumentListFolderName());

        try {
            dsFileSteps.verifyFileIsPresent(data.getTestFileName());
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            projectHomePage.navigateToPublicationSpace();
            psFolderSteps.navigateToFolderInDocumentList(data.getDocumentListName(), data.getDocumentListFolderName());
            uploadFileIfNotPresentInDocumentListFolder(data.getFileToUploadPath(), data.getTestFileName());
            psFileSteps.distributeFile(data.getTestFileName(), data.getDistributionListName());
            projectHomePage.navigateToDistributionSpace();
        }
    }

    @Test(description = "Start Distribution list file monitoring")
    public void monitorFile() {
        dsFileSteps.startMonitorFile(data.getTestFileName());
        projectHomePage.getDistributionSpaceNodesPanel().navigateToMonitoredFiles();
        dsMonitorFilesSteps.verifyFileIsPresent(data.getTestFileName());
    }
}
