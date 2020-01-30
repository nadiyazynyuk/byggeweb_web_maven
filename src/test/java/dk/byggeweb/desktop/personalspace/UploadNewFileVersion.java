package dk.byggeweb.desktop.personalspace;

import dk.byggeweb.infrastructure.steps.GeneralSteps;
import dk.byggeweb.infrastructure.test.DesktopTestBase;
import dk.byggeweb.objects.desktop.HomePage;
import dk.byggeweb.objects.desktop.personalspace.MyFoldersPage;
import dk.byggeweb.objects.desktop.personalspace.PersonalSpacePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UploadNewFileVersion extends DesktopTestBase {

    // https://itwofm.atlassian.net/browse/TSB-7

    private MyFoldersPage myFoldersPage;

    @BeforeClass
    public void deleteFileIfExist() {
        HomePage homePage = GeneralSteps.loginAsVerifiedUser(data.getUserName(), data.getPassword(), data.getName());
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
