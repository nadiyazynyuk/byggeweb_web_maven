package dk.byggeweb.project.workspace.files.update;

import dk.byggeweb.infrastructure.steps.GeneralSteps;
import dk.byggeweb.infrastructure.test.ProjectTestBase;
import dk.byggeweb.objects.project.ProjectHomePage;
import dk.byggeweb.objects.project.workspace.panels.FileInformationPanel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class EditFileInformation extends ProjectTestBase {

    // https://itwofm.atlassian.net/browse/TSB-22

    @BeforeClass
    public void prepareData() {
        projectHomePage = new ProjectHomePage(data.getProjectName());
        projectHomePage.navigateToWorkspaceModule();
        uploadFileIfNotPresentInWorkspaceFolder(data.getFolderName(), data.getFileToUploadPath(), data.getTestFileName());
    }

    @Test(priority = 1, description = "Edit Subject metadata for existing file in File information tab")
    public void editSubjectMetadata() {
        String subjectMetadata = data.getSubject() + LocalDate.now() + " " + System.currentTimeMillis();
        workspaceContentPanel.clickOnFile(data.getTestFileName());
        FileInformationPanel fileInformationPanel = new FileInformationPanel(data.getTestFileName());
        fileInformationPanel.editMetadataTextField(fileInformationPanel.getMetadataSubjectField(), subjectMetadata);
        workspaceContentPanel.verifyDataIsPresentInTable(subjectMetadata);
    }

    @Test(priority = 2, description = "Edit Revision metadata for existing file in File information tab")
    public void editRevisionMetadata() {
        String revisionMetadata = data.getRevision() + System.currentTimeMillis();
        workspaceContentPanel.clickOnFile(data.getTestFileName());
        FileInformationPanel fileInformationPanel = new FileInformationPanel(data.getTestFileName());
        fileInformationPanel.editMetadataTextField(fileInformationPanel.getMetadataRevisionField(), revisionMetadata);
        workspaceContentPanel.verifyDataIsPresentInTable(revisionMetadata);
    }

    @Test(priority = 3, description = "Edit Revision Date metadata for existing file in File information tab")
    public void editRevisionDateMetadata() {
        String revisionDateMetadata = String.valueOf(System.currentTimeMillis());
        workspaceContentPanel.clickOnFile(data.getTestFileName());
        FileInformationPanel fileInformationPanel = new FileInformationPanel(data.getTestFileName());
        fileInformationPanel.editMetadataTextField(fileInformationPanel.getMetadataRevDateField(), revisionDateMetadata);
        workspaceContentPanel.verifyDataIsPresentInTable(revisionDateMetadata);
    }

}