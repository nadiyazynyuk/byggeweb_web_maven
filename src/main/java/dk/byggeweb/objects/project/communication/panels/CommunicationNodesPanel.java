package dk.byggeweb.objects.project.communication.panels;

import com.codeborne.selenide.SelenideElement;

import dk.byggeweb.objects.project.ProjectHomePage;
import lombok.Getter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class CommunicationNodesPanel extends ProjectHomePage {

    private SelenideElement communicationParentNode = $(byXpath("//td[contains(@class, 'WMP_80')]"));
    private SelenideElement messagesNode = $(byXpath("//td[contains(@class, 'WMP_81')]"));
    private SelenideElement addressListNode = $(byXpath("//td[contains(@class, 'WMP_82')]"));
    private SelenideElement projectHomepageNode = $(byXpath("//td[contains(@class, 'WMP_88')]"));

    public CommunicationNodesPanel() {
        communicationParentNode.shouldBe(visible);
    }

}
