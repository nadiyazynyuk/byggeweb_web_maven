package dk.byggeweb.project.workspace.files.search;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class QuickSearchFile extends ProjectTestBase {

    // https://itwofm.atlassian.net/browse/TSB-44

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToWorkspaceModule();
        wsFolderSteps.navigateToFolder(data.getFolderName());
        uploadFileIfNotPresentInWorkspaceFolder(getAbsolutePath(data.getFileToUploadPath()), data.getTestFileName());
    }

    @Test(description = "Quick search for the file in Workspace")
    public void quickSearchFile() {
        searchSteps.quickSearchFileInWorkspace(data.getTestFileName());
        wsFileSteps.verifyFileIsPresent(data.getTestFileName());
    }
}
