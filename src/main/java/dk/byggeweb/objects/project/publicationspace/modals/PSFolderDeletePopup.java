package dk.byggeweb.objects.project.publicationspace.modals;

import com.codeborne.selenide.WebDriverRunner;
import dk.byggeweb.objects.project.ModalBase;
import io.qameta.allure.Step;

public class PSFolderDeletePopup extends ModalBase {

    @Step("Delete folder")
    public void deleteFolder() {
        getOkButton().click();
        WebDriverRunner.getWebDriver().switchTo().alert().accept();
        pleaseWait(1500);
        getCloseButton().click();
    }

}
