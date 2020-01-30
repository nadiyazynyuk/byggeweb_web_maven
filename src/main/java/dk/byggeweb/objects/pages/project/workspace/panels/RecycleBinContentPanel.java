package dk.byggeweb.objects.pages.project.workspace.panels;

import dk.byggeweb.objects.pages.project.workspace.modals.FileDeletePopup;
import dk.byggeweb.objects.pages.project.workspace.modals.FileMovePopup;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;

public class RecycleBinContentPanel extends WorkspaceContentPanel {

    @Step("Delete file")
    public void deleteFile(String fileName) {
        clickOnFile(fileName);
        getFileDeleteButton().click();
        switchToNewWindow();
        FileDeletePopup fileDeletePopup = new FileDeletePopup();
        fileDeletePopup.deleteFilePermanently();
        switchToLastTab();
    }

    @Step("Restore file")
    public void restoreFile(String fileName, String folderName) {
        clickOnFile(fileName);
        getFileMoveButton().click();
        switchToNewWindow();
        FileMovePopup fileMovePopup = new FileMovePopup();
        fileMovePopup.moveFile(folderName);
        switchToLastTab();
        verifyFileIsNotPresent(fileName);
    }

    public RecycleBinContentPanel(String title) {
        getPanelTitle().shouldHave(text(title));
    }

}
