package dk.byggeweb.objects.project.workspace.modals;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class FileDeletePopup extends ModalBase {

    private SelenideElement permanentDeleteRadio = $(byXpath("//input[@value=0]"));
    private SelenideElement moveToRecycleBinRadio = $(byXpath("//input[@value=1]"));
    private SelenideElement closeWindowButton = $(byXpath("//input[@value='Close window']"));

    @Step("Delete file permanently")
    public void deleteFilePermanently() {
        permanentDeleteRadio.click();
        getOkButton().click();
        closeWindowButton.click();
    }

    @Step("Move file to Recycle bin")
    public void moveFileToRecycleBin() {
        moveToRecycleBinRadio.click();
        getOkButton().click();
        closeWindowButton.click();
    }
}
