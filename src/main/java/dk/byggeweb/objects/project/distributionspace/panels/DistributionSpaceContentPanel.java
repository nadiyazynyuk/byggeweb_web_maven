package dk.byggeweb.objects.project.distributionspace.panels;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class DistributionSpaceContentPanel extends DistributionSpaceNodesPanel {

    private SelenideElement fileDownloadButton = $(byXpath("//span[@data-locator='locator-btn-file_ds_download']"));
    private SelenideElement fileCancelDistributionButton = $(byXpath("//span[@data-locator='locator-btn-file_ds_remove']"));
    private SelenideElement fileDistributeButton = $(byXpath("//span[@data-locator='locator-btn-file_ds_add']"));
    private SelenideElement fileAddToVersionSetButton = $(byXpath("//span[@data-locator='locator-btn-file_ds_vs_add']"));
    private SelenideElement fileAdvancedSearchButton = $(byXpath("//span[@data-locator='locator-btn-ds_search']"));

    public SelenideElement getFileByName(String name) {
        return $(byXpath("//tr[@class='  x-grid-row']//*[contains(text(),'" + name + "')]"));
    }

}
