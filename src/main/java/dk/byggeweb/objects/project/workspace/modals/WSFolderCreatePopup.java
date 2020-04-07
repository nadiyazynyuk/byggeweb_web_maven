package dk.byggeweb.objects.project.workspace.modals;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.project.ModalBase;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class WSFolderCreatePopup extends ModalBase {

    private SelenideElement nameInput = $(byXpath("//input[@name='directoryname']"));

    @Step("Create folder with name")
    public void createFolder(String name) {
        nameInput.setValue(name);
        getOkButton().click();
        getCloseButton().click();
    }

    @Step("Rename folder")
    public void renameFolder(String name) {
        nameInput.clear();
        nameInput.setValue(name);
        getOkButton().click();
        getCloseButton().click();
    }

}
