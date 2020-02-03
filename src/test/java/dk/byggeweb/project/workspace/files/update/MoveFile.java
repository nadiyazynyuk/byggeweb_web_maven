package dk.byggeweb.project.workspace.files.update;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import dk.byggeweb.objects.project.workspace.panels.FolderContentPanel;
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
        projectHomePage.getWorkspaceNodesPanel().navigateToFolder(data.getFolder1Name());
        folderContentPanel = new FolderContentPanel(data.getFolder1Name());
        folderContentPanel.moveFileToFolder(data.getTestFileName(), data.getFolder2Name(), data.getFolderName());
        folderContentPanel.verifyFileIsNotPresent(data.getTestFileName());

        projectHomePage.getWorkspaceNodesPanel().navigateToFolder(data.getFolder2Name());
        folderContentPanel = new FolderContentPanel(data.getFolder2Name());
        folderContentPanel.verifyFileIsPresent(data.getTestFileName());
    }
}
