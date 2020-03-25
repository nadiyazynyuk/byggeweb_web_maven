package dk.byggeweb.steps.project.publicationspace;

import com.codeborne.selenide.WebDriverRunner;
import dk.byggeweb.objects.project.common.modals.FileAddToVersionSetPopup;
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
import lombok.extern.log4j.Log4j;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

@Log4j
public class PSFileSteps {

    @Step("Select file")
    public void selectFile(String fileName) {
        new PSFolderContentPanel().getFileByName(fileName).click();
        log.info("File " + fileName + " was selected");
        new PSFileInformationPanel(fileName);
    }

    @Step("Delete file")
    public void deleteFile(String fileName) {
        selectFile(fileName);
        PSFolderContentPanel psFolderContentPanel = new PSFolderContentPanel();
        psFolderContentPanel.getFileDeleteButton().click();
        log.info("Delete button was clicked");
        psFolderContentPanel.switchToNewWindow();
        PSFileDeletePopup fileDeletePopup = new PSFileDeletePopup();
        fileDeletePopup.deleteFilePermanently();
        log.info("File " + fileName + " was permanently deleted");
        psFolderContentPanel.switchToLastTab();
    }

    @Step("Publish file from Local machine")
    public void publishFileFromLocalMachine(String filePath, String fileName) {
        PSFolderContentPanel psFolderContentPanel = new PSFolderContentPanel();
        psFolderContentPanel.getFilePublishButton().click();
        log.info("Publish/upload file version button was clicked");
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
        log.info("File " + fileName + " was published from Local Machine");
        WebDriverRunner.getWebDriver().switchTo().window(winHandleBefore);
    }

    @Step("Publish file from Workspace")
    public void publishFileFromWorkspace(String fileName, String folderName) {
        PSFolderContentPanel psFolderContentPanel = new PSFolderContentPanel();
        psFolderContentPanel.getFilePublishButton().click();
        log.info("Publish/upload file version button was clicked");
        String winHandleBefore = WebDriverRunner.getWebDriver().getWindowHandle();
        psFolderContentPanel.switchToNewWindow();
        PSFilePublishPopup psFilePublishPopup = new PSFilePublishPopup();
        psFilePublishPopup.publishFileFromWorkspaceFolder(folderName, fileName);
        log.info("File " + fileName + " was published from Workspace folder " + folderName);
        WebDriverRunner.getWebDriver().switchTo().window(winHandleBefore);
    }

    @Step("Select discontinued file")
    public void selectDiscontinuedFile(String fileName) {
        new PSFolderContentPanel().getDiscontinuedFileByName(fileName).click();
        log.info("Discontinued file " + fileName + " was selected");
        new PSFileInformationPanel(fileName);
    }

    @Step("Discontinue file")
    public void discontinueFile(String fileName) {
        selectFile(fileName);
        PSFolderContentPanel psFolderContentPanel = new PSFolderContentPanel();
        psFolderContentPanel.getFileDeleteButton().click();
        log.info("Delete files button was clicked");
        psFolderContentPanel.switchToNewWindow();
        PSFileDeletePopup fileDeletePopup = new PSFileDeletePopup();
        fileDeletePopup.discontinueFile();
        log.info("File " + fileName + " was discontinued");
        psFolderContentPanel.switchToLastTab();
    }

    @Step("Delete discontinued file")
    public void deleteDiscontinuedFile(String fileName) {
        selectDiscontinuedFile(fileName);
        PSFolderContentPanel psFolderContentPanel = new PSFolderContentPanel();
        psFolderContentPanel.getFileDeleteButton().click();
        log.info("Delete files button was clicked");
        psFolderContentPanel.switchToNewWindow();
        PSFileDeletePopup fileDeletePopup = new PSFileDeletePopup();
        fileDeletePopup.deleteFilePermanently();
        log.info("File " + fileName + " was deleted");
        psFolderContentPanel.switchToLastTab();
    }

    @Step("Download file")
    public void downloadFile(String fileName) {
        selectFile(fileName);
        new PSFolderContentPanel().getFileDownloadButton().click();
        log.info("Download files button was clicked");
    }

    @Step("Download all files from the folder")
    public void generateDownloadFilesLink(String fileName) {
        selectFile(fileName);
        PSFolderContentPanel psFolderContentPanel = new PSFolderContentPanel();
        GeneralSteps.selectAll();
        psFolderContentPanel.getFileDownloadButton().click();
        log.info("Download files button was clicked");
        psFolderContentPanel.switchToNewWindow();
        FileDownloadPopup fileDownloadPopup = new FileDownloadPopup();
        fileDownloadPopup.getOkButton().click();
        fileDownloadPopup.getDownloadLink().shouldBe(visible);
        fileDownloadPopup.getCancelButton().click();
        psFolderContentPanel.switchToLastTab();
    }

    @Step("Add file to version set")
    public void addFileToVersionSet(String filename, String versionSetName) {
        selectFile(filename);
        PSFolderContentPanel psFolderContentPanel = new PSFolderContentPanel();
        psFolderContentPanel.getFileAddToVersionSetButton().click();
        log.info("Add to version sets button was clicked");
        psFolderContentPanel.switchToNewWindow();
        FileAddToVersionSetPopup fileAddToVersionSetPopup = new FileAddToVersionSetPopup();
        fileAddToVersionSetPopup.addFileToVersionSet(versionSetName);
        log.info("File " + filename + " was added to the version set: " + versionSetName);
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

    @Step("Verify data is present in table")
    public void verifyDataIsPresentInTable(String name) {
        new PSFolderContentPanel().getFileByName(name).shouldHave(text(name));
    }
}
