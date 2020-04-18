package dk.byggeweb.desktop.authorization;

import com.codeborne.selenide.Selenide;
import dk.byggeweb.infrastructure.test.DesktopTestBase;
import dk.byggeweb.objects.desktop.authorization.LoginPage;
import io.qameta.allure.Link;
import org.testng.annotations.Test;

public class Logoff extends DesktopTestBase {

    @Link(url = "https://itwofm.atlassian.net/browse/TSB-84")

    @Test(description = "Logoff from Byggeweb desktop")
    public void logoff() {
        homePage.getLogoffButton().click();
        Selenide.open("");
        new LoginPage();
    }
}
