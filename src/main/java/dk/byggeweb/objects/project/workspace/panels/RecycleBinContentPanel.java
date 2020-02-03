package dk.byggeweb.objects.project.workspace.panels;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.project.workspace.modals.FileDeletePopup;
import dk.byggeweb.objects.project.workspace.modals.FileMovePopup;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class RecycleBinContentPanel extends WorkspaceContentPanel {

    private SelenideElement panelTitle = $(byXpath("//div[contains(@class, 'x-title-text x-title-text-default') and contains(text(), 'Recycle bin')]"));

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

    public RecycleBinContentPanel() {
        panelTitle.shouldBe(visible);
    }

}
