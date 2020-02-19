package dk.byggeweb.objects.project.publicationspace.modals;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import dk.byggeweb.objects.project.common.modals.ModalBase;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class PSFileDeletePopup extends ModalBase {

    private SelenideElement discontinueFileRadio = $(byXpath("//input[@value='doclisting.file.discontinue']"));
    private SelenideElement deleteFileRadio = $(byXpath("//input[@value='doclisting.file.delete']"));

    @Step("Discontinue file")
    public void discontinueFile() {
        discontinueFileRadio.click();
        getOkButton().click();
        getCloseButton().click();
    }

    @Step("Delete file permanently")
    public void deleteFilePermanently() {
        deleteFileRadio.click();
        getOkButton().click();
        WebDriverRunner.getWebDriver().switchTo().alert().accept();
        getCloseButton().click();
    }


}
