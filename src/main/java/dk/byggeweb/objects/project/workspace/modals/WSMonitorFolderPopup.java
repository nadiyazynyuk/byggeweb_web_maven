package dk.byggeweb.objects.project.workspace.modals;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.project.ModalBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class WSMonitorFolderPopup extends ModalBase {

    private SelenideElement popupTitle = $(byXpath("//h1[text()='Monitor folder']"));

    public WSMonitorFolderPopup() {
        popupTitle.shouldBe(visible);
    }
}
