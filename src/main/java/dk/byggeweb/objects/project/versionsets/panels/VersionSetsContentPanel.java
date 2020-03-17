package dk.byggeweb.objects.project.versionsets.panels;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class VersionSetsContentPanel extends VersionSetsNodesPanel {

    private SelenideElement panelTitle = $(byXpath("//div[@class='x-panel x-fit-item x-panel-default']/div[contains(@class, 'x-panel-header')]//div[contains(@class, 'x-title-text x-title-text-default')]"));

    public VersionSetsContentPanel(String title) {
        panelTitle.shouldHave(text(title));
    }

}
