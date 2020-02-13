package dk.byggeweb.steps.project.workspace;

import com.codeborne.selenide.WebDriverRunner;
import dk.byggeweb.objects.project.workspace.modals.*;
import dk.byggeweb.objects.project.workspace.panels.FileInformationPanel;
import dk.byggeweb.objects.project.workspace.panels.FolderContentPanel;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class FileSteps {

    @Step("Select file")
    public void selectFile(String fileName) {
        FolderContentPanel folderContentPanel = new FolderContentPanel();
        folderContentPanel.getFileByName(fileName).click();
        new FileInformationPanel(fileName);
    }

    @Step("Enhanced upload file")
    public void enhancedUploadSingleFile(String file) {
        FolderContentPanel folderContentPanel = new FolderContentPanel();
        folderContentPanel.getFileUploadButton().click();
        String winHandleBefore = WebDriverRunner.getWebDriver().getWindowHandle();
        folderContentPanel.switchToNewWindow();
        FileUploadPopup fileUploadPopup = new FileUploadPopup();
        fileUploadPopup.switchToEnhancedUploadTab();
        FileEnhancedTabUpload fileUploadEnhancedTab = new FileEnhancedTabUpload();
        fileUploadEnhancedTab.dropFile(file);
        WebDriverRunner.getWebDriver().switchTo().window(winHandleBefore);
    }

    @Step("Standard upload file")
    public void standardUploadSingleFile(String file) {
        FolderContentPanel folderContentPanel = new FolderContentPanel();
        folderContentPanel.getFileUploadButton().click();
        String winHandleBefore = WebDriverRunner.getWebDriver().getWindowHandle();
        folderContentPanel.switchToNewWindow();
        FileUploadPopup fileUploadPopup = new FileUploadPopup();
        fileUploadPopup.switchToStandardUploadTab();
        FileStandardTabUpload fileUploadStandardTab = new FileStandardTabUpload();
        fileUploadStandardTab.selectFileToUpload(file);
        WebDriverRunner.getWebDriver().switchTo().window(winHandleBefore);
    }

    @Step("Transferal upload file")
    public void transferalUploadSingleFile(String file) {
        FolderContentPanel folderContentPanel = new FolderContentPanel();
        folderContentPanel.getFileUploadButton().click();
        String winHandleBefore = WebDriverRunner.getWebDriver().getWindowHandle();
        folderContentPanel.switchToNewWindow();
        FileUploadPopup fileUploadPopup = new FileUploadPopup();
        fileUploadPopup.switchToTransferalUploadTab();
        FileTransferalTabUpload fileUploadTransferalTab = new FileTransferalTabUpload();
        fileUploadTransferalTab.transferFileFromMyFolders(file);
        WebDriverRunner.getWebDriver().switchTo().window(winHandleBefore);
    }

    @Step("Delete file permanently")
    public void deleteFilePermanently(String fileName) {
        selectFile(fileName);
        FolderContentPanel folderContentPanel = new FolderContentPanel();
        folderContentPanel.getFileDeleteButton().click();
        folderContentPanel.switchToNewWindow();
        FileDeletePopup fileDeletePopup = new FileDeletePopup();
        fileDeletePopup.deleteFilePermanently();
        folderContentPanel.switchToLastTab();
    }

    @Step("Move file to Recycle bin")
    public void moveFileToRecycleBin(String fileName) {
        selectFile(fileName);
        FolderContentPanel folderContentPanel = new FolderContentPanel();
        folderContentPanel.getFileDeleteButton().click();
        folderContentPanel.switchToNewWindow();
        FileDeletePopup fileDeletePopup = new FileDeletePopup();
        fileDeletePopup.moveFileToRecycleBin();
        folderContentPanel.switchToLastTab();
    }

    @Step("Move file to another folder")
    public void moveFileToFolder(String fileName, String folderName, String parentFolderName) {
        selectFile(fileName);
        FolderContentPanel folderContentPanel = new FolderContentPanel();
        folderContentPanel.getFileMoveButton().click();
        folderContentPanel.switchToNewWindow();
        FileMovePopup fileMovePopup = new FileMovePopup();
        fileMovePopup.moveFile(parentFolderName, folderName);
        folderContentPanel.switchToLastTab();
    }

    @Step("Copy file to another folder")
    public void copyFileToFolder(String fileName, String folderName, String parentFolderName) {
        selectFile(fileName);
        FolderContentPanel folderContentPanel = new FolderContentPanel();
        folderContentPanel.getFileCopyButton().click();
        folderContentPanel.switchToNewWindow();
        FileCopyPopup fileCopyPopup = new FileCopyPopup();
        fileCopyPopup.copyFile(parentFolderName, folderName);
        folderContentPanel.switchToLastTab();
    }

    @Step("Lock/Unlock file")
    public void lockFile(String fileName) {
        selectFile(fileName);
        FolderContentPanel folderContentPanel = new FolderContentPanel();
        folderContentPanel.getFileLockButton().click();
        folderContentPanel.switchToNewWindow();
        FileLockPopup fileLockPopup = new FileLockPopup();
        fileLockPopup.unlockFile();
        folderContentPanel.switchToLastTab();
    }

    @Step("Verify lock icon is present (file is locked)")
    public void verifyFileIsLocked(String name) {
        FolderContentPanel folderContentPanel = new FolderContentPanel();
        folderContentPanel.getFileContainsLockIcon(name).shouldBe(visible);
    }

    @Step("Verify lock icon is not present (file is unlocked)")
    public void verifyFileIsUnlocked(String name) {
        FolderContentPanel folderContentPanel = new FolderContentPanel();
        folderContentPanel.getFileContainsLockIcon(name).shouldNotBe(visible);
    }

    public boolean isFileLocked(String name) {
        FolderContentPanel folderContentPanel = new FolderContentPanel();
        return folderContentPanel.getFileContainsLockIcon(name).isDisplayed();
    }

    @Step("Start to monitor file")
    public void startMonitorFile(String filename) {
        selectFile(filename);
        FolderContentPanel folderContentPanel = new FolderContentPanel();
        folderContentPanel.getFileMonitorButton().click();
    }

    @Step("Close edit file information popup")
    public void closeEditFileInformationPopup() {
        FileInformationEditPopup fileInformationEditPopup = new FileInformationEditPopup();
        fileInformationEditPopup.closeEditFileInformation();
    }

    @Step("Verify file is present in the list")
    public void verifyFileIsPresent(String name) {
        FolderContentPanel folderContentPanel = new FolderContentPanel();
        folderContentPanel.getFileByName(name).shouldHave(text(name));
    }

    @Step("Verify file is not present in the list")
    public void verifyFileIsNotPresent(String name) {
        FolderContentPanel folderContentPanel = new FolderContentPanel();
        folderContentPanel.getFileByName(name).shouldNotHave(text(name));
    }

    @Step("Verify data is present in table")
    public void verifyDataIsPresentInTable(String name) {
        FolderContentPanel folderContentPanel = new FolderContentPanel();
        folderContentPanel.getFileByName(name).shouldHave(text(name));
    }

}
