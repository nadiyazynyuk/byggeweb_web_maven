package dk.byggeweb.steps.project.workspace;

import dk.byggeweb.objects.project.workspace.modals.FileDeletePopup;
import dk.byggeweb.objects.project.workspace.modals.FileMovePopup;
import dk.byggeweb.objects.project.workspace.panels.FileInformationPanel;
import dk.byggeweb.objects.project.workspace.panels.RecycleBinContentPanel;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;

public class RecycleBinSteps {

    @Step("Select file")
    public void selectFile(String name) {
        RecycleBinContentPanel panel = new RecycleBinContentPanel();
        panel.getFileByName(name).click();
        new FileInformationPanel(name);
    }

    @Step("Delete file from Recycle bin")
    public void deleteFileFromRecycleBin(String fileName) {
        selectFile(fileName);
        RecycleBinContentPanel panel = new RecycleBinContentPanel();
        panel.getFileDeleteButton().click();
        panel.switchToNewWindow();
        FileDeletePopup fileDeletePopup = new FileDeletePopup();
        fileDeletePopup.deleteFilePermanently();
        panel.switchToLastTab();
    }

    @Step("Restore file from Recycle bin")
    public void restoreFile(String fileName, String folderName) {
        selectFile(fileName);
        RecycleBinContentPanel panel = new RecycleBinContentPanel();
        panel.getFileMoveButton().click();
        panel.switchToNewWindow();
        FileMovePopup fileMovePopup = new FileMovePopup();
        fileMovePopup.moveFile(folderName);
        panel.switchToLastTab();
        verifyFileIsNotPresent(fileName);
    }

    @Step("Verify file is not present in the list")
    public void verifyFileIsNotPresent(String name) {
        RecycleBinContentPanel panel = new RecycleBinContentPanel();
        panel.getFileByName(name).shouldNotHave(text(name));
    }
}
