package dk.byggeweb.objects.project.workspace.panels;

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
public class WorkspaceNodesPanel extends ProjectHomePage {

    private SelenideElement workspaceParentNode = $(byXpath("//td[contains(@class, 'WMP_10')]"));
    private SelenideElement rootFolderNode = $(byXpath("//td[contains(@class, 'WMP_11')]/div/span[contains(text(), 'Project')]"));
    private SelenideElement versionSetsNode = $(byXpath("//td[contains(@class, 'WMP_140')]"));
    private SelenideElement recycleBinNode = $(byXpath("//td[contains(@class, 'WMP_12')]"));
    private SelenideElement monitoredFoldersNode = $(byXpath("//td[contains(@class, 'WMP_13')]"));
    private SelenideElement monitoredFilesNode = $(byXpath("//td[contains(@class, 'WMP_19')]"));
    private SelenideElement sinceLastTimeNode = $(byXpath("//td[contains(@class, 'WMP_14')]/div/span[contains(text(), 'Since last time')]"));
    private SelenideElement searchResultNode = $(byXpath("//td[contains(@class, 'WMP_15')]"));

    public SelenideElement getFolderByName(String name) {
        return $(By.xpath("//span[@class='x-tree-node-text ' and contains(text(), '" + name + "')]"));
    }

    private SelenideElement createFolderButton = $(byXpath("//span[@data-locator='locator-btn-create_dir']"));
    private SelenideElement renameFolderButton = $(byXpath("//span[@data-locator='locator-btn-rename_dir']"));
    private SelenideElement copyFolderButton = $(byXpath("//span[@data-locator='locator-btn-copy_dir']"));
    private SelenideElement deleteFolderButton = $(byXpath("//span[@data-locator='locator-btn-delete_dir']"));
    private SelenideElement monitorFolderButton = $(byXpath("//span[@data-locator='locator-btn-watch_dir']"));
    private SelenideElement setFolderPermissionsButton = $(byXpath("//span[@data-locator='locator-btn-security_dir']"));
    private SelenideElement downloadFilesFromFolderButton = $(byXpath("//span[@data-locator='locator-btn-download_dir']"));
    private SelenideElement quickSearchInput = $(byXpath("//input[contains(@id, 'textfield')]"));

    @Step("Select folder")
    public void navigateToFolder(String name) {
        getFolderByName(name).click();
        new WSFolderContentPanel(name);
    }

    @Step("Navigate to root folder")
    public void navigateToRootFolder() {
        rootFolderNode.click();
        new WSFolderContentPanel("Project");
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

    @Step("Navigate to Recycle bin")
    public void navigateToRecycleBin() {
        recycleBinNode.click();
        new WSRecycleBinContentPanel();
    }

    @Step("Navigate to Monitored folders")
    public void navigateToMonitoredFolders() {
        monitoredFoldersNode.click();
        new WSMonitoredFoldersContentPanel();
    }

    @Step("Navigate to Monitored files")
    public void navigateToMonitoredFiles() {
        monitoredFilesNode.click();
        new WSMonitoredFilesContentPanel();
    }

    @Step("Navigate to Since last time")
    public void navigateToSinceLastTime() {
        sinceLastTimeNode.click();
        new WSSinceLastTimeContentPanel();
    }

    @Step("Navigate to Search result")
    public void navigateToSearchResult() {
        searchResultNode.click();
        new WSSearchResultContentPanel();
    }

    public WorkspaceNodesPanel() {
        workspaceParentNode.shouldBe(visible);
    }

}
