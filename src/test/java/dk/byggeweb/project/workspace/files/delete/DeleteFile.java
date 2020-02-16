package dk.byggeweb.project.workspace.files.delete;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeleteFile extends ProjectTestBase {

    // https://itwofm.atlassian.net/browse/TSB-23

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToWorkspaceModule();
        wsFolderSteps.navigateToFolder(data.getFolderName());
        wsFileSteps.enhancedUploadSingleFile(getAbsolutePath(data.getFileToUploadPath()));
        wsFileSteps.closeEditFileInformationPopup();
        wsFileSteps.verifyFileIsPresent(data.getTestFileName());
    }

    @Test(description = "Delete file permanently")
    public void deleteFile() {
        wsFileSteps.deleteFilePermanently(data.getTestFileName());
        wsFileSteps.verifyFileIsNotPresent(data.getTestFileName());
    }

}