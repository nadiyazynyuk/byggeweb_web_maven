package dk.byggeweb.objects.project.publicationspace.modals;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.project.ModalBase;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class PSFolderCreatePopup extends ModalBase {

    private SelenideElement folderNameInput = $(byXpath("//input[@name='name']"));

    @Step("Create folder with name")
    public void createFolder(String name) {
        folderNameInput.setValue(name);
        getOkButton().click();
        pleaseWait(500);
        getNoButton().click();
    }

    @Step("Rename folder")
    public void renameFolder(String name) {
        folderNameInput.clear();
        folderNameInput.setValue(name);
        getOkButton().click();
        pleaseWait(500);
        getCloseButton().click();
    }

}
