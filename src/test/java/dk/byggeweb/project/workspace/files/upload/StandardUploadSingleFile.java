package dk.byggeweb.project.workspace.files.upload;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import io.qameta.allure.Link;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StandardUploadSingleFile extends ProjectTestBase {

    @Link(url = "https://itwofm.atlassian.net/browse/TSB-15")

    @BeforeClass
    public void deleteFileIfExists() {
        projectHomePage.navigateToWorkspaceModule();
        wsFolderSteps.navigateToFolder(data.getFolderName());

        try {
            wsFileSteps.deleteFilePermanently(data.getTestFileName());
        } catch (com.codeborne.selenide.ex.ElementNotFound ignored) {
        }
    }

    @Test(description = "Standard upload file into Project root folder")
    public void uploadFile() {
        wsFileSteps.standardUploadSingleFile(getAbsolutePath(data.getFileToUploadPath()));
        wsFileSteps.closeEditFileInformationPopup();
        wsFileSteps.verifyFileIsPresent(data.getTestFileName());
    }
}
