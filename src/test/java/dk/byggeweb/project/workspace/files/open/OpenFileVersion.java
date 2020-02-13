package dk.byggeweb.project.workspace.files.open;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OpenFileVersion extends ProjectTestBase {

    // https://itwofm.atlassian.net/browse/TSB-21

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

    @Test(description = "Upload first file version into Project root folder")
    public void uploadFirstFileVersion() {
        fileSteps.enhancedUploadSingleFile(data.getFileV1ToUploadPath());
        fileSteps.closeEditFileInformationPopup();
        fileSteps.verifyFileIsPresent(data.getTestFileName());
    }

    @Test(dependsOnMethods = "uploadFirstFileVersion", description = "Upload second file version into Project root folder")
    public void uploadSecondFileVersion() {
        fileSteps.enhancedUploadSingleFile(data.getFileV2ToUploadPath());
        fileSteps.closeEditFileInformationPopup();
        fileSteps.verifyFileIsPresent(data.getTestFileName());
    }

    @Test(dependsOnMethods = "uploadSecondFileVersion", description = "Open latest file version")
    public void openLatestFileVersion() {
        fileSteps.selectFile(data.getTestFileName());
        fileInformationSteps.openFile(data.getTestFileName(), data.getFileV2Content());
    }

    @Test(dependsOnMethods = "openLatestFileVersion", description = "Open first file version")
    public void openFirstFileVersion() {
        fileSteps.selectFile(data.getTestFileName());
        fileInformationSteps.selectFileVersion(data.getTestFileName(), data.getFileV1VersionIndex());
        fileInformationSteps.openPreviousFileVersion(data.getTestFileName(), data.getFileV1Content());
    }
}
