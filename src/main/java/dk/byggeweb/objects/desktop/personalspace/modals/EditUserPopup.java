package dk.byggeweb.objects.desktop.personalspace.modals;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class EditUserPopup extends ModalBase {

    private final SelenideElement firstNameInput = $(byXpath("//*[@name='User__FirstName']"));

    @Step()
    public void updateFirstName(String data) {
        firstNameInput.clear();
        firstNameInput.setValue(data);
    }
}
