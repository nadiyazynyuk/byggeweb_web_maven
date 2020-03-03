package dk.byggeweb.objects.project.publicationspace.modals;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.project.ModalBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class PSFileInformationEditPopup extends ModalBase {

    private SelenideElement getFileByName(String filename) {
        return $(byXpath("//td/nobr[contains(text(), '" + filename + "')]"));
    }

    public PSFileInformationEditPopup(String fileName) {
        getFileByName(fileName).shouldBe(visible);
    }
}
