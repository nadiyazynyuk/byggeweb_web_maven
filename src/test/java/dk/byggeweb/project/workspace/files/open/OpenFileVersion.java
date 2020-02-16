package dk.byggeweb.project.workspace.files.open;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OpenFileVersion extends ProjectTestBase {

    // https://itwofm.atlassian.net/browse/TSB-21

    @BeforeClass
    public void deleteFileIfExists() {
        projectHomePage.navigateToWorkspaceModule();
        wsFolderSteps.navigateToFolder(data.getFolderName());

        while (true) {
            try {
                wsFileSteps.deleteFilePermanently(data.getTestFileName());
            } catch (com.codeborne.selenide.ex.ElementNotFound e) {
                break;
            }
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
