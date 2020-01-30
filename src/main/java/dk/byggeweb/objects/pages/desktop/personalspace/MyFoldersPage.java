package dk.byggeweb.objects.pages.desktop.personalspace;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import dk.byggeweb.infrastructure.steps.GeneralSteps;
import dk.byggeweb.objects.pages.desktop.personalspace.modals.*;
import io.qameta.allure.Step;
import lombok.Getter;

import java.io.File;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class MyFoldersPage extends PersonalSpacePage {

    private String myFoldersHeaderXpath = "//div[@id='foldersgriddiv']/div[contains(@class,'x-panel')]/div[contains(@class,'x-panel-header')]/span[text()='My folders']";
    private SelenideElement myFoldersTableHeader = $(byXpath(myFoldersHeaderXpath));

    private SelenideElement filesMenu = $(byXpath("//div[@id='foldersgriddiv']//button[contains(@class, 'x-btn-text') and contains(@class, 'desktop-icon-file-options')]"));
    private SelenideElement uploadFilesMenuItem = $(byXpath("//div[@id='file_menu']/ul/li/a/span[contains(@class, 'x-menu-item-text') and contains(text(), 'Upload files')]"));
    private SelenideElement editFileInfoButton = $(byXpath("//a[@id='filemenu_edit']"));
    private SelenideElement deleteFilesMenuItem = $(byXpath("//div[@id='file_menu']/ul/li/a[@id='filemenu_delete']"));

    private SelenideElement foldersMenu = $(byXpath("//div[@id='foldersgriddiv']//button[contains(@class, 'x-btn-text') and contains(@class, 'desktop-icon-folder-options')]"));
    private SelenideElement newFolderMenuItem = $(byXpath("//div[@id='folder_menu']/ul/li/a/span[contains(@class, 'x-menu-item-text') and contains(text(), 'New folder')]"));
    private SelenideElement deleteFolderMenuItem = $(byXpath("//div[@id='folder_menu']/ul/li/a[@id='foldermenu_delete']"));

    private SelenideElement getRowByName(String name) {
        return $(byXpath("//div[@id='foldersgriddiv']//*[contains(text(),'" + name + "')]"));
    }

    private SelenideElement getFooterByFileName(String name) {
        return $(byXpath("//div[@id='foldersgriddiv']/div[contains(@class,'x-panel')]/div[contains(@class,'x-panel-bwrap')]/div[contains(@class,'x-panel-body')]/div[contains(@class,'x-panel')][2]//div[contains(@class,'headline1-standard') and contains(text(),'" + name + "')]"));
    }

    private SelenideElement getFileRow(String name, String version) {
        return $(byXpath("//div[@id='foldersgriddiv']//*[contains(text(),'" + name + "')]/parent::div/parent::td/parent::tr/td[11]//*[contains(text(),'" + version + "')]"));
    }

    @Step("Upload file")
    public void uploadFile(String testFile) {
        filesMenu.click();
        uploadFilesMenuItem.click();
        UploadFilesPopup uploadFilesPopup = new UploadFilesPopup();
        switchToFrame(uploadFilesPopup.getIFrame());
        GeneralSteps.dropFile(new File(testFile), WebDriverRunner.getWebDriver(), uploadFilesPopup.getDropArea(), 0, 0);
        switchToParentFrame();
        uploadFilesPopup.getOkButton().click();
    }

    @Step("Edit file information")
    public void editFileInfo(String testFile, String testInfo) {
        clickOnFileInTable(testFile);
        filesMenu.click();
        editFileInfoButton.click();
        EditFileInfoPopup editFileInfoPopup = new EditFileInfoPopup();
        switchToFrame(editFileInfoPopup.getIFrame());
        editFileInfoPopup.getSubjectNameInput(testFile).clear();
        editFileInfoPopup.getSubjectNameInput(testFile).setValue(testInfo);
        switchToParentFrame();
        editFileInfoPopup.getOkButton().click();
    }

    @Step("Delete file")
    public void deleteFile(String testFile) {
        clickOnFileInTable(testFile);
        filesMenu.click();
        deleteFilesMenuItem.click();
        DeleteFilePopup deleteFilePopup = new DeleteFilePopup();
        switchToFrame(deleteFilePopup.getIFrame());
        deleteFilePopup.verifyPopupIsLoaded(deleteFilePopup.getDeleteLabel());
        switchToParentFrame();
        deleteFilePopup.getOkButton().click();
    }

    @Step("Create folder")
    public void createFolder(String testFolder) {
        foldersMenu.click();
        newFolderMenuItem.click();
        CreateFolderPopup createFolderPopup = new CreateFolderPopup();
        switchToFrame(createFolderPopup.getIFrame());
        createFolderPopup.getFolderNameInput().setValue(testFolder);
        switchToParentFrame();
        createFolderPopup.getOkButton().click();
    }

    @Step("Delete folder")
    public void deleteFolder(String testFolder) {
        clickOnFolderInTable(testFolder);
        foldersMenu.click();
        deleteFolderMenuItem.click();
        DeleteFolderPopup deleteFolderPopup = new DeleteFolderPopup();
        switchToFrame(deleteFolderPopup.getIFrame());
        deleteFolderPopup.verifyPopupIsLoaded(deleteFolderPopup.getDeleteLabel());
        switchToParentFrame();
        deleteFolderPopup.getOkButton().click();
    }

    @Step("Verify name is present or absent in table")
    public void verifyNameIsPresentInTable(String name) {
        getRowByName(name).should(Condition.visible);
    }

    @Step("Verify name is present or absent in table")
    public void verifyNameIsAbsentInTable(String name) {
        getRowByName(name).shouldNot(Condition.visible);
    }

    @Step("Verify name and version is correct")
    public void verifyNameAndVersionIsCorrect(String name, String version) {
        getFileRow(name, version).should(Condition.visible);
    }

    @Step("Click on file in table")
    public void clickOnFileInTable(String name) {
        getRowByName(name).click();
        getFooterByFileName(name).shouldBe(Condition.visible);
    }

    @Step("Click on folder in table")
    public void clickOnFolderInTable(String name) {
        getRowByName(name).click();
        $(byXpath(myFoldersHeaderXpath.replace("My folders", "My folders/" + name))).should(Condition.visible);
    }
}
