package dk.byggeweb.steps.project.publicationspace;

import com.codeborne.selenide.WebDriverRunner;
import dk.byggeweb.objects.project.common.modals.FileDownloadPopup;
import dk.byggeweb.objects.project.common.modals.FileEnhancedUploadTab;
import dk.byggeweb.objects.project.common.modals.FileUploadPopup;
import dk.byggeweb.objects.project.publicationspace.modals.PSFileDeletePopup;
import dk.byggeweb.objects.project.publicationspace.modals.PSFileInformationEditPopup;
import dk.byggeweb.objects.project.publicationspace.modals.PSFilePublishPopup;
import dk.byggeweb.objects.project.publicationspace.panels.PSFileInformationPanel;
import dk.byggeweb.objects.project.publicationspace.panels.PSFolderContentPanel;
import dk.byggeweb.steps.GeneralSteps;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

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

    @Step("Select discontinued file")
    public void selectDiscontinuedFile(String fileName) {
        new PSFolderContentPanel().getDiscontinuedFileByName(fileName).click();
        new PSFileInformationPanel(fileName);
    }

    @Step("Discontinue file")
    public void discontinueFile(String fileName) {
        selectFile(fileName);
        PSFolderContentPanel psFolderContentPanel = new PSFolderContentPanel();
        psFolderContentPanel.getFileDeleteButton().click();
        psFolderContentPanel.switchToNewWindow();
        PSFileDeletePopup fileDeletePopup = new PSFileDeletePopup();
        fileDeletePopup.discontinueFile();
        psFolderContentPanel.switchToLastTab();
    }

    @Step("Delete discontinued file")
    public void deleteDiscontinuedFile(String fileName) {
        selectDiscontinuedFile(fileName);
        PSFolderContentPanel psFolderContentPanel = new PSFolderContentPanel();
        psFolderContentPanel.getFileDeleteButton().click();
        psFolderContentPanel.switchToNewWindow();
        PSFileDeletePopup fileDeletePopup = new PSFileDeletePopup();
        fileDeletePopup.deleteFilePermanently();
        psFolderContentPanel.switchToLastTab();
    }

    @Step("Download file")
    public void downloadFile(String fileName) {
        selectFile(fileName);
        new PSFolderContentPanel().getFileDownloadButton().click();
    }


    @Step("Download all files from the folder")
    public void generateDownloadFilesLink(String fileName) {
        selectFile(fileName);
        PSFolderContentPanel psFolderContentPanel = new PSFolderContentPanel();
        GeneralSteps.selectAll();
        psFolderContentPanel.getFileDownloadButton().click();
        psFolderContentPanel.switchToNewWindow();
        FileDownloadPopup fileDownloadPopup = new FileDownloadPopup();
        fileDownloadPopup.getOkButton().click();
        fileDownloadPopup.getDownloadLink().shouldBe(visible);
        fileDownloadPopup.getCancelButton().click();
        psFolderContentPanel.switchToLastTab();
    }

    @Step("Verify file is present in the list")
    public void verifyFileIsPresent(String name) {
        PSFolderContentPanel psFolderContentPanel = new PSFolderContentPanel();
        psFolderContentPanel.getFileByName(name).shouldHave(text(name));
    }

    @Step("Verify file is present in the list")
    public void verifyFileIsNotPresent(String name) {
        PSFolderContentPanel psFolderContentPanel = new PSFolderContentPanel();
        psFolderContentPanel.getFileByName(name).shouldNotHave(text(name));
    }

    @Step("Verify file is discontinued")
    public void verifyFileIsDiscontinued(String name) {
        PSFolderContentPanel psFolderContentPanel = new PSFolderContentPanel();
        psFolderContentPanel.getDiscontinuedFileByName(name).shouldHave(text(name));
    }
}
