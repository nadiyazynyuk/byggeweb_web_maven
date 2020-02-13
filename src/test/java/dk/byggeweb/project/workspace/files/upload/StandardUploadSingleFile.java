package dk.byggeweb.project.workspace.files.upload;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StandardUploadSingleFile extends ProjectTestBase {

    // https://itwofm.atlassian.net/browse/TSB-15

    @BeforeClass
    public void deleteFileIfExists() {
        projectHomePage.navigateToWorkspaceModule();
        folderSteps.navigateToFolder(data.getFolderName());

        while (true) {
            try {
                fileSteps.deleteFilePermanently(data.getTestFileName());
            } catch (com.codeborne.selenide.ex.ElementNotFound e) {
                break;
            }
        }
    }

    @Test(description = "Standard upload file into Project root folder")
    public void uploadFile() {
        fileSteps.standardUploadSingleFile(getAbsolutePath(data.getFileToUploadPath()));
        fileSteps.closeEditFileInformationPopup();
        fileSteps.verifyFileIsPresent(data.getTestFileName());
    }
}
