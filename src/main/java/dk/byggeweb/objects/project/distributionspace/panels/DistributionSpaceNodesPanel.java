package dk.byggeweb.objects.project.distributionspace.panels;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.project.ProjectHomePage;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class DistributionSpaceNodesPanel extends ProjectHomePage {

    private SelenideElement distributionSpaceParentNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Distribution space')]"));
    private SelenideElement rootDistributionListNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Distribution lists')]"));
    private SelenideElement versionSetsNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Version sets')]"));
    private SelenideElement recipientsNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Recipients')]"));
    private SelenideElement invitedUsersNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Invited users')]"));
    private SelenideElement recentlyReleasedFileVersionsNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Recently released file versions')]"));
    private SelenideElement printDistributionExceptionsNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Print distribution exceptions')]"));
    private SelenideElement monitoredFoldersNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Monitored folders')]"));
    private SelenideElement monitoredFilesNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Monitored files')]"));
    private SelenideElement searchResultNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Search')]"));

    private SelenideElement getDistributionListByName(String name) {
        return $(By.xpath("//span[@class='x-tree-node-text ' and contains(text(), '" + name + "')]"));
    }

    public DistributionSpaceNodesPanel() {
        distributionSpaceParentNode.shouldBe(visible);
    }
}
