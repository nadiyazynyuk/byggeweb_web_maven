package dk.byggeweb.objects.project.distributionspace.panels;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class DSMonitoredFoldersContentPanel extends DistributionSpaceContentPanel {

    private final SelenideElement panelTitle = $(byXpath("//div[contains(@class, 'x-title-text x-title-text-default') and contains(text(), 'Monitored folders')]"));

    public SelenideElement getFolderByName(String name) {
        return $(byXpath("//tr[@class='  x-grid-row']//*[contains(text(),'/" + name + "')]"));
    }

    public DSMonitoredFoldersContentPanel() {
        panelTitle.shouldBe(visible);
    }
}
