package dk.byggeweb.infrastructure.test;

import dk.byggeweb.infrastructure.test.testdata.model.ProjectTestDataModel;
import dk.byggeweb.objects.pages.project.ProjectHomePage;
import dk.byggeweb.objects.pages.project.workspace.modals.FileInformationEditPopup;
import dk.byggeweb.objects.pages.project.workspace.panels.WorkspaceContentPanel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public abstract class ProjectTestBase extends TestBase {

    public ProjectTestDataModel data;
    public ProjectHomePage projectHomePage;
    public WorkspaceContentPanel workspaceContentPanel;

    @Parameters("testData")
    @BeforeClass
    public void setUp(String testData) {
        data = getXmlObject(testData, ProjectTestDataModel.class);
    }

    public void uploadFileIfNotPresentInWorkspaceFolder(String folderName, String filePath, String fileName) {
        projectHomePage.getWorkspaceNodesPanel().clickOnFolder(folderName);
        workspaceContentPanel = new WorkspaceContentPanel(folderName);
        try {
            workspaceContentPanel.verifyFileIsPresent(fileName);
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            workspaceContentPanel.enhancedUploadSingleFile(getAbsolutePath(filePath));
            FileInformationEditPopup fileInformationEditPopup = new FileInformationEditPopup();
            fileInformationEditPopup.closeEditFileInformation();
            workspaceContentPanel.verifyFileIsPresent(fileName);
        }
    }

    public void deleteFileIfPresentInWorkspaceFolder(String folderName, String fileName) {
        projectHomePage.getWorkspaceNodesPanel().clickOnFolder(folderName);
        workspaceContentPanel = new WorkspaceContentPanel(folderName);
        while (true) {
            try {
                workspaceContentPanel.deleteFile(fileName);
            } catch (com.codeborne.selenide.ex.ElementNotFound e) {
                break;
            }
        }
    }

}
