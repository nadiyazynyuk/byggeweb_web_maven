package dk.byggeweb.objects.project.distributionspace.modals;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.project.ModalBase;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class DSDocumentListAssociatingPopup extends ModalBase {

    private SelenideElement getDocumentListCheckbox(String documentListName) {
        return $(byXpath("//td[contains(text(), '" + documentListName + "')]/parent::tr/td/input"));
    }

    @Step("Associate Distribution list with Document list")
    public void associateList(String documentListName) {
        getDocumentListCheckbox(documentListName).click();
        getOkButton().click();
        pleaseWait(1000);
    }
}
