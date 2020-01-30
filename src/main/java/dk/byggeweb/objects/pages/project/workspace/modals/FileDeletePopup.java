package dk.byggeweb.objects.pages.project.workspace.modals;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class FileDeletePopup extends ModalBase {

    private SelenideElement permanentDeleteRadio = $(By.xpath("//input[@value=0]"));
    private SelenideElement moveToRecycleBinRadio = $(By.xpath("//input[@value=1]"));
    private SelenideElement closeWindowButton = $(By.xpath("//input[@value='Close window']"));

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
