package dk.byggeweb.project.workspace.files.open;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import dk.byggeweb.objects.project.workspace.modals.FileInformationEditPopup;
import dk.byggeweb.objects.project.workspace.panels.FileInformationPanel;
import dk.byggeweb.objects.project.workspace.panels.WorkspaceContentPanel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OpenFileVersion extends ProjectTestBase {

    // https://itwofm.atlassian.net/browse/TSB-21

    @BeforeClass
    public void deleteFileIfExists() {
        projectHomePage.navigateToWorkspaceModule();
        projectHomePage.getWorkspaceNodesPanel().clickOnFolder(data.getFolderName());

        workspaceContentPanel = new WorkspaceContentPanel(data.getFolderName());

        while (true) {
            try {
                workspaceContentPanel.deleteFile(data.getTestFileName());
            } catch (com.codeborne.selenide.ex.ElementNotFound e) {
                break;
            }
        }
    }

    @Test(description = "Upload first file version into Project root folder")
    public void uploadFirstFileVersion() {
        workspaceContentPanel.enhancedUploadSingleFile(data.getFileV1ToUploadPath());
        FileInformationEditPopup fileInformationEditPopup = new FileInformationEditPopup();
        fileInformationEditPopup.closeEditFileInformation();
        workspaceContentPanel.verifyFileIsPresent(data.getTestFileName());
    }

    @Test(dependsOnMethods = "uploadFirstFileVersion", description = "Upload second file version into Project root folder")
    public void uploadSecondFileVersion() {
        workspaceContentPanel.enhancedUploadSingleFile(data.getFileV2ToUploadPath());
        FileInformationEditPopup fileInformationEditPopup = new FileInformationEditPopup();
        fileInformationEditPopup.closeEditFileInformation();
        workspaceContentPanel.verifyFileIsPresent(data.getTestFileName());
    }

    @Test(dependsOnMethods = "uploadSecondFileVersion", description = "Open latest file version")
    public void openLatestFileVersion() {
        workspaceContentPanel.clickOnFile(data.getTestFileName());
        FileInformationPanel fileInformationPanelTab = new FileInformationPanel(data.getTestFileName());
        fileInformationPanelTab.openFile(data.getFileV2Content());
    }

    @Test(dependsOnMethods = "openLatestFileVersion", description = "Open first file version")
    public void openFirstFileVersion() {
        workspaceContentPanel.clickOnFile(data.getTestFileName());
        FileInformationPanel fileInformationPanelTab = new FileInformationPanel(data.getTestFileName());
        fileInformationPanelTab.selectFileVersion(data.getFileV1VersionIndex());
        fileInformationPanelTab.openPreviousFileVersion(data.getFileV1Content());
    }
}
