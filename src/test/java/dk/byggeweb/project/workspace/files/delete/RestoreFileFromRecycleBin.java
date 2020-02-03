package dk.byggeweb.project.workspace.files.delete;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import dk.byggeweb.objects.project.workspace.panels.RecycleBinContentPanel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RestoreFileFromRecycleBin extends ProjectTestBase {

    // https://itwofm.atlassian.net/browse/TSB-25

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToWorkspaceModule();

        deleteFileIfPresentInWorkspaceFolder("Recycle bin", data.getTestFileName());
        uploadFileIfNotPresentInWorkspaceFolder(data.getFolderName(), data.getFileToUploadPath(), data.getTestFileName());
        placeFileInRecycleBin();
    }

    @Test(description = "Restore file from Recycle bin")
    public void restoreFile() {
        projectHomePage.getWorkspaceNodesPanel().navigateToRecycleBin();
        RecycleBinContentPanel recycleBinContentPanel = new RecycleBinContentPanel();
        recycleBinContentPanel.restoreFile(data.getTestFileName(), data.getFolderName());
        projectHomePage.getWorkspaceNodesPanel().navigateToFolder(data.getFolderName());
        folderContentPanel.verifyFileIsPresent(data.getTestFileName());
    }

    private void placeFileInRecycleBin() {
        folderContentPanel.moveFileToRecycleBin(data.getTestFileName());
        folderContentPanel.verifyFileIsNotPresent(data.getTestFileName());
    }
}
