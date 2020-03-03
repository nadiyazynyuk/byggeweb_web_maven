package dk.byggeweb.objects.project.workspace.modals;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.project.ModalBase;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class WSFilePublishPopup extends ModalBase {

    private SelenideElement closeButton = $(byXpath("//input[@value='Close']"));

    private SelenideElement getFolderRadio(String folderName) {
        return $(byXpath("//td[contains(text(), '" + folderName + "')]/parent::tr/td/input"));
    }

    @Step("Publish new file to the folder in Document list")
    public void publishFile(String folderName) {
        getFolderRadio(folderName).click();
        getOkButton().click();
        getOkButton().click();
        closeButton.click();
    }

    @Step("Publish new file version")
    public void publishNewFileVersion() {
        getOkButton().click();
        closeButton.click();
    }
}
