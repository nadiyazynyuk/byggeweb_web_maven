package dk.byggeweb.project.workspace.files.update;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CopyFile extends ProjectTestBase {

    // https://itwofm.atlassian.net/browse/TSB-27

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToWorkspaceModule();

        wsFolderSteps.navigateToFolder(data.getFolder1Name());
        deleteFileIfPresentInWorkspaceFolder(data.getTestFileName());

        wsFolderSteps.navigateToFolder(data.getFolder2Name());
        deleteFileIfPresentInWorkspaceFolder(data.getTestFileName());

        wsFolderSteps.navigateToFolder(data.getFolder1Name());
        uploadFileIfNotPresentInWorkspaceFolder(data.getFileToUploadPath(), data.getTestFileName());
    }

    @Test(description = "Copy file to another folder")
    public void copyFile() {
        wsFileSteps.copyFileToFolder(data.getTestFileName(), data.getFolder2Name(), data.getFolderName());
        wsFileSteps.verifyFileIsPresent(data.getTestFileName());

        projectHomePage.getWorkspaceNodesPanel().navigateToFolder(data.getFolder2Name());
        wsFileSteps.verifyFileIsPresent(data.getTestFileName());
    }

}
