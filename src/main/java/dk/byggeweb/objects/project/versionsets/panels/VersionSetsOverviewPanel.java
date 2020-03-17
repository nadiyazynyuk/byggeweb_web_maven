package dk.byggeweb.objects.project.versionsets.panels;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class VersionSetsOverviewPanel extends VersionSetsNodesPanel {

    private SelenideElement panelTitle = $(byXpath("//div[contains(@class, 'x-title-text x-title-text-default') and contains(text(), 'Versions sets overview')]"));

    public VersionSetsOverviewPanel() {
        panelTitle.shouldBe(visible);
    }

}
