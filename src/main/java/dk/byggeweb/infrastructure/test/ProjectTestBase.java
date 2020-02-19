package dk.byggeweb.infrastructure.test;

import dk.byggeweb.infrastructure.test.testdata.model.ProjectTestDataModel;
import dk.byggeweb.objects.project.ProjectHomePage;
import dk.byggeweb.steps.GeneralSteps;
import dk.byggeweb.steps.project.publicationspace.PSFileInformationSteps;
import dk.byggeweb.steps.project.publicationspace.PSFileSteps;
import dk.byggeweb.steps.project.publicationspace.PSFolderSteps;
import dk.byggeweb.steps.project.workspace.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public abstract class ProjectTestBase extends TestBase {

    public ProjectTestDataModel data;
    public ProjectHomePage projectHomePage;

    public WSFolderSteps wsFolderSteps = new WSFolderSteps();
    public WSFileSteps wsFileSteps = new WSFileSteps();
    public WSRecycleBinSteps wsRecycleBinSteps = new WSRecycleBinSteps();
    public WSMonitoredFilesSteps wsMonitoredFilesSteps = new WSMonitoredFilesSteps();
    public WSFileInformationSteps wsFileInformationSteps = new WSFileInformationSteps();

    public PSFolderSteps psFolderSteps = new PSFolderSteps();
    public PSFileSteps psFileSteps = new PSFileSteps();
    public PSFileInformationSteps psFileInformationSteps = new PSFileInformationSteps();

    @Parameters("testData")
    @BeforeClass
    public void launchProject(String testData) {
        data = getXmlObject(testData, ProjectTestDataModel.class);
        GeneralSteps.loginAsVerifiedUser(data.getUserName(), data.getPassword(), data.getName());
        GeneralSteps.launchProject(data.getProjectLink());
        projectHomePage = new ProjectHomePage(data.getProjectName());
    }

    public void uploadFileIfNotPresentInWorkspaceFolder(String folderName, String filePath, String fileName) {
        wsFolderSteps.navigateToFolder(folderName);
        try {
            wsFileSteps.verifyFileIsPresent(fileName);
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            wsFileSteps.enhancedUploadSingleFile(getAbsolutePath(filePath));
            wsFileSteps.closeEditFileInformationPopup();
            wsFileSteps.verifyFileIsPresent(fileName);
        }
    }

    public void deleteFileIfPresentInWorkspaceFolder(String folderName, String fileName) {
        wsFolderSteps.navigateToFolder(folderName);
        while (true) {
            try {
                wsFileSteps.deleteFilePermanently(fileName);
            } catch (com.codeborne.selenide.ex.ElementNotFound e) {
                break;
            }
        }
    }

    public void uploadFileIfMNotPresentInDocumentListFolder(String documentListName, String folderName, String filePath, String fileName) {
        psFolderSteps.navigateToFolderInDocumentList(documentListName, folderName);
    }

    public void deleteFileIfPresentInDocumentListFolder(String documentListName, String folderName, String fileName) {
        psFolderSteps.navigateToFolderInDocumentList(documentListName, folderName);
        while (true) {
            try {
                 psFileSteps.deleteFile(fileName);
            } catch (com.codeborne.selenide.ex.ElementNotFound e) {
                break;
            }
        }
    }

}
