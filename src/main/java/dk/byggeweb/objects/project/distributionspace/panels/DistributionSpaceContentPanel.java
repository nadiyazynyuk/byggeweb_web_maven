package dk.byggeweb.objects.project.distributionspace.panels;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class DistributionSpaceContentPanel extends DistributionSpaceNodesPanel {

    private SelenideElement fileCancelDistributionButton = $(byXpath("//span[@data-locator='locator-btn-file_ds_remove']"));

    public SelenideElement getFileByName(String name) {
        return $(byXpath("//tr[@class='  x-grid-row']//*[contains(text(),'" + name + "')]"));
    }

}
