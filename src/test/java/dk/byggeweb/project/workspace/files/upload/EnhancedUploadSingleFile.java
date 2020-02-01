package dk.byggeweb.project.workspace.files.upload;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import dk.byggeweb.objects.project.ProjectHomePage;
import dk.byggeweb.objects.project.workspace.modals.FileInformationEditPopup;
import dk.byggeweb.objects.project.workspace.panels.WorkspaceContentPanel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EnhancedUploadSingleFile extends ProjectTestBase {

    // https://itwofm.atlassian.net/browse/TSB-14

    @BeforeClass
    public void deleteFileIfExists() {
        projectHomePage = new ProjectHomePage(data.getProjectName());
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

    @Test(description = "Enhanced upload file into Project root folder")
    public void uploadFile() {
        workspaceContentPanel.enhancedUploadSingleFile(getAbsolutePath(data.getFileToUploadPath()));
        FileInformationEditPopup fileInformationEditPopup = new FileInformationEditPopup();
        fileInformationEditPopup.closeEditFileInformation();
        workspaceContentPanel.verifyFileIsPresent(data.getTestFileName());
    }

}
