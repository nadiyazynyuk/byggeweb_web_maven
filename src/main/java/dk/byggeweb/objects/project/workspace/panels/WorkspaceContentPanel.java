package dk.byggeweb.objects.project.workspace.panels;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import dk.byggeweb.objects.project.ProjectHomePage;
import dk.byggeweb.objects.project.workspace.modals.*;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class WorkspaceContentPanel extends ProjectHomePage {

    private SelenideElement panelTitle = $(byXpath("//div[contains(@class, 'WMP_main-file-grid')]//div[@class='x-title-text x-title-text-default x-title-item']"));
    private SelenideElement fileUploadButton = $(byXpath("//span[@data-locator='locator-btn-file_upload']"));
    private SelenideElement fileDownloadButton = $(byXpath("//span[@data-locator='locator-btn-file_download']"));
    private SelenideElement filePublishButton = $(byXpath("//span[@data-locator='locator-btn-file_doctransfer']"));
    private SelenideElement fileDeleteButton = $(byXpath("//span[@data-locator='locator-btn-file_delete']"));
    private SelenideElement fileLockButton = $(byXpath("//span[@data-locator='locator-btn-file_lock']"));
    private SelenideElement fileCopyButton = $(byXpath("//span[@data-locator='locator-btn-file_copy']"));
    private SelenideElement fileMoveButton = $(byXpath("//span[@data-locator='locator-btn-file_move']"));
    private SelenideElement fileEditInfoButton = $(byXpath("//span[@data-locator='locator-btn-file_info']"));
    private SelenideElement fileNotifyButton = $(byXpath("//span[@data-locator='locator-btn-file_notify']"));
    private SelenideElement fileAddToVersionSetButton = $(byXpath("//span[@data-locator='locator-btn-file_versionset_add']"));
    private SelenideElement fileDownloadInExcelButton = $(byXpath("//span[@data-locator='locator-btn-file_excel']"));
    private SelenideElement fileRemoveFromSinceLastTimeListButton = $(byXpath("//span[@data-locator='locator-btn-file_checkout']"));
    private SelenideElement fileSendToPrintButton = $(byXpath("//span[@data-locator='locator-btn-file_plot']"));
    private SelenideElement fileAdvancedSearchButton = $(byXpath("//span[@data-locator='locator-btn-file_search']"));
    private SelenideElement fileMonitorButton = $(byXpath("//span[@data-locator='locator-btn-file_watch_toggle']"));

    private SelenideElement getFileByName(String name) {
        return $(byXpath("//tr[@class='  x-grid-row']//*[contains(text(),'" + name + "')]"));
    }

    private SelenideElement getFileContainsLockIcon(String name) {
        return $(byXpath("//img[@class='lock-tipp']/parent::div/parent::td/parent::tr/td/div[contains(text(), '" + name + "')]"));
    }

    @Step("Select file")
    public void clickOnFile(String name) {
        getFileByName(name).click();
    }

    @Step("Enhanced upload file")
    public void enhancedUploadSingleFile(String file) {
        fileUploadButton.click();
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
        fileUploadButton.click();
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
        fileUploadButton.click();
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
        fileDeleteButton.click();
        switchToNewWindow();
        FileDeletePopup fileDeletePopup = new FileDeletePopup();
        fileDeletePopup.deleteFilePermanently();
        switchToLastTab();
    }

    @Step("Move file to Recycle bin")
    public void moveFileToRecycleBin(String name) {
        clickOnFile(name);
        fileDeleteButton.click();
        switchToNewWindow();
        FileDeletePopup fileDeletePopup = new FileDeletePopup();
        fileDeletePopup.moveFileToRecycleBin();
        switchToLastTab();
    }

    @Step("Move file to another folder")
    public void moveFileToFolder(String fileName, String folderName, String parentFolderName) {
        clickOnFile(fileName);
        fileMoveButton.click();
        switchToNewWindow();
        FileMovePopup fileMovePopup = new FileMovePopup();
        fileMovePopup.moveFile(parentFolderName, folderName);
        switchToLastTab();
    }

    @Step("Copy file to another folder")
    public void copyFileToFolder(String fileName, String folderName, String parentFolderName) {
        clickOnFile(fileName);
        fileCopyButton.click();
        switchToNewWindow();
        FileCopyPopup fileCopyPopup = new FileCopyPopup();
        fileCopyPopup.copyFile(parentFolderName, folderName);
        switchToLastTab();
    }

    @Step("Lock/Unlock file")
    public void lockFile(String fileName) {
        clickOnFile(fileName);
        fileLockButton.click();
        switchToNewWindow();
        FileLockPopup fileLockPopup = new FileLockPopup();
        fileLockPopup.unlockFile();
        switchToLastTab();
    }

    @Step("Monitor file")
    public void monitorFile(String filename) {

    }

    @Step("Verify file is present in the list")
    public void verifyFileIsPresent(String name) {
        getFileByName(name).shouldHave(text(name));
    }

    @Step("Verify file is not present in the list")
    public void verifyFileIsNotPresent(String name) {
        getFileByName(name).shouldNotHave(text(name));
    }

    @Step("Verify data is present in table")
    public void verifyDataIsPresentInTable(String name) {
        getFileByName(name).shouldHave(text(name));
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

    public WorkspaceContentPanel() {
        super();
    }

    public WorkspaceContentPanel(String title) {
        panelTitle.shouldHave(text(title));
    }

}
