package dk.byggeweb.project.workspace.files.open;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import io.qameta.allure.Link;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OpenFileVersion extends ProjectTestBase {

    @Link(url = "https://itwofm.atlassian.net/browse/TSB-21")

    @BeforeClass
    public void deleteFileIfExists() {
        projectHomePage.navigateToWorkspaceModule();
        wsFolderSteps.navigateToFolder(data.getFolderName());

        try {
            wsFileSteps.deleteFilePermanently(data.getTestFileName());
        } catch (com.codeborne.selenide.ex.ElementNotFound ignored) {
        }
    }

    @Test(description = "Upload first file version into Project root folder")
    public void uploadFirstFileVersion() {
        wsFileSteps.enhancedUploadSingleFile(data.getFileV1ToUploadPath());
        wsFileSteps.closeEditFileInformationPopup();
        wsFileSteps.verifyFileIsPresent(data.getTestFileName());
    }

    @Test(dependsOnMethods = "uploadFirstFileVersion", description = "Upload second file version into Project root folder")
    public void uploadSecondFileVersion() {
        wsFileSteps.enhancedUploadSingleFile(data.getFileV2ToUploadPath());
        wsFileSteps.closeEditFileInformationPopup();
        wsFileSteps.verifyFileIsPresent(data.getTestFileName());
    }

    @Test(dependsOnMethods = "uploadSecondFileVersion", description = "Open latest file version")
    public void openLatestFileVersion() {
        wsFileSteps.selectFile(data.getTestFileName());
        wsFileInformationSteps.openFile(data.getTestFileName(), data.getFileV2Content());
    }

    @Test(dependsOnMethods = "openLatestFileVersion", description = "Open first file version")
    public void openFirstFileVersion() {
        wsFileSteps.selectFile(data.getTestFileName());
        wsFileInformationSteps.selectFileVersion(data.getTestFileName(), data.getFileV1VersionIndex());
        wsFileInformationSteps.openPreviousFileVersion(data.getTestFileName(), data.getFileV1Content());
    }
}
