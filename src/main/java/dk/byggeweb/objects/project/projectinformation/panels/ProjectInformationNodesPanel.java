package dk.byggeweb.objects.project.projectinformation.panels;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.project.ProjectHomePage;
import lombok.Getter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class ProjectInformationNodesPanel extends ProjectHomePage {

    private SelenideElement projectInformationParentNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Project information')]"));
    private SelenideElement projectNameAndDescriptionNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Project name and description')]"));
    private SelenideElement administratorsNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Administrators')]"));
    private SelenideElement areasOfResponsibilityNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Areas of responsibility')]"));

    public ProjectInformationNodesPanel() {
        projectInformationParentNode.shouldBe(visible);
    }
}
