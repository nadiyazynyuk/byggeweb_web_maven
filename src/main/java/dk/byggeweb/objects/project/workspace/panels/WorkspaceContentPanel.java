package dk.byggeweb.objects.project.workspace.panels;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class WorkspaceContentPanel extends WorkspaceNodesPanel {

    private SelenideElement fileUploadButton = $(byXpath("//span[@data-locator='locator-btn-file_upload']"));
    private SelenideElement fileDownloadButton = $(byXpath("//span[@data-locator='locator-btn-file_download']"));
    private SelenideElement filePublishButton = $(byXpath("//span[@data-locator='locator-btn-file_doctransfer']"));
    private SelenideElement fileDeleteButton = $(byXpath("//span[@data-locator='locator-btn-file_delete']"));
    private SelenideElement fileLockButton = $(byXpath("//span[@data-locator='locator-btn-file_lock']"));
    private SelenideElement fileCopyButton = $(byXpath("//span[@data-locator='locator-btn-file_copy']"));
    private SelenideElement fileMoveButton = $(byXpath("//span[@data-locator='locator-btn-file_move']"));
    private SelenideElement fileEditInfoButton = $(byXpath("//span[@data-locator='locator-btn-file_info']"));
    private SelenideElement fileNotifyButton = $(byXpath("//span[@data-locator='locator-btn-file_notify']"));
    private SelenideElement fileAddToVersionSetButton = $(byXpath("//span[@data-locator='locator-btn-file_versionset_add']"));
    private SelenideElement fileDownloadInExcelButton = $(byXpath("//span[@data-locator='locator-btn-file_excel']"));
    private SelenideElement fileRemoveFromSinceLastTimeListButton = $(byXpath("//span[@data-locator='locator-btn-file_checkout']"));
    private SelenideElement fileSendToPrintButton = $(byXpath("//span[@data-locator='locator-btn-file_plot']"));
    private SelenideElement fileAdvancedSearchButton = $(byXpath("//span[@data-locator='locator-btn-file_search']"));
    private SelenideElement fileMonitorButton = $(byXpath("//span[@data-locator='locator-btn-file_watch_toggle']"));

    public SelenideElement getFileByName(String name) {
        return $(byXpath("//tr[@class='  x-grid-row']//*[contains(text(),'" + name + "')]"));
    }

    public SelenideElement getFolderByName(String name) {
        return $(byXpath("//tr[@class='  x-grid-row']//*[contains(text(),'/" + name + "')]"));
    }

    public WorkspaceContentPanel() {}

}
