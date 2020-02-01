package dk.byggeweb.desktop.companyspace;

import dk.byggeweb.infrastructure.test.DesktopTestBase;
import dk.byggeweb.objects.desktop.companyspace.CompanySpacePage;
import dk.byggeweb.objects.desktop.companyspace.SharedFoldersPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UploadNewFileVersion extends DesktopTestBase {

    // https://itwofm.atlassian.net/browse/TSB-6

    private SharedFoldersPage sharedFoldersPage;

    @BeforeClass
    public void deleteFileIfExist() {
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
    }

    @Test(description = "Upload file in Company space > Shared folders")
    public void uploadFile() {
        sharedFoldersPage.uploadFile(getAbsolutePath(data.getFileToUploadPath()));
        sharedFoldersPage.verifyNameAndVersionIsCorrect(data.getTestFileName(), data.getFirstVersion());
    }

    @Test(dependsOnMethods = "uploadFile", description = "Upload new file version in Company space > Shared folders")
    public void uploadNewFileVersion() {
        sharedFoldersPage.uploadFile(getAbsolutePath(data.getFileToUploadPath()));
        sharedFoldersPage.verifyNameAndVersionIsCorrect(data.getTestFileName(), data.getSecondVersion());
    }
}
