package dk.byggeweb.project.workspace.folders;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DownloadFolder extends ProjectTestBase {

    // https://itwofm.atlassian.net/browse/TSB-46

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToWorkspaceModule();
        projectHomePage.getWorkspaceNodesPanel().navigateToFolder(data.getFolderName());
        uploadFileIfNotPresentInWorkspaceFolder(getAbsolutePath(data.getFileToUploadPath()), data.getTestFileName());
    }

    @Test(description = "Download folder from Workspace")
    public void downloadFolder() {
        wsFolderSteps.generateDownloadFolderLink();
    }
}
