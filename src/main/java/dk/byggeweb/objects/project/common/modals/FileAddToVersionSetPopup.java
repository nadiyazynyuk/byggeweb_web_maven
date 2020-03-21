package dk.byggeweb.objects.project.common.modals;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.project.ModalBase;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class FileAddToVersionSetPopup extends ModalBase {

    private SelenideElement getVersionSetCheckbox(String name) {
        return $(byXpath("//td[contains(text(), '" + name + "')]/parent::tr/td/input[@type='checkbox']"));
    }

    @Step("Add file to version set")
    public void addFileToVersionSet(String versionSetName) {
        getVersionSetCheckbox(versionSetName).click();
        getNextButton().click();
        getOkButton().click();
    }

}
