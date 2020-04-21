package dk.byggeweb.objects.project.distributionspace.panels;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class DistributionSpaceContentPanel extends DistributionSpaceNodesPanel {

    private final SelenideElement fileDownloadButton = $(byXpath("//span[@data-locator='locator-btn-file_ds_download']"));
    private final SelenideElement fileCancelDistributionButton = $(byXpath("//span[@data-locator='locator-btn-file_ds_remove']"));
    private final SelenideElement fileDistributeButton = $(byXpath("//span[@data-locator='locator-btn-file_ds_add']"));
    private final SelenideElement fileAddToVersionSetButton = $(byXpath("//span[@data-locator='locator-btn-file_ds_vs_add']"));
    private final SelenideElement fileAdvancedSearchButton = $(byXpath("//span[@data-locator='locator-btn-ds_search']"));
    private final SelenideElement fileMonitorButton = $(byXpath("//span[@data-locator='locator-btn-file_ds_watch_toggle']"));

    public SelenideElement getFileByName(String name) {
        return $(byXpath("//tr[@class='  x-grid-row']//*[contains(text(),'" + name + "')]"));
    }

    public SelenideElement getListByName(String name) {
        return $(byXpath("//tr[@class='  x-grid-row']//div[contains(text(),'" + name + "')]"));
    }

}
