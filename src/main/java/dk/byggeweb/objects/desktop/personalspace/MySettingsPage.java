package dk.byggeweb.objects.desktop.personalspace;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.desktop.personalspace.modals.EditUserPopup;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class MySettingsPage extends PersonalSpacePage {

    private SelenideElement mySettingsLabel = $(byXpath("//*[@class='headline1-content' and contains(text(),'Settings')]"));
    private SelenideElement editSettingsButton = $(byXpath("//button[@class='desktop-btn' and contains(text(), 'Edit')]"));

    @Step("Change user name")
    public void changePersonalData(String data) {
        editSettingsButton.click();
        EditUserPopup editUserPopup = new EditUserPopup();
        switchToFrame(editUserPopup.getIFrame());
        editUserPopup.updateFirstName(data);
        switchToParentFrame();
        editUserPopup.getOkButton().click();
    }

}
