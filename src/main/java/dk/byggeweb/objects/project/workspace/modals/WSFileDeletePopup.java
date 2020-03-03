package dk.byggeweb.objects.project.workspace.modals;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.project.ModalBase;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class WSFileDeletePopup extends ModalBase {

    private SelenideElement permanentDeleteRadio = $(byXpath("//input[@value=0]"));
    private SelenideElement moveToRecycleBinRadio = $(byXpath("//input[@value=1]"));

    @Step("Delete file permanently")
    public void deleteFilePermanently() {
        permanentDeleteRadio.click();
        getOkButton().click();
        getCloseButton().click();
    }

    @Step("Move file to Recycle bin")
    public void moveFileToRecycleBin() {
        moveToRecycleBinRadio.click();
        getOkButton().click();
        getCloseButton().click();
    }
}
