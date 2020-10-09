package dk.byggeweb.objects.project.communication.panels;

import com.codeborne.selenide.SelenideElement;

import dk.byggeweb.objects.project.ProjectHomePage;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class CommunicationNodesPanel extends ProjectHomePage {

    private final SelenideElement communicationParentNode = $(byXpath("//td[contains(@class, 'WMP_80')]"));
    private final SelenideElement messagesNode = $(byXpath("//td[contains(@class, 'WMP_81')]"));
    private final SelenideElement addressListNode = $(byXpath("//td[contains(@class, 'WMP_82')]"));
    private final SelenideElement projectHomepageNode = $(byXpath("//td[contains(@class, 'WMP_88')]"));

    @Step("Navigate to Messages")
    public void navigateToMessages() {
        messagesNode.click();
        new ComMessagesContentPanel();
    }

    @Step("Navigate to Address list")
    public void navigateToAddressList() {
        addressListNode.click();
        new ComAddressListContentPanel();
    }

    public CommunicationNodesPanel() {
        communicationParentNode.shouldBe(visible);
    }

}
