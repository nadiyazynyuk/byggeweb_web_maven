package dk.byggeweb.objects.project.projectadministration.panels;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.project.ProjectHomePage;
import lombok.Getter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class ProjectAdministrationNodesPanel extends ProjectHomePage {

    private SelenideElement projectAdministrationParentNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Project administration')]"));
    private SelenideElement systemInformationNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'System Information')]"));
    private SelenideElement approvalNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Approval')]"));
    private SelenideElement backupOrdersNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Backup orders')]"));
    private SelenideElement printOrdersNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Print orders')]"));
    private SelenideElement groupsNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Groups')]"));
    private SelenideElement usersNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Users')]"));

    public ProjectAdministrationNodesPanel() {
        projectAdministrationParentNode.shouldBe(visible);
    }

}
