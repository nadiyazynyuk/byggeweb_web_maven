package dk.byggeweb.objects.project.versionsets.modals;

import com.codeborne.selenide.WebDriverRunner;
import dk.byggeweb.objects.project.ModalBase;
import io.qameta.allure.Step;

public class VSDeletePopup extends ModalBase {

    @Step("Delete Version set")
    public void deleteVersionSet() {
        getOkButton().click();
        WebDriverRunner.getWebDriver().switchTo().alert().accept();
    }
}
