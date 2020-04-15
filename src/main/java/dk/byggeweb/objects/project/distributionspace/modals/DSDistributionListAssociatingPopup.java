package dk.byggeweb.objects.project.distributionspace.modals;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.project.ModalBase;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class DSDistributionListAssociatingPopup extends ModalBase {

    private SelenideElement getDistributionListCheckbox(String distributionListName) {
        return $(byXpath("//div[@class='cell-container' and contains(text(), '" + distributionListName + "')]/parent::div/parent::td/parent::tr/td//input"));
    }

    @Step("Associate Distribution list with Distribution list")
    public void associateList(String distributionListName) {
        getDistributionListCheckbox(distributionListName).click();
        getOkButton().click();
        pleaseWait(1000);
    }

}
