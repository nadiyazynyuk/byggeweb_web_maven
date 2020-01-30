package dk.byggeweb.objects.project.workspace.modals;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class FolderCreatePopup extends ModalBase {

    private SelenideElement folderNameInput = $(byXpath("//input[@name='directoryname']"));

    @Step("Create folder with name")
    public void createFolder(String name) {
        folderNameInput.setValue(name);
        getOkButton().click();
        getCloseButton().click();
    }

    @Step("Rename folder")
    public void renameFolder(String name) {
        folderNameInput.clear();
        folderNameInput.setValue(name);
        getOkButton().click();
        getCloseButton().click();
    }

}
