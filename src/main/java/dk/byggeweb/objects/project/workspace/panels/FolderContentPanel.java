package dk.byggeweb.objects.project.workspace.panels;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import dk.byggeweb.objects.project.workspace.modals.*;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class FolderContentPanel extends WorkspaceContentPanel {

    private SelenideElement panelTitle = $(byXpath("//div[contains(@class, 'WMP_main-file-grid')]//div[@class='x-title-text x-title-text-default x-title-item']"));

    private SelenideElement getFileContainsLockIcon(String name) {
        return $(byXpath("//img[@class='lock-tipp']/parent::div/parent::td/parent::tr/td/div[contains(text(), '" + name + "')]"));
    }

    @Step("Enhanced upload file")
    public void enhancedUploadSingleFile(String file) {
        getFileUploadButton().click();
        String winHandleBefore = WebDriverRunner.getWebDriver().getWindowHandle();
        switchToNewWindow();
        FileUploadPopup fileUploadPopup = new FileUploadPopup();
        fileUploadPopup.switchToEnhancedUploadTab();
        FileEnhancedTabUpload fileUploadEnhancedTab = new FileEnhancedTabUpload();
        fileUploadEnhancedTab.dropFile(file);
        WebDriverRunner.getWebDriver().switchTo().window(winHandleBefore);
    }

    @Step("Standard upload file")
    public void standardUploadSingleFile(String file) {
        getFileUploadButton().click();
        String winHandleBefore = WebDriverRunner.getWebDriver().getWindowHandle();
        switchToNewWindow();
        FileUploadPopup fileUploadPopup = new FileUploadPopup();
        fileUploadPopup.switchToStandardUploadTab();
        FileStandardTabUpload fileUploadStandardTab = new FileStandardTabUpload();
        fileUploadStandardTab.selectFileToUpload(file);
        WebDriverRunner.getWebDriver().switchTo().window(winHandleBefore);
    }

    @Step("Transferal upload file")
    public void transferalUploadSingleFile(String file) {
        getFileUploadButton().click();
        String winHandleBefore = WebDriverRunner.getWebDriver().getWindowHandle();
        switchToNewWindow();
        FileUploadPopup fileUploadPopup = new FileUploadPopup();
        fileUploadPopup.switchToTransferalUploadTab();
        FileTransferalTabUpload fileUploadTransferalTab = new FileTransferalTabUpload();
        fileUploadTransferalTab.transferFileFromMyFolders(file);
        WebDriverRunner.getWebDriver().switchTo().window(winHandleBefore);
    }

    @Step("Delete file")
    public void deleteFile(String name) {
        clickOnFile(name);
        getFileDeleteButton().click();
        switchToNewWindow();
        FileDeletePopup fileDeletePopup = new FileDeletePopup();
        fileDeletePopup.deleteFilePermanently();
        switchToLastTab();
    }

    @Step("Move file to Recycle bin")
    public void moveFileToRecycleBin(String name) {
        clickOnFile(name);
        getFileDeleteButton().click();
        switchToNewWindow();
        FileDeletePopup fileDeletePopup = new FileDeletePopup();
        fileDeletePopup.moveFileToRecycleBin();
        switchToLastTab();
    }

    @Step("Move file to another folder")
    public void moveFileToFolder(String fileName, String folderName, String parentFolderName) {
        clickOnFile(fileName);
        getFileMoveButton().click();
        switchToNewWindow();
        FileMovePopup fileMovePopup = new FileMovePopup();
        fileMovePopup.moveFile(parentFolderName, folderName);
        switchToLastTab();
    }

    @Step("Copy file to another folder")
    public void copyFileToFolder(String fileName, String folderName, String parentFolderName) {
        clickOnFile(fileName);
        getFileCopyButton().click();
        switchToNewWindow();
        FileCopyPopup fileCopyPopup = new FileCopyPopup();
        fileCopyPopup.copyFile(parentFolderName, folderName);
        switchToLastTab();
    }

    @Step("Lock/Unlock file")
    public void lockFile(String fileName) {
        clickOnFile(fileName);
        getFileLockButton().click();
        switchToNewWindow();
        FileLockPopup fileLockPopup = new FileLockPopup();
        fileLockPopup.unlockFile();
        switchToLastTab();
    }

    @Step("Start to monitor file")
    public void startMonitorFile(String filename) {
        clickOnFile(filename);
        getFileMonitorButton().click();
    }

    @Step("Verify lock icon is present (file is locked)")
    public void verifyFileIsLocked(String name) {
        getFileContainsLockIcon(name).shouldBe(visible);
    }

    @Step("Verify lock icon is not present (file is unlocked)")
    public void verifyFileIsUnlocked(String name) {
        getFileContainsLockIcon(name).shouldNotBe(visible);
    }

    public boolean isFileLocked(String name) {
        return getFileContainsLockIcon(name).isDisplayed();
    }

    public FolderContentPanel(String title) {
        panelTitle.shouldHave(text(title));
    }

    public FolderContentPanel(){}
}
