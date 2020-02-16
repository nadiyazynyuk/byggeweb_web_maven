package dk.byggeweb.steps.project.publicationspace;

import dk.byggeweb.objects.project.publicationspace.panels.PSFileInformationPanel;
import dk.byggeweb.objects.project.publicationspace.panels.PSFolderContentPanel;
import io.qameta.allure.Step;

public class PSFileSteps {

    @Step("Select file")
    public void selectFile(String fileName) {
//        PSFolderContentPanel psFolderContentPanel = new PSFolderContentPanel();
        new PSFolderContentPanel().getFileByName(fileName).click();
        new PSFileInformationPanel(fileName);
    }

    @Step("Delete file")
    public void deleteFile(String fileName) {
        selectFile(fileName);

    }
}
