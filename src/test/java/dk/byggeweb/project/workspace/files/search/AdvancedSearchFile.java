package dk.byggeweb.project.workspace.files.search;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AdvancedSearchFile extends ProjectTestBase {

    // https://itwofm.atlassian.net/browse/TSB-45

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToWorkspaceModule();
        wsFolderSteps.navigateToFolder(data.getFolderName());
        uploadFileIfNotPresentInWorkspaceFolder(getAbsolutePath(data.getFileToUploadPath()), data.getTestFileName());
    }

    @Test(description = "Advanced search for the file by filename in Workspace")
    public void advancedSearchFileByName() {
        searchSteps.advancedSearchFileByNameInWorkspace(data.getTestFileName());
        wsFileSteps.verifyFileIsPresent(data.getTestFileName());
    }

}
