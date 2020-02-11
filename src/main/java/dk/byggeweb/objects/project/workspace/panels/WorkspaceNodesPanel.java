package dk.byggeweb.objects.project.workspace.panels;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.project.ProjectHomePage;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class WorkspaceNodesPanel extends ProjectHomePage {

    public FolderContentPanel folderContentPanel;
    public VersionSetsContentPanel versionSetsContentPanel;
    public RecycleBinContentPanel recycleBinContentPanel;
    public MonitoredFoldersContentPanel monitoredFoldersContentPanel;
    public MonitoredFilesContentPanel monitoredFilesContentPanel;
    public SinceLastTimeContentPanel sinceLastTimeContentPanel;
    public SearchResultContentPanel searchResultContentPanel;

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

    @Step("Select folder")
    public void navigateToFolder(String name) {
        getFolderByName(name).click();
        new FolderContentPanel(name);
    }

//    @Step("Verify folder is present in the list")
//    public void verifyFolderIsPresent(String name) {
//        getFolderByName(name).shouldHave(text(name));
//    }

//    @Step("Verify folder is not present in the list")
//    public void verifyFolderIsNotPresent(String name) {
//        getFolderByName(name).shouldNotHave(text(name));
//    }

//    @Step("Create folder")
//    public void createFolder(String createFolderName) {
//        String winHandleBefore = WebDriverRunner.getWebDriver().getWindowHandle();
//        createFolderButton.click();
//        switchToNewWindow();
//        FolderCreatePopup folderCreatePopup = new FolderCreatePopup();
//        folderCreatePopup.createFolder(createFolderName);
//        WebDriverRunner.getWebDriver().switchTo().window(winHandleBefore);
//        new FolderContentPanel(createFolderName);
//    }

//    @Step("Rename folder")
//    public void renameFolder(String renameFolderName) {
//        String winHandleBefore = WebDriverRunner.getWebDriver().getWindowHandle();
//        renameFolderButton.click();
//        switchToNewWindow();
//        FolderCreatePopup folderCreatePopup = new FolderCreatePopup();
//        folderCreatePopup.renameFolder(renameFolderName);
//        WebDriverRunner.getWebDriver().switchTo().window(winHandleBefore);
////        new FolderContentPanel(renameFolderName); => bug
//    }

//    @Step("Delete folder")
//    public void deleteFolder(String folderName) {
//        String winHandleBefore = WebDriverRunner.getWebDriver().getWindowHandle();
//        deleteFolderButton.click();
//        switchToNewWindow();
//        FolderDeletePopup folderDeletePopup = new FolderDeletePopup();
//        folderDeletePopup.deleteFolder();
//        WebDriverRunner.getWebDriver().switchTo().window(winHandleBefore);
//        new FolderInformationPanel(folderName);
//    }

    @Step("Navigate to root folder")
    public void navigateToRootFolder() {
        rootFolderNode.click();
        folderContentPanel = new FolderContentPanel("Project");
    }

    @Step("Navigate to Version sets")
    public void navigateToVersionSets() {
        versionSetsNode.click();
        versionSetsContentPanel = new VersionSetsContentPanel();
    }

    @Step("Navigate to Recycle bin")
    public void navigateToRecycleBin() {
        recycleBinNode.click();
        recycleBinContentPanel = new RecycleBinContentPanel();
    }

    @Step("Navigate to Monitored folders")
    public void navigateToMonitoredFolders() {
        monitoredFoldersNode.click();
        monitoredFoldersContentPanel = new MonitoredFoldersContentPanel();
    }

    @Step("Navigate to Monitored files")
    public void navigateToMonitoredFiles() {
        monitoredFilesNode.click();
        monitoredFilesContentPanel = new MonitoredFilesContentPanel();
    }

    @Step("Navigate to Since last time")
    public void navigateToSinceLastTime() {
        sinceLastTimeNode.click();
        sinceLastTimeContentPanel = new SinceLastTimeContentPanel();
    }

    @Step("Navigate to Search result")
    public void navigateToSearchResult() {
        searchResultNode.click();
        searchResultContentPanel = new SearchResultContentPanel();
    }

    public WorkspaceNodesPanel() {
        workspaceParentNode.shouldBe(visible);
    }

}
