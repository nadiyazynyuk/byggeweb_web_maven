package dk.byggeweb.objects.project.distributionspace.panels;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class DSSingleDistributionListContentPanel extends DistributionSpaceContentPanel {

    private SelenideElement panelTitle = $(byXpath("//div[contains(@class, 'x-title-text x-title-text-default') and contains(text(), 'Distribution list')]"));

    public DSSingleDistributionListContentPanel() {
        panelTitle.shouldBe(exist);
    }

}
