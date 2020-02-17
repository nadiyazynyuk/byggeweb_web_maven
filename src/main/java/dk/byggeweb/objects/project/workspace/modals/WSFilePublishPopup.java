package dk.byggeweb.objects.project.workspace.modals;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class WSFilePublishPopup extends WSModalBase {

    private SelenideElement closeButton = $(byXpath("//input[@value='Close']"));

    private SelenideElement getFolderRadio(String folderName) {
        return $(byXpath("//td[contains(text(), '" + folderName + "')]/parent::tr/td/input"));
    }

    @Step("Publish new file version")
    public void publishFile(String folderName) {
        getFolderRadio(folderName).click();
        getOkButton().click();
        getOkButton().click();
        closeButton.click();
    }
}
