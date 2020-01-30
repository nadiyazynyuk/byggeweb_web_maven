package dk.byggeweb.objects.desktop.authorization;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private SelenideElement usernameInput = $(byId("user"));
    private SelenideElement passwordInput = $(byId("xxx"));
    private SelenideElement loginButton = $(byId("submit"));
    private SelenideElement errorMessageLabel = $(byXpath("//div[@class='error']/p"));
    private SelenideElement forgottenPasswordButton = $(byXpath("//form[@name='login']/parent::div/p[1]/a"));

    @Step("Perform login")
    public void login(String username, String password) {
        usernameInput.setValue(username);
        passwordInput.setValue(password);
        loginButton.click();
    }

    @Step("Verify error message is displayed")
    public void verifyErrorMessage(String error) {
        errorMessageLabel.shouldHave(Condition.text(error));
    }

    @Step("Navigate to Request password page")
    public void navigateToRequestPasswordPage() {
        forgottenPasswordButton.click();
    }

}
