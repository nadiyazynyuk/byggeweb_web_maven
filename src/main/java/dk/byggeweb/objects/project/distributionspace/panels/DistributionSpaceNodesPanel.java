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

    private SelenideElement distributionSpaceParentNode = $(byXpath("//td[contains(@class, 'WMP_50')]"));
    private SelenideElement rootDistributionListNode = $(byXpath("//td[contains(@class, 'WMP_51')]"));
    private SelenideElement versionSetsNode = $(byXpath("//td[contains(@class, 'WMP_140')]"));
    private SelenideElement recipientsNode = $(byXpath("//td[contains(@class, 'WMP_61')]"));
    private SelenideElement invitedUsersNode = $(byXpath("//td[contains(@class, 'WMP_62')]"));
    private SelenideElement recentlyReleasedFileVersionsNode = $(byXpath("//td[contains(@class, 'WMP_63')]"));
    private SelenideElement printDistributionExceptionsNode = $(byXpath("//td[contains(@class, 'WMP_64')]"));
    private SelenideElement monitoredFoldersNode = $(byXpath("//td[contains(@class, 'WMP_73')]"));
    private SelenideElement monitoredFilesNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Monitored files')]"));
//    private SelenideElement monitoredFilesNode = $(byXpath("//td[contains(@class, 'WMP_73')]"));
    private SelenideElement searchResultNode = $(byXpath("//td[contains(@class, 'WMP_68')]"));

    private SelenideElement getDistributionListByName(String name) {
        return $(By.xpath("//span[@class='x-tree-node-text ' and contains(text(), '" + name + "')]"));
    }

    public DistributionSpaceNodesPanel() {
        distributionSpaceParentNode.shouldBe(visible);
    }
}
