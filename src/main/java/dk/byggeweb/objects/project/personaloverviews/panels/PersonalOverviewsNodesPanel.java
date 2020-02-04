package dk.byggeweb.objects.project.personaloverviews.panels;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.project.ProjectHomePage;
import lombok.Getter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class PersonalOverviewsNodesPanel extends ProjectHomePage {

    private SelenideElement personalOverviewsParentNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Personal overviews')]"));
    private SelenideElement projectSettingsNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Project settings')]"));
    private SelenideElement printOrdersNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Print orders')]"));
    private SelenideElement userLogNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'User log')]"));
    private SelenideElement backupOrdersNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Backup orders')]"));

    public PersonalOverviewsNodesPanel() {
        personalOverviewsParentNode.shouldBe(visible);
    }

}
