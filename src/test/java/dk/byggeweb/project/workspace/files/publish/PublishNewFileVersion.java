package dk.byggeweb.project.workspace.files.publish;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PublishNewFileVersion extends ProjectTestBase {

    // https://itwofm.atlassian.net/browse/TSB-33

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToPublicationSpace();
        deleteFileIfPresentInDocumentListFolder(data.getDocumentListName(), data.getDocumentListFolderName(), data.getTestFileName());

        projectHomePage.navigateToWorkspaceModule();
        deleteFileIfPresentInWorkspaceFolder(data.getFolderName(), data.getTestFileName());
    }

    @Test(description = "Upload first file version into Project root folder")
    public void uploadFirstFileVersion() {
        wsFileSteps.enhancedUploadSingleFile(data.getFileV1ToUploadPath());
        wsFileSteps.closeEditFileInformationPopup();
        wsFileSteps.verifyFileIsPresent(data.getTestFileName());
    }

    @Test(dependsOnMethods = "uploadFirstFileVersion", description = "Publish new file from Workspace")
    public void publishFirstFileVersion() {
        wsFileSteps.publishNewFile(data.getTestFileName(), data.getDocumentListFolderName());
        projectHomePage.navigateToPublicationSpace();
        psFileSteps.verifyFileIsPresent(data.getTestFileName());
    }

    @Test(dependsOnMethods = "publishFirstFileVersion", description = "Upload second file version into Project root folder")
    public void uploadSecondFileVersion() {
        projectHomePage.navigateToWorkspaceModule();
        wsFolderSteps.navigateToFolder(data.getFolderName());
        wsFileSteps.enhancedUploadSingleFile(data.getFileV2ToUploadPath());
        wsFileSteps.closeEditFileInformationPopup();
        wsFileSteps.verifyFileIsPresent(data.getTestFileName());
    }

    @Test(dependsOnMethods = "uploadSecondFileVersion", description = "Publish new file version from Workspace")
    public void publishSecondFileVersion() {
        wsFileSteps.publishNewFileVersion(data.getTestFileName());
        projectHomePage.navigateToPublicationSpace();
        psFileSteps.verifyFileIsPresent(data.getTestFileName());
    }

    @Test(dependsOnMethods = "publishSecondFileVersion", description = "Check file content of published files")
    public void checkLatestFileVersionContent() {
        psFileSteps.selectFile(data.getTestFileName());
        psFileInformationSteps.openFile(data.getTestFileName(), data.getFileV2Content());
    }

    @Test(dependsOnMethods = "checkLatestFileVersionContent", description = "Check file content of published files")
    public void checkFirstFileVersionContent() {
        psFileSteps.selectFile(data.getTestFileName());
        psFileInformationSteps.selectFileVersion(data.getTestFileName(), data.getFileV1VersionIndex());
        psFileInformationSteps.openPreviousFileVersion(data.getTestFileName(), data.getFileV1Content());
    }
}