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

    private final SelenideElement distributionSpaceParentNode = $(byXpath("//td[contains(@class, 'WMP_50')]"));
    private final SelenideElement rootDistributionListNode = $(byXpath("//td[contains(@class, 'WMP_51')]"));
    private final SelenideElement versionSetsNode = $(byXpath("//td[contains(@class, 'WMP_140')]"));
    private final SelenideElement recipientsNode = $(byXpath("//td[contains(@class, 'WMP_61')]"));
    private final SelenideElement invitedUsersNode = $(byXpath("//td[contains(@class, 'WMP_62')]"));
    private final SelenideElement recentlyReleasedFileVersionsNode = $(byXpath("//td[contains(@class, 'WMP_63')]"));
    private final SelenideElement printDistributionExceptionsNode = $(byXpath("//td[contains(@class, 'WMP_64')]"));
    private final SelenideElement monitoredFoldersNode = $(byXpath("//td[contains(@class, 'WMP_73')]"));
    private final SelenideElement monitoredFilesNode = $(byXpath("//td[contains(@class, 'WMP_74')]"));
    private final SelenideElement searchResultNode = $(byXpath("//td[contains(@class, 'WMP_68')]"));

    public SelenideElement getDistributionListNodeByName(String name) {
        return $(By.xpath("//span[@class='x-tree-node-text ' and contains(text(), '" + name + "')]"));
    }

    private final SelenideElement createDistributionListButton = $(byXpath("//span[@data-locator='locator-btn-distlist_create']"));
    private final SelenideElement editDistributionListButton = $(byXpath("//span[@data-locator='locator-btn-distlist_edit']"));
    private final SelenideElement deleteDistributionListButton = $(byXpath("//span[@data-locator='locator-btn-distlist_delete']"));
    private final SelenideElement associateDocumentListButton = $(byXpath("//span[@data-locator='locator-btn-distlist_set_doclist']"));
    private final SelenideElement associateDistributionListButton = $(byXpath("//span[@data-locator='locator-btn-distlist_set_distr']"));
    private final SelenideElement monitorFolderButton = $(byXpath("//span[@data-locator='locator-btn-distlist_watch_dir']"));
    private final SelenideElement quickSearchInput = $(byXpath("//input[contains(@id, 'textfield')]"));

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

    @Step("Open Version sets")
    public void openVersionSets() {
        versionSetsNode.doubleClick();
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
