package dk.byggeweb.project.publicationspace.nonapproval.files.update;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import dk.byggeweb.objects.project.publicationspace.panels.PSFileInformationPanel;
import io.qameta.allure.Link;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class EditFileInformation extends ProjectTestBase {

    private String subjectMetadata;
    private String revisionDateMetadata;

    @Link(url = "https://itwofm.atlassian.net/browse/TSB-56")

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToPublicationSpace();
        psFolderSteps.navigateToFolderInDocumentList(data.getDocumentListName(), data.getDocumentListFolderName());
        uploadFileIfNotPresentInDocumentListFolder(data.getFileToUploadPath(), data.getTestFileName());

        subjectMetadata = data.getSubject() + LocalDate.now() + " " + System.currentTimeMillis();
        revisionDateMetadata = String.valueOf(System.currentTimeMillis());
    }

    @Test(priority = 1, description = "Edit Subject metadata for existing file in File information tab")
    public void editSubjectMetadata() {
        psFileSteps.selectFile(data.getTestFileName());
        psFileInformationSteps.editMetadataTextField(
                data.getTestFileName(),
                new PSFileInformationPanel(data.getTestFileName()).getMetadataRefField(),
                subjectMetadata);
        psFileSteps.verifyDataIsPresentInTable(subjectMetadata);
    }

    @Test(priority = 2, description = "Edit Revision Date metadata for existing file in File information tab")
    public void editRevisionDateMetadata() {
        psFileSteps.selectFile(data.getTestFileName());
        psFileInformationSteps.editMetadataTextField(
                data.getTestFileName(),
                new PSFileInformationPanel(data.getTestFileName()).getMetadataRevDateField(),
                revisionDateMetadata);
        psFileSteps.verifyDataIsPresentInTable(revisionDateMetadata);
    }

}
