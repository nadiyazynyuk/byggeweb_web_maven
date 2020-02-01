package dk.byggeweb.project.workspace.files.delete;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import dk.byggeweb.objects.project.ProjectHomePage;
import dk.byggeweb.objects.project.workspace.modals.FileInformationEditPopup;
import dk.byggeweb.objects.project.workspace.panels.WorkspaceContentPanel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeleteFile extends ProjectTestBase {

    // https://itwofm.atlassian.net/browse/TSB-23

    @BeforeClass
    public void prepareData() {
        projectHomePage = new ProjectHomePage(data.getProjectName());
        projectHomePage.navigateToWorkspaceModule();
        projectHomePage.getWorkspaceNodesPanel().clickOnFolder(data.getFolderName());

        workspaceContentPanel = new WorkspaceContentPanel(data.getFolderName());
        workspaceContentPanel.enhancedUploadSingleFile(getAbsolutePath(data.getFileToUploadPath()));
        FileInformationEditPopup fileInformationEditPopup = new FileInformationEditPopup();
        fileInformationEditPopup.closeEditFileInformation();
        workspaceContentPanel.verifyFileIsPresent(data.getTestFileName());
    }

    @Test(description = "Delete file permanently")
    public void deleteFile() {
        workspaceContentPanel.deleteFile(data.getTestFileName());
        workspaceContentPanel.verifyFileIsNotPresent(data.getTestFileName());
    }

}