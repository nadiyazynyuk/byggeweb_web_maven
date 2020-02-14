package dk.byggeweb.infrastructure.test;

import dk.byggeweb.infrastructure.test.testdata.model.ProjectTestDataModel;
import dk.byggeweb.objects.project.ProjectHomePage;
import dk.byggeweb.steps.GeneralSteps;
import dk.byggeweb.steps.project.workspace.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public abstract class ProjectTestBase extends TestBase {

    public ProjectTestDataModel data;
    public ProjectHomePage projectHomePage;

    public FolderSteps folderSteps = new FolderSteps();
    public FileSteps fileSteps = new FileSteps();
    public RecycleBinSteps recycleBinSteps = new RecycleBinSteps();
    public MonitoredFilesSteps monitoredFilesSteps = new MonitoredFilesSteps();
    public FileInformationSteps fileInformationSteps = new FileInformationSteps();

    @Parameters("testData")
    @BeforeClass
    public void launchProject(String testData) {
        data = getXmlObject(testData, ProjectTestDataModel.class);
        GeneralSteps.loginAsVerifiedUser(data.getUserName(), data.getPassword(), data.getName());
        GeneralSteps.launchProject(data.getProjectLink());
        projectHomePage = new ProjectHomePage(data.getProjectName());
    }

    public void uploadFileIfNotPresentInWorkspaceFolder(String folderName, String filePath, String fileName) {
        folderSteps.navigateToFolder(folderName);
        try {
            fileSteps.verifyFileIsPresent(fileName);
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            fileSteps.enhancedUploadSingleFile(getAbsolutePath(filePath));
            fileSteps.closeEditFileInformationPopup();
            fileSteps.verifyFileIsPresent(fileName);
        }
    }

    public void deleteFileIfPresentInWorkspaceFolder(String folderName, String fileName) {
        folderSteps.navigateToFolder(folderName);
        while (true) {
            try {
                fileSteps.deleteFilePermanently(fileName);
            } catch (com.codeborne.selenide.ex.ElementNotFound e) {
                break;
            }
        }
    }

}
