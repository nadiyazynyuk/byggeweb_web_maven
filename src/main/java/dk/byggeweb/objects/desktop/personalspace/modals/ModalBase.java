package dk.byggeweb.objects.desktop.personalspace.modals;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public abstract class ModalBase {

    private final SelenideElement iFrame = $(byXpath("//iframe[@id='window-iframe']"));
    private final SelenideElement okButton = $(byXpath("//button[@type='button' and contains(text(), 'OK')]"));

    @Step("Verify popup is loaded")
    public void verifyPopupIsLoaded(SelenideElement element) {
        element.should(visible);
    }

}
