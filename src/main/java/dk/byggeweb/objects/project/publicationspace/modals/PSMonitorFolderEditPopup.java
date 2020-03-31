package dk.byggeweb.objects.project.publicationspace.modals;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.project.ModalBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class PSMonitorFolderEditPopup extends ModalBase {

    private SelenideElement popupTitle = $(byXpath("//h1[text()='Edit folder monitoring']"));

    public PSMonitorFolderEditPopup() {
        popupTitle.shouldBe(visible);
    }
}
