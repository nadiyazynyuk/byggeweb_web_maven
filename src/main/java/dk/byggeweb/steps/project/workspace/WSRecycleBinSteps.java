package dk.byggeweb.steps.project.workspace;

import dk.byggeweb.objects.project.workspace.modals.WSFileDeletePopup;
import dk.byggeweb.objects.project.workspace.modals.WSFileMovePopup;
import dk.byggeweb.objects.project.workspace.panels.WSFileInformationPanel;
import dk.byggeweb.objects.project.workspace.panels.WSRecycleBinContentPanel;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;

public class WSRecycleBinSteps {

    @Step("Select file")
    public void selectFile(String name) {
        WSRecycleBinContentPanel panel = new WSRecycleBinContentPanel();
        panel.getFileByName(name).click();
        new WSFileInformationPanel(name);
    }

    @Step("Delete file from Recycle bin")
    public void deleteFileFromRecycleBin(String fileName) {
        selectFile(fileName);
        WSRecycleBinContentPanel panel = new WSRecycleBinContentPanel();
        panel.getFileDeleteButton().click();
        panel.switchToNewWindow();
        WSFileDeletePopup wsFileDeletePopup = new WSFileDeletePopup();
        wsFileDeletePopup.deleteFilePermanently();
        panel.switchToLastTab();
    }

    @Step("Restore file from Recycle bin")
    public void restoreFile(String fileName, String folderName) {
        selectFile(fileName);
        WSRecycleBinContentPanel panel = new WSRecycleBinContentPanel();
        panel.getFileMoveButton().click();
        panel.switchToNewWindow();
        WSFileMovePopup wsFileMovePopup = new WSFileMovePopup();
        wsFileMovePopup.moveFile(folderName);
        panel.switchToLastTab();
        verifyFileIsNotPresent(fileName);
    }

    @Step("Verify file is not present in the list")
    public void verifyFileIsNotPresent(String name) {
        WSRecycleBinContentPanel panel = new WSRecycleBinContentPanel();
        panel.getFileByName(name).shouldNotBe(visible);
    }
}
