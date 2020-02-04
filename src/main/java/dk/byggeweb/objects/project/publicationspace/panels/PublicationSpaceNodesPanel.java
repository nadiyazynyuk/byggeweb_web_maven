package dk.byggeweb.objects.project.publicationspace.panels;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.project.ProjectHomePage;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class PublicationSpaceNodesPanel extends ProjectHomePage {

    private SelenideElement publicationSpaceParentNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Publication space')]"));
    private SelenideElement rootDocumentListNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Document lists')]"));
    private SelenideElement versionSetsNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Version sets')]"));
    private SelenideElement waitingForApprovalNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Waiting for approval')]"));
    private SelenideElement rejectedFileVersionsNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Rejected file versions')]"));
    private SelenideElement unpublishedFileVersionsNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Unpublished file versions')]"));
    private SelenideElement filesNotDistributedNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Files not distributed')]"));
    private SelenideElement recentlyApprovedFileVersionsNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Recently approved file versions')]"));
    private SelenideElement recentlyPublishedFileVersionsNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Recently published file versions')]"));
    private SelenideElement recentlyReleasedFileVersionsNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Recently released file versions')]"));
    private SelenideElement monitoredFoldersNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Monitored folders')]"));
    private SelenideElement monitoredFilesNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Monitored files')]"));
    private SelenideElement searchResultNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Search')]"));

    private SelenideElement getDocumentListByName(String name) {
        return $(By.xpath("//span[@class='x-tree-node-text ' and contains(text(), '" + name + "')]"));
    }

    public PublicationSpaceNodesPanel() {
        publicationSpaceParentNode.shouldBe(visible);
    }

}
