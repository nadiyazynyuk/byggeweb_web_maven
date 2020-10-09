package dk.byggeweb.objects.project.distributionspace.modals;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.project.ModalBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class DSMonitorFolderPopup extends ModalBase {

    private final SelenideElement popupTitle = $(byXpath("//h1[text()='Monitor folder']"));

    public DSMonitorFolderPopup() {
        popupTitle.shouldBe(visible);
    }
}
