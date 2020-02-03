package dk.byggeweb.project.workspace.files.update;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import dk.byggeweb.objects.project.workspace.panels.FolderContentPanel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CopyFile extends ProjectTestBase {

    // https://itwofm.atlassian.net/browse/TSB-27

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToWorkspaceModule();

        deleteFileIfPresentInWorkspaceFolder(data.getFolder1Name(), data.getTestFileName());
        deleteFileIfPresentInWorkspaceFolder(data.getFolder2Name(), data.getTestFileName());
        uploadFileIfNotPresentInWorkspaceFolder(data.getFolder1Name(), data.getFileToUploadPath(), data.getTestFileName());
    }

    @Test(description = "Copy file to another folder")
    public void copyFile() {
        projectHomePage.getWorkspaceNodesPanel().navigateToFolder(data.getFolder1Name());
        folderContentPanel = new FolderContentPanel(data.getFolder1Name());

        folderContentPanel.copyFileToFolder(data.getTestFileName(), data.getFolder2Name(), data.getFolderName());
        folderContentPanel.verifyFileIsPresent(data.getTestFileName());

        projectHomePage.getWorkspaceNodesPanel().navigateToFolder(data.getFolder2Name());
        folderContentPanel = new FolderContentPanel(data.getFolder2Name());
        folderContentPanel.verifyFileIsPresent(data.getTestFileName());
    }

}
