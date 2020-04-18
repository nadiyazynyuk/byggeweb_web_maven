package dk.byggeweb.desktop.personalspace;

import dk.byggeweb.infrastructure.test.DesktopTestBase;
import dk.byggeweb.objects.desktop.personalspace.MyFoldersPage;
import dk.byggeweb.objects.desktop.personalspace.PersonalSpacePage;
import io.qameta.allure.Link;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FilesAndFolders extends DesktopTestBase {

    private MyFoldersPage myFoldersPage;

    @Link(url = "https://itwofm.atlassian.net/browse/TSB-5")

    @BeforeClass
    public void deleteFilesAndFoldersIfExist() {
        homePage.navigateToPersonalSpace();
        PersonalSpacePage personalSpacePage = new PersonalSpacePage();
        personalSpacePage.navigateToMyFolders();
        myFoldersPage = new MyFoldersPage();

        while (true) {
            try {
                myFoldersPage.deleteFile(data.getTestFileName());
                myFoldersPage.verifyNameIsAbsentInTable(data.getTestFileName());
            } catch (com.codeborne.selenide.ex.ElementNotFound e) {
                break;
            }
        }

        while (true) {
            try {
                myFoldersPage.deleteFolder(data.getTestFolder());
                myFoldersPage.verifyNameIsAbsentInTable(data.getTestFolder());
            } catch (com.codeborne.selenide.ex.ElementNotFound e) {
                break;
            }
        }
    }

    @Test(description = "Upload file in Personal space > My folders")
    public void uploadFile() {
        myFoldersPage.uploadFile(getAbsolutePath(data.getFileToUploadPath()));
        myFoldersPage.verifyNameIsPresentInTable(data.getTestFileName());
    }

    @Test(dependsOnMethods = "uploadFile", description = "Edit file in Personal space > My folders")
    public void editFile() {
        myFoldersPage.editFileInfo(data.getTestFileName(), data.getTestInfo());
        myFoldersPage.verifyNameIsPresentInTable(data.getTestInfo());
    }

    @Test(dependsOnMethods = "editFile", description = "Create and open folder in Personal space > My folders")
    public void createAndOpenFolder() {
        myFoldersPage.createFolder(data.getTestFolder());
        myFoldersPage.verifyNameIsPresentInTable(data.getTestFolder());
    }

    @Test(dependsOnMethods = "createAndOpenFolder", description = "Upload nested file in Personal space > My folders")
    public void uploadNestedFile() {
        myFoldersPage.clickOnFolderInTable(data.getTestFolder());
        myFoldersPage.uploadFile(getAbsolutePath(data.getFileToUploadPath()));
        myFoldersPage.verifyNameIsPresentInTable(data.getTestFileName());
    }

    @Test(dependsOnMethods = "uploadNestedFile", description = "Edit nested file in Personal space > My folders")
    public void editNestedFile() {
        myFoldersPage.editFileInfo(data.getTestFileName(), data.getTestInfo());
        myFoldersPage.verifyNameIsPresentInTable(data.getTestInfo());
    }

    @Test(dependsOnMethods = "editNestedFile", description = "Delete file in Personal space > My folders")
    public void deleteFile() {
        myFoldersPage.navigateToMyFolders();
        myFoldersPage.deleteFile(data.getTestFileName());
        myFoldersPage.verifyNameIsAbsentInTable(data.getTestFileName());
    }

    @Test(dependsOnMethods = "editNestedFile", description = "Delete folder in Personal space > My folders")
    public void deleteFolder() {
        myFoldersPage.deleteFolder(data.getTestFolder());
        myFoldersPage.verifyNameIsAbsentInTable(data.getTestFolder());
    }

}
