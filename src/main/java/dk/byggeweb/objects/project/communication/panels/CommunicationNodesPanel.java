package dk.byggeweb.objects.project.communication.panels;

import com.codeborne.selenide.SelenideElement;

import dk.byggeweb.objects.project.ProjectHomePage;
import lombok.Getter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class CommunicationNodesPanel extends ProjectHomePage {

    private SelenideElement communicationParentNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Communication')]"));
    private SelenideElement messagesNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Messages')]"));
    private SelenideElement addressListNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Address list')]"));
    private SelenideElement projectHomepageNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Project homepage')]"));

    public CommunicationNodesPanel() {
        communicationParentNode.shouldBe(visible);
    }

}
