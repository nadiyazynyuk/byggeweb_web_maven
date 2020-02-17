package dk.byggeweb.steps.project.publicationspace;

import dk.byggeweb.objects.project.publicationspace.modals.PSFileDeletePopup;
import dk.byggeweb.objects.project.publicationspace.panels.PSFileInformationPanel;
import dk.byggeweb.objects.project.publicationspace.panels.PSFolderContentPanel;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;

public class PSFileSteps {

    @Step("Select file")
    public void selectFile(String fileName) {
        new PSFolderContentPanel().getFileByName(fileName).click();
        new PSFileInformationPanel(fileName);
    }

    @Step("Delete file")
    public void deleteFile(String fileName) {
        selectFile(fileName);
        PSFolderContentPanel psFolderContentPanel = new PSFolderContentPanel();
        psFolderContentPanel.getFileDeleteButton().click();
        psFolderContentPanel.switchToNewWindow();
        PSFileDeletePopup fileDeletePopup = new PSFileDeletePopup();
        fileDeletePopup.deleteFilePermanently();
        psFolderContentPanel.switchToLastTab();
    }

    @Step("Verify file is present in the list")
    public void verifyFileIsPresent(String name) {
        PSFolderContentPanel psFolderContentPanel = new PSFolderContentPanel();
        psFolderContentPanel.getFileByName(name).shouldHave(text(name));
    }
}
