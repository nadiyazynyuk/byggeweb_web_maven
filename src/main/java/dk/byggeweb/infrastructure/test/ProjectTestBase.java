package dk.byggeweb.infrastructure.test;

import dk.byggeweb.infrastructure.test.testdata.model.ProjectTestDataModel;
import dk.byggeweb.objects.project.ProjectHomePage;
import dk.byggeweb.steps.GeneralSteps;
import dk.byggeweb.steps.project.common.SearchSteps;
import dk.byggeweb.steps.project.distributionspace.DSFileSteps;
import dk.byggeweb.steps.project.distributionspace.DSFolderSteps;
import dk.byggeweb.steps.project.distributionspace.DSMonitorFilesSteps;
import dk.byggeweb.steps.project.distributionspace.DSMonitorFoldersSteps;
import dk.byggeweb.steps.project.publicationspace.*;
import dk.byggeweb.steps.project.versionsets.VersionSetsSteps;
import dk.byggeweb.steps.project.workspace.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public abstract class ProjectTestBase extends TestBase {

    public ProjectTestDataModel data;
    public ProjectHomePage projectHomePage;

    public WSFolderSteps wsFolderSteps = new WSFolderSteps();
    public WSFileSteps wsFileSteps = new WSFileSteps();
    public WSRecycleBinSteps wsRecycleBinSteps = new WSRecycleBinSteps();
    public WSMonitorFilesSteps wsMonitorFilesSteps = new WSMonitorFilesSteps();
    public WSMonitorFoldersSteps wsMonitorFoldersSteps = new WSMonitorFoldersSteps();
    public WSFileInformationSteps wsFileInformationSteps = new WSFileInformationSteps();

    public PSFolderSteps psFolderSteps = new PSFolderSteps();
    public PSFileSteps psFileSteps = new PSFileSteps();
    public PSFileInformationSteps psFileInformationSteps = new PSFileInformationSteps();
    public PSMonitorFilesSteps psMonitorFilesSteps = new PSMonitorFilesSteps();
    public PSMonitorFoldersSteps psMonitorFoldersSteps = new PSMonitorFoldersSteps();

    public DSFolderSteps dsFolderSteps = new DSFolderSteps();
    public DSFileSteps dsFileSteps = new DSFileSteps();
    public DSMonitorFilesSteps dsMonitorFilesSteps = new DSMonitorFilesSteps();
    public DSMonitorFoldersSteps dsMonitorFoldersSteps = new DSMonitorFoldersSteps();

    public SearchSteps searchSteps = new SearchSteps();
    public VersionSetsSteps versionSetsSteps = new VersionSetsSteps();

    @Parameters("testData")
    @BeforeClass
    public void launchProject(String testData) {
        data = getXmlObject(getEnvironment() + testData, ProjectTestDataModel.class);
        GeneralSteps.loginAsVerifiedUser(data.getUserName(), data.getPassword(), data.getName());
        GeneralSteps.launchProject(data.getProjectLink());
        projectHomePage = new ProjectHomePage(data.getProjectName());
    }

    public void uploadFileIfNotPresentInWorkspaceFolder(String filePath, String fileName) {
        try {
            wsFileSteps.verifyFileIsPresent(fileName);
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            wsFileSteps.standardUploadSingleFile(getAbsolutePath(filePath));
            wsFileSteps.closeEditFileInformationPopup();
            wsFileSteps.verifyFileIsPresent(fileName);
        }
    }

    public void deleteFileIfPresentInWorkspaceFolder(String fileName) {
        while (true) {
            try {
                wsFileSteps.deleteFilePermanently(fileName);
            } catch (com.codeborne.selenide.ex.ElementNotFound e) {
                break;
            }
        }
    }

    public void uploadFileIfNotPresentInDocumentListFolder(String filePath, String fileName) {
        try {
            psFileSteps.verifyFileIsPresent(fileName);
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            psFileSteps.publishFileFromLocalMachine(filePath, fileName);
            psFileSteps.verifyFileIsPresent(fileName);
        }
    }

    public void uploadFileIfNotPresentInDocumentListWithApprovalFolder(String filePath, String fileName) {
        try {
            psFileSteps.verifyFileIsPresent(fileName);
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            psFileSteps.publishFileFromLocalMachine(filePath, fileName);
            projectHomePage.getPublicationSpaceNodesPanel().navigateToWaitingForApproval();
            psFileSteps.approveFile(data.getTestFileName());
            psFolderSteps.navigateToDocumentList(data.getDocumentListName());
            psFolderSteps.navigateToFolderInsideDocumentList(data.getDocumentListFolderName());
            psFileSteps.verifyFileIsPresent(data.getTestFileName());
        }
    }

    public void deleteFileIfPresentInDocumentListFolder(String fileName) {
        while (true) {
            try {
                psFileSteps.deleteFile(fileName);
            } catch (com.codeborne.selenide.ex.ElementNotFound e) {
                break;
            }
        }
    }

    public void deleteDiscontinuedFileIfPresentInDocumentListFolder(String fileName) {
        while (true) {
            try {
                psFileSteps.deleteDiscontinuedFile(fileName);
            } catch (com.codeborne.selenide.ex.ElementNotFound e) {
                break;
            }
        }
    }

}
