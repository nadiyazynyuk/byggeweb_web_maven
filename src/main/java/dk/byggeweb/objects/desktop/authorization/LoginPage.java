package dk.byggeweb.objects.desktop.authorization;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private final SelenideElement usernameInput = $(byXpath("//input[@id='user']"));
    private final SelenideElement passwordInput = $(byXpath("//input[@id='xxx']"));
    private final SelenideElement loginButton = $(byXpath("//input[@id='submit']"));
    private final SelenideElement errorMessageLabel = $(byXpath("//div[@class='error']/p"));
    private final SelenideElement forgottenPasswordButton = $(byXpath("//form[@name='login']/parent::div/p[1]/a"));

    @Step("Perform login")
    public void login(String username, String password) {
        usernameInput.setValue(username);
        passwordInput.setValue(password);
        loginButton.click();
    }

    @Step("Verify error message is displayed")
    public void verifyErrorMessage(String error) {
        errorMessageLabel.shouldHave(text(error));
    }

    @Step("Navigate to Request password page")
    public void navigateToRequestPasswordPage() {
        forgottenPasswordButton.click();
    }

    public LoginPage() {
        usernameInput.shouldBe(visible);
    }

}
