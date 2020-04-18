package dk.byggeweb.desktop.personalspace;

import dk.byggeweb.infrastructure.test.DesktopTestBase;
import dk.byggeweb.objects.desktop.personalspace.MyFoldersPage;
import dk.byggeweb.objects.desktop.personalspace.PersonalSpacePage;
import io.qameta.allure.Link;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UploadNewFileVersion extends DesktopTestBase {

    private MyFoldersPage myFoldersPage;

    @Link(url = "https://itwofm.atlassian.net/browse/TSB-7")

    @BeforeClass
    public void deleteFileIfExist() {
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
    }

    @Test(description = "Upload file in Personal space > My folders")
    public void uploadFile() {
        myFoldersPage.uploadFile(getAbsolutePath(data.getFileToUploadPath()));
        myFoldersPage.verifyNameAndVersionIsCorrect(data.getTestFileName(), data.getFirstVersion());
    }

    @Test(dependsOnMethods = "uploadFile", description = "Upload new file version in Personal space > My folders")
    public void uploadNewFileVersion() {
        myFoldersPage.uploadFile(getAbsolutePath(data.getFileToUploadPath()));
        myFoldersPage.verifyNameAndVersionIsCorrect(data.getTestFileName(), data.getSecondVersion());
    }
}
