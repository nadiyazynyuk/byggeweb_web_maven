package dk.byggeweb.steps.project.workspace;

import com.codeborne.selenide.WebDriverRunner;
import dk.byggeweb.objects.project.common.modals.FileEnhancedUploadTab;
import dk.byggeweb.objects.project.common.modals.FileStandardUploadTab;
import dk.byggeweb.objects.project.common.modals.FileTransferalUploadTab;
import dk.byggeweb.objects.project.common.modals.FileUploadPopup;
import dk.byggeweb.objects.project.workspace.modals.*;
import dk.byggeweb.objects.project.workspace.panels.WSFileInformationPanel;
import dk.byggeweb.objects.project.workspace.panels.WSFolderContentPanel;
import dk.byggeweb.steps.GeneralSteps;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

@Log4j
public class WSFileSteps {

    @Step("Select file")
    public void selectFile(String fileName) {
        new WSFolderContentPanel().getFileByName(fileName).click();
        log.info("File " + fileName + " was selected");
        new WSFileInformationPanel(fileName);
    }

    @Step("Enhanced upload file")
    public void enhancedUploadSingleFile(String file) {
        WSFolderContentPanel wsFolderContentPanel = new WSFolderContentPanel();
        wsFolderContentPanel.getFileUploadButton().click();
        String winHandleBefore = WebDriverRunner.getWebDriver().getWindowHandle();
        wsFolderContentPanel.switchToNewWindow();
        FileUploadPopup fileUploadPopup = new FileUploadPopup();
        fileUploadPopup.switchToEnhancedUploadTab();
        FileEnhancedUploadTab fileEnhancedUploadTab = new FileEnhancedUploadTab();
        fileEnhancedUploadTab.dropFile(file);
        WebDriverRunner.getWebDriver().switchTo().window(winHandleBefore);
    }

    @Step("Standard upload file")
    public void standardUploadSingleFile(String file) {
        WSFolderContentPanel wsFolderContentPanel = new WSFolderContentPanel();
        wsFolderContentPanel.getFileUploadButton().click();
        String winHandleBefore = WebDriverRunner.getWebDriver().getWindowHandle();
        wsFolderContentPanel.switchToNewWindow();
        FileUploadPopup fileUploadPopup = new FileUploadPopup();
        fileUploadPopup.switchToStandardUploadTab();
        FileStandardUploadTab fileStandardUploadTab = new FileStandardUploadTab();
        fileStandardUploadTab.selectFileToUpload(file);
        WebDriverRunner.getWebDriver().switchTo().window(winHandleBefore);
    }

    @Step("Transferal upload file")
    public void transferalUploadSingleFile(String file) {
        WSFolderContentPanel wsFolderContentPanel = new WSFolderContentPanel();
        wsFolderContentPanel.getFileUploadButton().click();
        String winHandleBefore = WebDriverRunner.getWebDriver().getWindowHandle();
        wsFolderContentPanel.switchToNewWindow();
        FileUploadPopup fileUploadPopup = new FileUploadPopup();
        fileUploadPopup.switchToTransferalUploadTab();
        FileTransferalUploadTab fileTransferalUploadTab = new FileTransferalUploadTab();
        fileTransferalUploadTab.transferFileFromMyFolders(file);
        WebDriverRunner.getWebDriver().switchTo().window(winHandleBefore);
    }

    @Step("Download file")
    public void downloadFile(String fileName) {
        selectFile(fileName);
        new WSFolderContentPanel().getFileDownloadButton().click();
    }

    @Step("Download all files from the folder")
    public void generateDownloadFilesLink(String fileName) {
        selectFile(fileName);
        WSFolderContentPanel wsFolderContentPanel = new WSFolderContentPanel();
        GeneralSteps.selectAll();
        wsFolderContentPanel.getFileDownloadButton().click();
        wsFolderContentPanel.switchToNewWindow();
        WSFileDownloadPopup wsFileDownloadPopup = new WSFileDownloadPopup();
        wsFileDownloadPopup.getOkButton().click();
        wsFileDownloadPopup.getDownloadLink().shouldBe(visible);
        wsFileDownloadPopup.getCancelButton().click();
        wsFolderContentPanel.switchToLastTab();
    }

    @Step("Delete file permanently")
    public void deleteFilePermanently(String fileName) {
        selectFile(fileName);
        WSFolderContentPanel wsFolderContentPanel = new WSFolderContentPanel();
        wsFolderContentPanel.getFileDeleteButton().click();
        wsFolderContentPanel.switchToNewWindow();
        WSFileDeletePopup wsFileDeletePopup = new WSFileDeletePopup();
        wsFileDeletePopup.deleteFilePermanently();
        wsFolderContentPanel.switchToLastTab();
    }

