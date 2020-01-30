package dk.byggeweb.project.workspace.files.delete;

import dk.byggeweb.infrastructure.steps.GeneralSteps;
import dk.byggeweb.infrastructure.test.ProjectTestBase;
import dk.byggeweb.objects.project.ProjectHomePage;
import dk.byggeweb.objects.project.workspace.modals.FileInformationEditPopup;
import dk.byggeweb.objects.project.workspace.panels.RecycleBinContentPanel;
import dk.byggeweb.objects.project.workspace.panels.WorkspaceContentPanel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeleteFileViaRecycleBin extends ProjectTestBase {

    // https://itwofm.atlassian.net/browse/TSB-24

    @BeforeClass
    public void prepareData() {
        GeneralSteps.loginAsVerifiedUser(data.getUserName(),data.getPassword(), data.getName());
        GeneralSteps.launchProject(data.getProjectLink());

        projectHomePage = new ProjectHomePage(data.getProjectName());
        projectHomePage.navigateToWorkspaceModule();
        projectHomePage.getWorkspaceNodesPanel().clickOnFolder(data.getFolderName());

        workspaceContentPanel = new WorkspaceContentPanel(data.getFolderName());
        workspaceContentPanel.enhancedUploadSingleFile(getAbsolutePath(data.getFileToUploadPath()));
        FileInformationEditPopup fileInformationEditPopup = new FileInformationEditPopup();
        fileInformationEditPopup.closeEditFileInformation();
        workspaceContentPanel.verifyFileIsPresent(data.getTestFileName());
    }

    @Test(description = "Delete file via Recycle bin")
    public void deleteFile() {
        workspaceContentPanel.moveFileToRecycleBin(data.getTestFileName());
        workspaceContentPanel.verifyFileIsNotPresent(data.getTestFileName());
        projectHomePage.getWorkspaceNodesPanel().getRecycleBinNode().click();
        RecycleBinContentPanel recycleBinContentPanel = new RecycleBinContentPanel("Recycle bin");
        recycleBinContentPanel.deleteFile(data.getTestFileName());
        recycleBinContentPanel.verifyFileIsNotPresent(data.getTestFileName());
    }
}
