package dk.byggeweb.desktop.authorization;

import com.codeborne.selenide.Selenide;
import dk.byggeweb.infrastructure.test.DesktopTestBase;
import dk.byggeweb.objects.desktop.HomePage;
import dk.byggeweb.objects.desktop.authorization.LoginPage;
import dk.byggeweb.objects.desktop.authorization.RequestPasswordPage;
import io.qameta.allure.Link;
import org.testng.annotations.Test;

public class Login extends DesktopTestBase {

    @Link(url = "https://itwofm.atlassian.net/browse/TSB-17")
    @Test(description = "Login in Byggeweb desktop")
    public void loginAsValidUser() {
        Selenide.open("");
        LoginPage loginPage = new LoginPage();
        loginPage.login(data.getUserName(), data.getPassword());
        new HomePage(data.getName());
    }

    @Link(url = "https://itwofm.atlassian.net/browse/TSB-18")
    @Test(description = "Login with invalid username")
    public void loginWithInvalidUsername() {
        Selenide.open("");
        LoginPage loginPage = new LoginPage();
        loginPage.login(data.getInvalidUsername(), data.getPassword());
        loginPage.verifyErrorMessage("You have entered the wrong username or password.");
    }

    @Link(url = "https://itwofm.atlassian.net/browse/TSB-18")
    @Test(description = "Login with invalid password")
    public void loginWithInvalidPassword() {
        Selenide.open("");
        LoginPage loginPage = new LoginPage();
        loginPage.login(data.getUserName(), data.getInvalidPassword());
        loginPage.verifyErrorMessage("You have entered the wrong username or password.");
    }

    @Link(url = "https://itwofm.atlassian.net/browse/TSB-19")
    @Test(description = "Request new password")
    public void requestPassword() {
        Selenide.open("");
        LoginPage loginPage = new LoginPage();
        loginPage.navigateToRequestPasswordPage();
        RequestPasswordPage requestPasswordPage = new RequestPasswordPage();
        requestPasswordPage.requestPassword(data.getUserName());
        requestPasswordPage.verifyRequestSent();
    }

}