    @Step("Move file to Recycle bin")
    public void moveFileToRecycleBin(String fileName) {
        selectFile(fileName);
        WSFolderContentPanel wsFolderContentPanel = new WSFolderContentPanel();
        wsFolderContentPanel.getFileDeleteButton().click();
        wsFolderContentPanel.switchToNewWindow();
        WSFileDeletePopup wsFileDeletePopup = new WSFileDeletePopup();
        wsFileDeletePopup.moveFileToRecycleBin();
        wsFolderContentPanel.switchToLastTab();
    }

    @Step("Move file to another folder")
    public void moveFileToFolder(String fileName, String folderName, String parentFolderName) {
        selectFile(fileName);
        WSFolderContentPanel wsFolderContentPanel = new WSFolderContentPanel();
        wsFolderContentPanel.getFileMoveButton().click();
        wsFolderContentPanel.switchToNewWindow();
        WSFileMovePopup wsFileMovePopup = new WSFileMovePopup();
        wsFileMovePopup.moveFile(parentFolderName, folderName);
        wsFolderContentPanel.switchToLastTab();
    }

    @Step("Copy file to another folder")
    public void copyFileToFolder(String fileName, String folderName, String parentFolderName) {
        selectFile(fileName);
        WSFolderContentPanel wsFolderContentPanel = new WSFolderContentPanel();
        wsFolderContentPanel.getFileCopyButton().click();
        wsFolderContentPanel.switchToNewWindow();
        WSFileCopyPopup wsFileCopyPopup = new WSFileCopyPopup();
        wsFileCopyPopup.copyFile(parentFolderName, folderName);
        wsFolderContentPanel.switchToLastTab();
    }

    @Step("Publish new file")
    public void publishNewFile(String fileName, String documentListFolderName) {
        selectFile(fileName);
        WSFolderContentPanel wsFolderContentPanel = new WSFolderContentPanel();
        wsFolderContentPanel.getFilePublishButton().click();
        wsFolderContentPanel.switchToNewWindow();
        WSFilePublishPopup wsFilePublishPopup = new WSFilePublishPopup();
        wsFilePublishPopup.publishFile(documentListFolderName);
        wsFolderContentPanel.switchToLastTab();
    }

    @Step("Publish new file version")
    public void publishNewFileVersion(String fileName) {
        selectFile(fileName);
        WSFolderContentPanel wsFolderContentPanel = new WSFolderContentPanel();
        wsFolderContentPanel.getFilePublishButton().click();
        wsFolderContentPanel.switchToNewWindow();
        WSFilePublishPopup wsFilePublishPopup = new WSFilePublishPopup();
        wsFilePublishPopup.publishNewFileVersion();
        wsFolderContentPanel.switchToLastTab();
    }

    @Step("Lock/Unlock file")
    public void lockFile(String fileName) {
        selectFile(fileName);
        WSFolderContentPanel wsFolderContentPanel = new WSFolderContentPanel();
        wsFolderContentPanel.getFileLockButton().click();
        wsFolderContentPanel.switchToNewWindow();
        WSFileLockPopup wsFileLockPopup = new WSFileLockPopup();
        wsFileLockPopup.unlockFile();
        wsFolderContentPanel.switchToLastTab();
    }

    @Step("Verify lock icon is present (file is locked)")
    public void verifyFileIsLocked(String name) {
        new WSFolderContentPanel().getFileContainsLockIcon(name).shouldBe(visible);
    }

    @Step("Verify lock icon is not present (file is unlocked)")
    public void verifyFileIsUnlocked(String name) {
        new WSFolderContentPanel().getFileContainsLockIcon(name).shouldNotBe(visible);
    }

    @Step("Get file lock status")
    public boolean getFileLockStatus(String fileName) {
        return new WSFolderContentPanel().isFileLocked(fileName);
    }

    @Step("Start to monitor file")
    public void startMonitorFile(String filename) {
        selectFile(filename);
        new WSFolderContentPanel().getFileMonitorButton().click();
    }

    @Step("Close edit file information popup")
    public void closeEditFileInformationPopup() {
        new WSFileInformationEditPopup().closeEditFileInformation();
    }

    @Step("Verify file is present in the list")
    public void verifyFileIsPresent(String name) {
        new WSFolderContentPanel().getFileByName(name).shouldHave(text(name));
    }

    @Step("Verify file is not present in the list")
    public void verifyFileIsNotPresent(String name) {
        new WSFolderContentPanel().getFileByName(name).shouldNotHave(text(name));
    }

    @Step("Verify data is present in table")
    public void verifyDataIsPresentInTable(String name) {
        new WSFolderContentPanel().getFileByName(name).shouldHave(text(name));
    }

}
