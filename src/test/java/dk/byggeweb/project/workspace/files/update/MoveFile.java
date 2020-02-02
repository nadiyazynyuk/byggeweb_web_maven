package dk.byggeweb.project.workspace.files.update;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import dk.byggeweb.objects.project.workspace.panels.WorkspaceContentPanel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MoveFile extends ProjectTestBase {

    // https://itwofm.atlassian.net/browse/TSB-26

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToWorkspaceModule();

        uploadFileIfNotPresentInWorkspaceFolder(data.getFolder1Name(), data.getFileToUploadPath(), data.getTestFileName());
        deleteFileIfPresentInWorkspaceFolder(data.getFolder2Name(), data.getTestFileName());
    }

    @Test(description = "Move file to another folder")
    public void moveFile() {
        projectHomePage.getWorkspaceNodesPanel().clickOnFolder(data.getFolder1Name());
        workspaceContentPanel = new WorkspaceContentPanel(data.getFolder1Name());
        workspaceContentPanel.moveFileToFolder(data.getTestFileName(), data.getFolder2Name(), data.getFolderName());
        workspaceContentPanel.verifyFileIsNotPresent(data.getTestFileName());

        projectHomePage.getWorkspaceNodesPanel().clickOnFolder(data.getFolder2Name());
        workspaceContentPanel = new WorkspaceContentPanel(data.getFolder2Name());
        workspaceContentPanel.verifyFileIsPresent(data.getTestFileName());
    }
}
