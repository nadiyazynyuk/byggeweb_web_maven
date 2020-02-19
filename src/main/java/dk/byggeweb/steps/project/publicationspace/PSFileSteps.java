package dk.byggeweb.steps.project.publicationspace;

import com.codeborne.selenide.WebDriverRunner;
import dk.byggeweb.objects.project.common.modals.FileEnhancedUploadTab;
import dk.byggeweb.objects.project.common.modals.FileUploadPopup;
import dk.byggeweb.objects.project.publicationspace.modals.PSFileDeletePopup;
import dk.byggeweb.objects.project.publicationspace.modals.PSFileInformationEditPopup;
import dk.byggeweb.objects.project.publicationspace.modals.PSFilePublishPopup;
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

    @Step("Publish file from Local machine")
    public void publishFileFromLocalMachine(String filePath, String fileName) {
        PSFolderContentPanel psFolderContentPanel = new PSFolderContentPanel();
        psFolderContentPanel.getFilePublishButton().click();
        String winHandleBefore = WebDriverRunner.getWebDriver().getWindowHandle();
        psFolderContentPanel.switchToNewWindow();
        PSFilePublishPopup psFilePublishPopup = new PSFilePublishPopup();
        psFilePublishPopup.getLocalMachineItem().click();
        FileUploadPopup fileUploadPopup = new FileUploadPopup();
        fileUploadPopup.switchToEnhancedUploadTab();
        FileEnhancedUploadTab fileEnhancedUploadTab = new FileEnhancedUploadTab();
        fileEnhancedUploadTab.dropFile(filePath);

        PSFileInformationEditPopup psFileInformationEditPopup = new PSFileInformationEditPopup(fileName);
        psFileInformationEditPopup.getOkButton().click();
        psFileInformationEditPopup.getCloseButton().click();

        WebDriverRunner.getWebDriver().switchTo().window(winHandleBefore);
    }

//    @Step("Close edit file information popup")
//    public void closeEditFileInformationPopup() {
//        PSFileInformationEditPopup psFileInformationEditPopup = new PSFileInformationEditPopup();
//        psFileInformationEditPopup.getOkButton().click();
//        psFileInformationEditPopup.getCloseButton().click();
//    }

    @Step("Verify file is present in the list")
    public void verifyFileIsPresent(String name) {
        PSFolderContentPanel psFolderContentPanel = new PSFolderContentPanel();
        psFolderContentPanel.getFileByName(name).shouldHave(text(name));
    }
}
