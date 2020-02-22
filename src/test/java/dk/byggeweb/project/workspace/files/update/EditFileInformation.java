package dk.byggeweb.project.workspace.files.update;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import dk.byggeweb.objects.project.workspace.panels.WSFileInformationPanel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class EditFileInformation extends ProjectTestBase {

    // https://itwofm.atlassian.net/browse/TSB-22

    private String subjectMetadata;
    private String revisionMetadata;
    private String revisionDateMetadata;

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToWorkspaceModule();
        wsFolderSteps.navigateToFolder(data.getFolderName());
        uploadFileIfNotPresentInWorkspaceFolder(data.getFileToUploadPath(), data.getTestFileName());

        subjectMetadata = data.getSubject() + LocalDate.now() + " " + System.currentTimeMillis();
        revisionMetadata = data.getRevision() + System.currentTimeMillis();
        revisionDateMetadata = String.valueOf(System.currentTimeMillis());
    }

    @Test(priority = 1, description = "Edit Subject metadata for existing file in File information tab")
    public void editSubjectMetadata() {
        wsFileSteps.selectFile(data.getTestFileName());
        wsFileInformationSteps.editMetadataTextField(
                data.getTestFileName(),
                new WSFileInformationPanel(data.getTestFileName()).getMetadataRefField(),
                subjectMetadata);
        wsFileSteps.verifyDataIsPresentInTable(subjectMetadata);
    }

    @Test(priority = 2, description = "Edit Revision metadata for existing file in File information tab")
    public void editRevisionMetadata() {
        wsFileSteps.selectFile(data.getTestFileName());
        wsFileInformationSteps.editMetadataTextField(
                data.getTestFileName(),
                new WSFileInformationPanel(data.getTestFileName()).getMetadataRevisionField(),
                revisionMetadata);
        wsFileSteps.verifyDataIsPresentInTable(revisionMetadata);
    }

    @Test(priority = 3, description = "Edit Revision Date metadata for existing file in File information tab")
    public void editRevisionDateMetadata() {
        wsFileSteps.selectFile(data.getTestFileName());
        wsFileInformationSteps.editMetadataTextField(
                data.getTestFileName(),
                new WSFileInformationPanel(data.getTestFileName()).getMetadataRevDateField(),
                revisionDateMetadata);
        wsFileSteps.verifyDataIsPresentInTable(revisionDateMetadata);
    }

}