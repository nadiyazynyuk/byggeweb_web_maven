package dk.byggeweb.objects.project.publicationspace.panels;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class PublicationSpaceContentPanel extends PublicationSpaceNodesPanel {

    private SelenideElement fileDownloadButton = $(byXpath("//span[@data-locator='locator-btn-file_ps_download']"));
    private SelenideElement filePublishButton = $(byXpath("//span[@data-locator='locator-btn-file_ps_add']"));
    private SelenideElement fileDeleteButton = $(byXpath("//span[@data-locator='locator-btn-file_ps_delete']"));
    private SelenideElement fileAddToVersionSetButton = $(byXpath("//span[@data-locator='locator-btn-file_ps_vs_add']"));
    private SelenideElement fileAdvancedSearchButton = $(byXpath("//span[@data-locator='locator-btn-file_ps_search']"));

    public SelenideElement getFileByName(String name) {
        return $(byXpath("//tr[@class='  x-grid-row']//*[contains(text(),'" + name + "')]"));
    }

    public SelenideElement getDiscontinuedFileByName(String name) {
        return $(byXpath("//tr[@class='discontinued  x-grid-row']//*[contains(text(),'" + name + "')]"));
    }

    public PublicationSpaceContentPanel() {}
}
