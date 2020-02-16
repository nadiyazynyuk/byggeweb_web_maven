package dk.byggeweb.project.workspace.files.publish;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PublishFile extends ProjectTestBase {

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToPublicationSpace();
        psFolderSteps.navigateToDocumentList(data.getDocumentListName());
        //TODO:

        projectHomePage.navigateToWorkspaceModule();
        uploadFileIfNotPresentInWorkspaceFolder(data.getFolderName(), data.getFileToUploadPath(), data.getTestFileName());
    }

    @Test(description = "Publish new file from Workspace")
    public void publishFile() {

    }
}


/*
0. Delete file from PS
1. Upload file in WS if not present
2. Publish file
3. Check PS if file is present
 */