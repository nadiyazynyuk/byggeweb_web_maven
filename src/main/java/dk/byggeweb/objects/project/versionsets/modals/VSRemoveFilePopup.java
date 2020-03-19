package dk.byggeweb.objects.project.versionsets.modals;

import com.codeborne.selenide.WebDriverRunner;
import dk.byggeweb.objects.project.ModalBase;
import io.qameta.allure.Step;

public class VSRemoveFilePopup extends ModalBase {

    @Step("Remove file")
    public void removeFile() {
        getOkButton().click();
        WebDriverRunner.getWebDriver().switchTo().alert().accept();
    }
}
