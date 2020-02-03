package dk.byggeweb.project.workspace.files.delete;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import dk.byggeweb.objects.project.workspace.modals.FileInformationEditPopup;
import dk.byggeweb.objects.project.workspace.panels.FolderContentPanel;
import dk.byggeweb.objects.project.workspace.panels.RecycleBinContentPanel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeleteFileViaRecycleBin extends ProjectTestBase {

    // https://itwofm.atlassian.net/browse/TSB-24

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToWorkspaceModule();
        projectHomePage.getWorkspaceNodesPanel().navigateToFolder(data.getFolderName());

        folderContentPanel = new FolderContentPanel(data.getFolderName());
        folderContentPanel.enhancedUploadSingleFile(getAbsolutePath(data.getFileToUploadPath()));
        FileInformationEditPopup fileInformationEditPopup = new FileInformationEditPopup();
        fileInformationEditPopup.closeEditFileInformation();
        folderContentPanel.verifyFileIsPresent(data.getTestFileName());
    }

    @Test(description = "Delete file via Recycle bin")
    public void deleteFile() {
        folderContentPanel.moveFileToRecycleBin(data.getTestFileName());
        folderContentPanel.verifyFileIsNotPresent(data.getTestFileName());
        projectHomePage.getWorkspaceNodesPanel().navigateToRecycleBin();
        RecycleBinContentPanel recycleBinContentPanel = new RecycleBinContentPanel();
        recycleBinContentPanel.deleteFile(data.getTestFileName());
        recycleBinContentPanel.verifyFileIsNotPresent(data.getTestFileName());
    }
}
