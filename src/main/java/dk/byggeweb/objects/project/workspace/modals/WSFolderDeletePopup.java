package dk.byggeweb.objects.project.workspace.modals;

import com.codeborne.selenide.WebDriverRunner;
import dk.byggeweb.objects.project.ModalBase;
import io.qameta.allure.Step;

public class WSFolderDeletePopup extends ModalBase {

    @Step("Delete folder")
    public void deleteFolder() {
        getOkButton().click();
        WebDriverRunner.getWebDriver().switchTo().alert().accept();
    }

}
