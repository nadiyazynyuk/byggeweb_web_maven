package dk.byggeweb.objects.project.workspace.panels;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import dk.byggeweb.objects.project.ProjectHomePage;
import dk.byggeweb.objects.project.workspace.modals.FolderCreatePopup;
import dk.byggeweb.objects.project.workspace.modals.FolderDeletePopup;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class WorkspaceNodesPanel extends ProjectHomePage {

    private SelenideElement panelTitle = $(byXpath("//div[contains(@id, 'mp-common-infocard-directory')]//div[@class='x-title-text x-title-text-default x-title-item']"));

    private SelenideElement workspaceParentNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Workspace')]"));
    private SelenideElement rootFolderNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Project')]"));
    private SelenideElement versionSetsNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Version sets')]"));
    private SelenideElement recycleBinNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Recycle bin')]"));
    private SelenideElement monitoredFoldersNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Monitored folders')]"));
    private SelenideElement monitoredFilesNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Monitored files')]"));
    private SelenideElement sinceLastTimeNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Since last time')]"));
    private SelenideElement searchResultNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Search')]"));

    private SelenideElement getFolderByName(String name) {
        return $(By.xpath("//span[@class='x-tree-node-text ' and contains(text(), '" + name + "')]"));
    }

    private SelenideElement createFolderButton = $(byXpath("//span[@data-locator='locator-btn-create_dir']"));
    private SelenideElement renameFolderButton = $(byXpath("//span[@data-locator='locator-btn-rename_dir']"));
    private SelenideElement copyFolderButton = $(byXpath("//span[@data-locator='locator-btn-copy_dir']"));
    private SelenideElement deleteFolderButton = $(byXpath("//span[@data-locator='locator-btn-delete_dir']"));
    private SelenideElement monitorFolderButton = $(byXpath("//span[@data-locator='locator-btn-watch_dir']"));
    private SelenideElement setFolderPermissionsButton = $(byXpath("//span[@data-locator='locator-btn-security_dir']"));
    private SelenideElement downloadFilesFromFolderButton = $(byXpath("//span[@data-locator='locator-btn-download_dir']"));

    @Step("Select folder")
    public void navigateToFolder(String name) {
        getFolderByName(name).click();
    }

    @Step("Verify folder is present in the list")
    public void verifyFolderIsPresent(String name) {
        getFolderByName(name).shouldHave(text(name));
    }

    @Step("Verify folder is not present in the list")
    public void verifyFolderIsNotPresent(String name) {
        getFolderByName(name).shouldNotHave(text(name));
    }

    @Step("Create folder")
    public void createFolder(String createFolderName) {
        String winHandleBefore = WebDriverRunner.getWebDriver().getWindowHandle();
        createFolderButton.click();
        switchToNewWindow();
        FolderCreatePopup folderCreatePopup = new FolderCreatePopup();
        folderCreatePopup.createFolder(createFolderName);
        WebDriverRunner.getWebDriver().switchTo().window(winHandleBefore);
    }

    @Step("Rename folder")
    public void renameFolder(String renameFolderName) {
        String winHandleBefore = WebDriverRunner.getWebDriver().getWindowHandle();
        renameFolderButton.click();
        switchToNewWindow();
        FolderCreatePopup folderCreatePopup = new FolderCreatePopup();
        folderCreatePopup.renameFolder(renameFolderName);
        WebDriverRunner.getWebDriver().switchTo().window(winHandleBefore);
    }

    @Step("Delete folder")
    public void deleteFolder(String folderName) {
        String winHandleBefore = WebDriverRunner.getWebDriver().getWindowHandle();
        deleteFolderButton.click();
        switchToNewWindow();
        FolderDeletePopup folderDeletePopup = new FolderDeletePopup();
        folderDeletePopup.deleteFolder();
        WebDriverRunner.getWebDriver().switchTo().window(winHandleBefore);
        new FolderInformationPanel(folderName);
    }

    @Step("Navigate to Version sets")
    public void navigateToVersionSets() {
        versionSetsNode.click();
    }

    @Step("Navigate to Recycle bin")
    public void navigateToRecycleBin() {
        recycleBinNode.click();
    }

    @Step("Navigate to Monitored folders")
    public void navigateToMonitoredFolders() {
        monitoredFoldersNode.click();
    }

    @Step("Navigate to Monitored files")
    public void navigateToMonitoredFiles() {
        monitoredFilesNode.click();
    }

    @Step("Navigate to Since last time")
    public void navigateToSinceLastTime() {
        sinceLastTimeNode.click();
    }

    @Step("Navigate to Search result")
    public void navigateToSearchResult() {
        searchResultNode.click();
    }

    public WorkspaceNodesPanel() {
        super();
    }

    public WorkspaceNodesPanel(String title) {
        panelTitle.shouldHave(text(title));
    }

}
