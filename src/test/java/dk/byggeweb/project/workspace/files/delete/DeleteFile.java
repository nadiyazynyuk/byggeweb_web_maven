package dk.byggeweb.project.workspace.files.delete;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeleteFile extends ProjectTestBase {

    // https://itwofm.atlassian.net/browse/TSB-23

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToWorkspaceModule();
        folderSteps.navigateToFolder(data.getFolderName());
        fileSteps.enhancedUploadSingleFile(getAbsolutePath(data.getFileToUploadPath()));
        fileSteps.closeEditFileInformationPopup();
        fileSteps.verifyFileIsPresent(data.getTestFileName());
    }

    @Test(description = "Delete file permanently")
    public void deleteFile() {
        fileSteps.deleteFilePermanently(data.getTestFileName());
        fileSteps.verifyFileIsNotPresent(data.getTestFileName());
    }

}