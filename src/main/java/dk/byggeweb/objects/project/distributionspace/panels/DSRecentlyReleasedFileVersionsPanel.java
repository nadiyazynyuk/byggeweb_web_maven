package dk.byggeweb.objects.project.distributionspace.panels;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class DSRecentlyReleasedFileVersionsPanel extends DistributionSpaceContentPanel {

    private SelenideElement panelTitle = $(byXpath("//div[contains(@class, 'x-title-text x-title-text-default') and contains(text(), 'Recently released')]"));

    public DSRecentlyReleasedFileVersionsPanel() {
        panelTitle.shouldBe(visible);
    }
}
