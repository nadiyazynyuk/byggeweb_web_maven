package dk.byggeweb.objects.desktop.companyspace.modals;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public abstract class ModalBase {

    private SelenideElement iFrame = $(byXpath("//iframe[@id='window-iframe']"));
    private SelenideElement okButton = $(byXpath("//button[@type='button' and contains(text(), 'OK')]"));
    private SelenideElement deleteButton = $(byXpath("//button[@type='button' and contains(text(), 'Delete')]"));

    @Step("Verify popup is loaded")
    public void verifyPopupIsLoaded(SelenideElement element) {
        element.should(visible);
    }

}
