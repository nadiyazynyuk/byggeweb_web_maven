package dk.byggeweb.project.publicationspace.nonapproval.files.publish;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import io.qameta.allure.Link;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PublishNewFileVersionFromLocalMachine extends ProjectTestBase {

    @Link(url = "https://itwofm.atlassian.net/browse/TSB-38")

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToPublicationSpace();
        psFolderSteps.navigateToFolderInDocumentList(data.getDocumentListName(), data.getDocumentListFolderName());
        deleteFileIfPresentInDocumentListFolder(data.getTestFileName());
    }

    @Test(description = "Publish new file from Local machine into Document list folder")
    public void publishNewFileFromLocalMachine() {
        psFileSteps.publishFileFromLocalMachine(data.getFileV1ToUploadPath(), data.getTestFileName());
        psFileSteps.verifyFileIsPresent(data.getTestFileName());
    }

    @Test(dependsOnMethods = "publishNewFileFromLocalMachine", description = "Publish new file version from Local machine into Document list folder")
    public void publishSecondFileVersionFromLocalMachine() {
        psFileSteps.publishFileFromLocalMachine(data.getFileV2ToUploadPath(), data.getTestFileName());
        psFileSteps.verifyFileIsPresent(data.getTestFileName());
    }

    @Test(dependsOnMethods = "publishSecondFileVersionFromLocalMachine", description = "Check file content of new version of published file")
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
