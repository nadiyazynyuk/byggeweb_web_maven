package dk.byggeweb.project.workspace.files.delete;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeleteFileViaRecycleBin extends ProjectTestBase {

    // https://itwofm.atlassian.net/browse/TSB-24

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToWorkspaceModule();
        folderSteps.navigateToFolder(data.getFolderName());
        fileSteps.enhancedUploadSingleFile(getAbsolutePath(data.getFileToUploadPath()));
        fileSteps.closeEditFileInformationPopup();
        fileSteps.verifyFileIsPresent(data.getTestFileName());
    }

    @Test(description = "Delete file via Recycle bin")
    public void deleteFile() {
        fileSteps.moveFileToRecycleBin(data.getTestFileName());
        fileSteps.verifyFileIsNotPresent(data.getTestFileName());
        projectHomePage.getWorkspaceNodesPanel().navigateToRecycleBin();
        recycleBinSteps.deleteFileFromRecycleBin(data.getTestFileName());
        recycleBinSteps.verifyFileIsNotPresent(data.getTestFileName());
    }
}
