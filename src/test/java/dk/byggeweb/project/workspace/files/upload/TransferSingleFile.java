package dk.byggeweb.project.workspace.files.upload;

import dk.byggeweb.infrastructure.steps.GeneralSteps;
import dk.byggeweb.infrastructure.test.ProjectTestBase;
import dk.byggeweb.objects.pages.desktop.HomePage;
import dk.byggeweb.objects.pages.desktop.personalspace.MyFoldersPage;
import dk.byggeweb.objects.pages.desktop.personalspace.PersonalSpacePage;
import dk.byggeweb.objects.pages.project.ProjectHomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TransferSingleFile extends ProjectTestBase {

    // https://itwofm.atlassian.net/browse/TSB-16

    private HomePage homePage;

    @BeforeClass
    public void prepareData() {
        homePage = GeneralSteps.loginAsVerifiedUser(data.getUserName(), data.getPassword(), data.getName());
        uploadFileInPersonalSpace(data.getTestFileName(), data.getFileToUploadPath());

        GeneralSteps.launchProject(data.getProjectLink());
        projectHomePage = new ProjectHomePage(data.getProjectName());
        projectHomePage.navigateToWorkspaceModule();
        deleteFileIfPresentInWorkspaceFolder(data.getFolderName(), data.getTestFileName());
    }

    @Test(description = "Transferal upload file into Project root folder")
    public void transferFile() {
        workspaceContentPanel.transferalUploadSingleFile(data.getTestFileName());
        workspaceContentPanel.verifyFileIsPresent(data.getTestFileName());
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
