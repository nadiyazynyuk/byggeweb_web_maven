package dk.byggeweb.project.workspace.files.publish;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PublishNewFileVersion extends ProjectTestBase {

    // https://itwofm.atlassian.net/browse/TSB-33

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToPublicationSpace();
        psFolderSteps.navigateToFolderInDocumentList(data.getDocumentListName(), data.getDocumentListFolderName());
        deleteFileIfPresentInDocumentListFolder(data.getTestFileName());

        projectHomePage.navigateToWorkspaceModule();
        wsFolderSteps.navigateToFolder(data.getFolderName());
        deleteFileIfPresentInWorkspaceFolder(data.getTestFileName());
    }

    @Test(description = "Upload first file version into Project root folder")
    public void uploadFirstFileVersion() {
        wsFileSteps.enhancedUploadSingleFile(getAbsolutePath(data.getFileV1ToUploadPath()));
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

    @Test(dependsOnMethods = "publishSecondFileVersion", description = "Check file content of new version of published file")
    public void checkLatestFileVersionContent() {
        psFileSteps.selectFile(data.getTestFileName());
        psFileInformationSteps.openFile(data.getTestFileName(), data.getFileV2Content());
    }

    @Test(dependsOnMethods = "checkLatestFileVersionContent", description = "Check file content of first version published file")
    public void checkFirstFileVersionContent() {
        psFileSteps.selectFile(data.getTestFileName());
        psFileInformationSteps.selectFileVersion(data.getTestFileName(), data.getFileV1VersionIndex());
        psFileInformationSteps.openPreviousFileVersion(data.getTestFileName(), data.getFileV1Content());
    }
}