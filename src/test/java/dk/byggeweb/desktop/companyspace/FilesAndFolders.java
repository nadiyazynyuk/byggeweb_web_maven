package dk.byggeweb.desktop.companyspace;

import dk.byggeweb.infrastructure.test.DesktopTestBase;
import dk.byggeweb.objects.desktop.companyspace.CompanySpacePage;
import dk.byggeweb.objects.desktop.companyspace.SharedFoldersPage;
import io.qameta.allure.Link;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FilesAndFolders extends DesktopTestBase {

    private SharedFoldersPage sharedFoldersPage;

    @Link(url = "https://itwofm.atlassian.net/browse/TSB-4")

    @BeforeClass
    public void deleteFilesAndFoldersIfExist() {
        homePage.navigateToCompanySpace();
        CompanySpacePage companySpacePage = new CompanySpacePage();
        companySpacePage.navigateToSharedFolders();
        sharedFoldersPage = new SharedFoldersPage();

        while (true) {
            try {
                sharedFoldersPage.deleteFile(data.getTestFileName());
                sharedFoldersPage.verifyNameIsAbsentInTable(data.getTestFileName());
            } catch (com.codeborne.selenide.ex.ElementNotFound e) {
                break;
            }
        }

        while (true) {
            try {
                sharedFoldersPage.deleteFolder(data.getTestFolder());
                sharedFoldersPage.verifyNameIsAbsentInTable(data.getTestFolder());
            } catch (com.codeborne.selenide.ex.ElementNotFound e) {
                break;
            }
        }
    }

    @Test(description = "Upload file in Company space > Shared folders")
    public void uploadFile() {
        sharedFoldersPage.uploadFile(getAbsolutePath(data.getFileToUploadPath()));
        sharedFoldersPage.verifyNameIsPresentInTable(data.getTestFileName());
    }

    @Test(dependsOnMethods = "uploadFile", description = "Edit file in Company space > Shared folders")
    public void editFile() {
        sharedFoldersPage.editFileInfo(data.getTestFileName(), data.getTestInfo());
        sharedFoldersPage.verifyNameIsPresentInTable(data.getTestInfo());
    }

    @Test(dependsOnMethods = "editFile", description = "Create and open folder in Company space > Shared folders")
    public void createAndOpenFolder() {
        sharedFoldersPage.createFolder(data.getTestFolder());
        sharedFoldersPage.verifyNameIsPresentInTable(data.getTestFolder());
    }

    @Test(dependsOnMethods = "createAndOpenFolder", description = "Upload nested file in Company space > Shared folders")
    public void uploadNestedFile() {
        sharedFoldersPage.clickOnFolderInTable(data.getTestFolder());
        sharedFoldersPage.uploadFile(getAbsolutePath(data.getFileToUploadPath()));
        sharedFoldersPage.verifyNameIsPresentInTable(data.getTestFileName());
    }

    @Test(dependsOnMethods = "uploadNestedFile", description = "Edit nested file in Company space > Shared folders")
    public void editNestedFile() {
        sharedFoldersPage.editFileInfo(data.getTestFileName(), data.getTestInfo());
        sharedFoldersPage.verifyNameIsPresentInTable(data.getTestInfo());
    }

    @Test(dependsOnMethods = "editNestedFile", description = "Delete file in Company space > Shared folders")
    public void deleteFile() {
        sharedFoldersPage.navigateToSharedFolders();
        sharedFoldersPage.deleteFile(data.getTestFileName());
        sharedFoldersPage.verifyNameIsAbsentInTable(data.getTestFileName());
    }

    @Test(dependsOnMethods = "editNestedFile", description = "Delete folder in Company space > Shared folders")
    public void deleteFolder() {
        sharedFoldersPage.deleteFolder(data.getTestFolder());
        sharedFoldersPage.verifyNameIsAbsentInTable(data.getTestFolder());
    }

}
