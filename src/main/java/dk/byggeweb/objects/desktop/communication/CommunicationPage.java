package dk.byggeweb.objects.desktop.communication;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.desktop.HomePage;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class CommunicationPage extends HomePage {

    private SelenideElement notificationsLink = $(byXpath("//*[@id='notifications']"));
    private SelenideElement messagesLink = $(byXpath("//*[@id='messages']"));

    @Step("Click on Notifications link")
    public void clickOnNotifications() {
        notificationsLink.click();
    }

    @Step("Click on Messages link")
    public void clickOnMessages() {
        messagesLink.click();
    }
}
