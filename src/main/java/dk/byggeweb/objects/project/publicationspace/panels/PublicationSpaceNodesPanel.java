package dk.byggeweb.objects.project.publicationspace.panels;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.project.ProjectHomePage;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class PublicationSpaceNodesPanel extends ProjectHomePage {

    public DocumentListsContentPanel documentListsContentPanel;
    public VersionSetsContentPanel versionSetsContentPanel;
    public WaitingForApprovalPanel waitingForApprovalPanel;
    public RejectedFileVersionsPanel rejectedFileVersionsPanel;
    public UnpublishedFileVersionsPanel unpublishedFileVersionsPanel;
    public FilesNotDistributedPanel filesNotDistributedPanel;
    public RecentlyApprovedFileVersionsPanel recentlyApprovedFileVersionsPanel;
    public RecentlyPublishedFileVersionsPanel recentlyPublishedFileVersionsPanel;

    private SelenideElement publicationSpaceParentNode = $(byXpath("//td[contains(@class, 'WMP_20')]"));
    private SelenideElement rootDocumentListNode = $(byXpath("//td[contains(@class, 'WMP_21')]"));
    private SelenideElement versionSetsNode = $(byXpath("//td[contains(@class, 'WMP_140')]"));
    private SelenideElement waitingForApprovalNode = $(byXpath("//td[contains(@class, 'WMP_31')]"));
    private SelenideElement rejectedFileVersionsNode = $(byXpath("//td[contains(@class, 'WMP_32')]"));
    private SelenideElement unpublishedFileVersionsNode = $(byXpath("//td[contains(@class, 'WMP_33')]"));
    private SelenideElement filesNotDistributedNode = $(byXpath("//td[contains(@class, 'WMP_34')]"));
    private SelenideElement recentlyApprovedFileVersionsNode = $(byXpath("//td[contains(@class, 'WMP_35')]"));
    private SelenideElement recentlyPublishedFileVersionsNode = $(byXpath("//td[contains(@class, 'WMP_36')]"));
    private SelenideElement recentlyReleasedFileVersionsNode = $(byXpath("//td[contains(@class, 'WMP_37')]"));
    private SelenideElement monitoredFoldersNode = $(byXpath("//td[contains(@class, 'WMP_42')]"));
    private SelenideElement monitoredFilesNode = $(byXpath("//td[contains(@class, 'WMP_41')]"));
    private SelenideElement searchResultNode = $(byXpath("//td[contains(@class, 'WMP_38')]"));

    private SelenideElement getDocumentListByName(String name) {
        return $(By.xpath("//span[@class='x-tree-node-text ' and contains(text(), '" + name + "')]"));
    }

    @Step("Navigate to Root Document list")
    public void navigateToRootDocumentList() {
        rootDocumentListNode.click();
        documentListsContentPanel = new DocumentListsContentPanel();
    }

    @Step("Navigate to Document lists")
    public void navigateToVersionSets() {
        versionSetsNode.click();
        versionSetsContentPanel = new VersionSetsContentPanel();
    }

    @Step("Navigate to Waiting for approval")
    public void navigateToWaitingForApproval() {
        waitingForApprovalNode.click();
        waitingForApprovalPanel = new WaitingForApprovalPanel();
    }

    @Step("Navigate to Rejected file versions")
    public void navigateToRejectedFileVersions() {
        rejectedFileVersionsNode.click();
        rejectedFileVersionsPanel = new RejectedFileVersionsPanel();
    }

    @Step("Navigate to Unpublished file versions")
    public void navigateToUnpublishedFileVersions() {
        unpublishedFileVersionsNode.click();
        unpublishedFileVersionsPanel = new UnpublishedFileVersionsPanel();
    }

    @Step("Navigate to Files not distributed")
    public void navigateToFilesNotDistributed() {
        filesNotDistributedNode.click();
        filesNotDistributedPanel = new FilesNotDistributedPanel();
    }

    @Step("Navigate to Recently approved file versions")
    public void navigateToRecentlyApprovedFileVersions() {
        recentlyApprovedFileVersionsNode.click();
        recentlyApprovedFileVersionsPanel = new RecentlyApprovedFileVersionsPanel();
    }

    @Step("Navigate to Recently published file versions")
    public void navigateToRecentlyPublishedFileVersions() {
        recentlyPublishedFileVersionsNode.click();
        recentlyPublishedFileVersionsPanel = new RecentlyPublishedFileVersionsPanel();
    }

    public PublicationSpaceNodesPanel() {
        publicationSpaceParentNode.shouldBe(visible);
    }

}
