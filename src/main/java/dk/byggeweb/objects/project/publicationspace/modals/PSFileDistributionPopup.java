package dk.byggeweb.objects.project.publicationspace.modals;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.project.ModalBase;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class PSFileDistributionPopup extends ModalBase {

    private SelenideElement getListCheckbox(String distributionListName) {
        return $(byXpath("//div[contains(text(), '" + distributionListName + "')]/parent::div/parent::td/parent::tr/td/div/div/input"));
    }

    @Step("Distribute file")
    public void distributeFile(String distributionListName) {
        getListCheckbox(distributionListName).click();
        getOkButton().click();
        getOkButton().click();
    }
}
