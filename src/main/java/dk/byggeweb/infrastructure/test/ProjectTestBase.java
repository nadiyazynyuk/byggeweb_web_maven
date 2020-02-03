package dk.byggeweb.infrastructure.test;

import dk.byggeweb.infrastructure.steps.GeneralSteps;
import dk.byggeweb.infrastructure.test.testdata.model.ProjectTestDataModel;
import dk.byggeweb.objects.project.ProjectHomePage;
import dk.byggeweb.objects.project.workspace.modals.FileInformationEditPopup;
import dk.byggeweb.objects.project.workspace.panels.FolderContentPanel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public abstract class ProjectTestBase extends TestBase {

    public ProjectTestDataModel data;
    public ProjectHomePage projectHomePage;
    public FolderContentPanel folderContentPanel;

    @Parameters("testData")
    @BeforeClass
    public void launchProject(String testData) {
        data = getXmlObject(testData, ProjectTestDataModel.class);

        GeneralSteps.loginAsVerifiedUser(data.getUserName(), data.getPassword(), data.getName());
        GeneralSteps.launchProject(data.getProjectLink());
        projectHomePage = new ProjectHomePage(data.getProjectName());
    }

    public void uploadFileIfNotPresentInWorkspaceFolder(String folderName, String filePath, String fileName) {
        projectHomePage.getWorkspaceNodesPanel().navigateToFolder(folderName);
        folderContentPanel = new FolderContentPanel(folderName);
        try {
            folderContentPanel.verifyFileIsPresent(fileName);
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            folderContentPanel.enhancedUploadSingleFile(getAbsolutePath(filePath));
            FileInformationEditPopup fileInformationEditPopup = new FileInformationEditPopup();
            fileInformationEditPopup.closeEditFileInformation();
            folderContentPanel.verifyFileIsPresent(fileName);
        }
    }

    public void deleteFileIfPresentInWorkspaceFolder(String folderName, String fileName) {
        projectHomePage.getWorkspaceNodesPanel().navigateToFolder(folderName);
        folderContentPanel = new FolderContentPanel(folderName);
        while (true) {
            try {
                folderContentPanel.deleteFile(fileName);
            } catch (com.codeborne.selenide.ex.ElementNotFound e) {
                break;
            }
        }
    }

}
