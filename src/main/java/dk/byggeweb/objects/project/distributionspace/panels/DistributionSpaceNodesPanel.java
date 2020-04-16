package dk.byggeweb.objects.project.distributionspace.panels;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.project.ProjectHomePage;
import dk.byggeweb.objects.project.versionsets.panels.VersionSetsOverviewPanel;
import io.qameta.allure.Step;
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
    private SelenideElement monitoredFilesNode = $(byXpath("//td[contains(@class, 'WMP_74')]"));
    private SelenideElement searchResultNode = $(byXpath("//td[contains(@class, 'WMP_68')]"));

    public SelenideElement getDistributionListNodeByName(String name) {
        return $(By.xpath("//span[@class='x-tree-node-text ' and contains(text(), '" + name + "')]"));
    }

    private SelenideElement createDistributionListButton = $(byXpath("//span[@data-locator='locator-btn-distlist_create']"));
    private SelenideElement editDistributionListButton = $(byXpath("//span[@data-locator='locator-btn-distlist_edit']"));
    private SelenideElement deleteDistributionListButton = $(byXpath("//span[@data-locator='locator-btn-distlist_delete']"));
    private SelenideElement associateDocumentListButton = $(byXpath("//span[@data-locator='locator-btn-distlist_set_doclist']"));
    private SelenideElement associateDistributionListButton = $(byXpath("//span[@data-locator='locator-btn-distlist_set_distr']"));
    private SelenideElement monitorFolderButton = $(byXpath("//span[@data-locator='locator-btn-distlist_watch_dir']"));
    private SelenideElement quickSearchInput = $(byXpath("//input[contains(@id, 'textfield')]"));

    @Step("Navigate to Root Distribution list")
    public void navigateToRootDistributionList() {
        rootDistributionListNode.click();
        new DSDistributionListsContentPanel();
    }

    @Step("Navigate to Version sets")
    public void navigateToVersionSets() {
        versionSetsNode.click();
        new VersionSetsOverviewPanel();
    }

    @Step("Navigate to Recipients")
    public void navigateToRecipients() {
        recipientsNode.click();
        new DSRecipientsContentPanel();
    }

    @Step("Navigate to Invited users")
    public void navigateToInvitedUsers() {
        invitedUsersNode.click();
        new DSInvitedUsersContentPanel();
    }

    @Step("Navigate to Recently released file versions")
    public void navigateToRecentlyReleasedFileVersions() {
        recentlyReleasedFileVersionsNode.click();
        new DSRecentlyReleasedFileVersionsPanel();
    }

    @Step("Navigate to Print distribution exceptions")
    public void navigateToPrintDistributionExceptions() {
        printDistributionExceptionsNode.click();
        new DSPrintDistributionExceptionsPanel();
    }

    @Step("Navigate to Monitored folders")
    public void navigateToMonitoredFolders() {
        monitoredFoldersNode.click();
        new DSMonitoredFoldersContentPanel();
    }

    @Step("Navigate to Monitored files")
    public void navigateToMonitoredFiles() {
        monitoredFilesNode.click();
        new DSMonitoredFilesContentPanel();
    }

    @Step("Navigate to Search result")
    public void navigateToSearchResult() {
        searchResultNode.click();
        new DSSearchResultContentPanel();
    }

    public DistributionSpaceNodesPanel() {
        distributionSpaceParentNode.shouldBe(visible);
    }
}
