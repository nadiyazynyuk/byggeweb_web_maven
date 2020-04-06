package dk.byggeweb.objects.project.publicationspace.modals;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.project.ModalBase;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class PSFileMovePopup extends ModalBase {

    private SelenideElement getFolderCheckbox(String name) {
        return $(byXpath("//td[contains(text(), '" + name + "')]/parent::tr/td/input[@type='radio']"));
    }

    @Step("Move file to the folder")
    public void moveFile(String folderName) {
        getNextButton().click();
        getFolderCheckbox(folderName).click();
        getOkButton().click();
        getCloseButton().click();
    }
}
