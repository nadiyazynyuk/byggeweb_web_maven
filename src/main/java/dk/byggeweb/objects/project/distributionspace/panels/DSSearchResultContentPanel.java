package dk.byggeweb.objects.project.distributionspace.panels;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class DSSearchResultContentPanel extends DistributionSpaceContentPanel {

    private final SelenideElement panelTitle = $(byXpath("//div[contains(@class, 'x-title-text x-title-text-default') and contains(text(), 'Search')]"));

    public DSSearchResultContentPanel() {
        panelTitle.shouldBe(visible);
    }
}
