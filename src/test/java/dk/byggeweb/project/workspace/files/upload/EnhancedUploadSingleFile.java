package dk.byggeweb.project.workspace.files.upload;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import dk.byggeweb.objects.project.workspace.modals.FileInformationEditPopup;
import dk.byggeweb.objects.project.workspace.panels.FolderContentPanel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EnhancedUploadSingleFile extends ProjectTestBase {

    // https://itwofm.atlassian.net/browse/TSB-14

    @BeforeClass
    public void deleteFileIfExists() {
        projectHomePage.navigateToWorkspaceModule();
        projectHomePage.getWorkspaceNodesPanel().navigateToFolder(data.getFolderName());

        folderContentPanel = new FolderContentPanel(data.getFolderName());

        while (true) {
            try {
                folderContentPanel.deleteFile(data.getTestFileName());
            } catch (com.codeborne.selenide.ex.ElementNotFound e) {
                break;
            }
        }
    }

    @Test(description = "Enhanced upload file into Project root folder")
    public void uploadFile() {
        folderContentPanel.enhancedUploadSingleFile(getAbsolutePath(data.getFileToUploadPath()));
        FileInformationEditPopup fileInformationEditPopup = new FileInformationEditPopup();
        fileInformationEditPopup.closeEditFileInformation();
        folderContentPanel.verifyFileIsPresent(data.getTestFileName());
    }

}
