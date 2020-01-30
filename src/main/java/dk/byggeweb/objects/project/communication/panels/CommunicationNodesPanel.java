package dk.byggeweb.objects.project.communication.panels;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.project.ProjectHomePage;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class CommunicationNodesPanel extends ProjectHomePage {

    private SelenideElement communicationParentNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Communication')]"));

}
