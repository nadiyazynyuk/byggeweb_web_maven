package dk.byggeweb.objects.project.publicationspace.modals;

import com.codeborne.selenide.WebDriverRunner;
import dk.byggeweb.objects.project.ModalBase;

public class PSListDeletePopup extends ModalBase {

    public void deleteList() {
        getDeleteButton().click();
        WebDriverRunner.getWebDriver().switchTo().alert().accept();
        getCloseButton().click();
    }
}
