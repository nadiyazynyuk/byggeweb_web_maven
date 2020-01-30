package dk.byggeweb.objects.pages.desktop.authorization;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class RequestPasswordPage {

    private SelenideElement requestPasswordButton = $(byXpath("//button[contains(text(), 'Request new password')]"));
    private SelenideElement emailTextBox = $(byXpath("//input[contains(@id, 'email')]"));
    private SelenideElement requestSentLabel = $(byXpath("//*[contains(text(),'Request sent')]"));

    @Step("Request new password")
    public void requestPassword(String username) {
        emailTextBox.setValue(username);
        requestPasswordButton.click();
    }

    @Step("Verify request sent message is displayed")
    public void verifyRequestSent() {
        requestSentLabel.isDisplayed();
    }
}
