package dk.byggeweb.project.workspace.files.upload;

import com.codeborne.selenide.Selenide;
import dk.byggeweb.infrastructure.test.ProjectTestBase;
import dk.byggeweb.objects.desktop.HomePage;
import dk.byggeweb.objects.desktop.personalspace.MyFoldersPage;
import dk.byggeweb.objects.desktop.personalspace.PersonalSpacePage;
import dk.byggeweb.objects.project.ProjectHomePage;
import dk.byggeweb.steps.GeneralSteps;
import io.qameta.allure.Link;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TransferSingleFile extends ProjectTestBase {

    private HomePage homePage;

    @Link(url = "https://itwofm.atlassian.net/browse/TSB-16")

    @BeforeClass
    public void prepareData() {
        Selenide.open("");
        homePage = GeneralSteps.loginAsVerifiedUser(data.getUserName(), data.getPassword(), data.getName());
        uploadFileInPersonalSpace(data.getTestFileName(), data.getFileToUploadPath());

        GeneralSteps.launchProject(data.getProjectLink());
        projectHomePage = new ProjectHomePage(data.getProjectName());
        projectHomePage.navigateToWorkspaceModule();
        wsFolderSteps.navigateToFolder(data.getFolderName());
        deleteFileIfPresentInWorkspaceFolder(data.getTestFileName());
    }

    @Test(description = "Transferal upload file into Project root folder")
    public void transferFile() {
        wsFileSteps.transferalUploadSingleFile(data.getTestFileName());
        wsFileSteps.verifyFileIsPresent(data.getTestFileName());
    }

    private void uploadFileInPersonalSpace(String fileName, String filePath) {
        homePage.navigateToPersonalSpace();
        PersonalSpacePage personalSpacePage = new PersonalSpacePage();
        personalSpacePage.navigateToMyFolders();
        MyFoldersPage myFoldersPage = new MyFoldersPage();
        try {
            myFoldersPage.verifyNameIsPresentInTable(fileName);
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            myFoldersPage.uploadFile(getAbsolutePath(filePath));
        }
        myFoldersPage.verifyNameIsPresentInTable(fileName);
    }

}
