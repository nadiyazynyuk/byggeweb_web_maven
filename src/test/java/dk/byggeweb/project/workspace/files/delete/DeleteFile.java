package dk.byggeweb.project.workspace.files.delete;

import dk.byggeweb.infrastructure.steps.GeneralSteps;
import dk.byggeweb.infrastructure.test.ProjectTestBase;
import dk.byggeweb.objects.pages.project.ProjectHomePage;
import dk.byggeweb.objects.pages.project.workspace.modals.FileInformationEditPopup;
import dk.byggeweb.objects.pages.project.workspace.panels.WorkspaceContentPanel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeleteFile extends ProjectTestBase {

    // https://itwofm.atlassian.net/browse/TSB-23

    @BeforeClass
    public void prepareData() {
        GeneralSteps.loginAsVerifiedUser(data.getUserName(),data.getPassword(), data.getName());
        GeneralSteps.launchProject(data.getProjectLink());

        ProjectHomePage projectHomePage = new ProjectHomePage(data.getProjectName());
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