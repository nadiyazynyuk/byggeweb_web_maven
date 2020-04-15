package dk.byggeweb.objects.project.distributionspace.modals;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.project.ModalBase;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class DSFileDistributionPopup extends ModalBase {

    private SelenideElement getFileCheckbox(String fileName) {
        return $(byXpath("//td[contains(text(), '" + fileName + "')]/parent::tr/td/input"));
    }

    @Step("Distribute file")
    public void distributeFile(String fileName) {
        getFileCheckbox(fileName).click();
        getOkButton().click();
    }

}
