package dk.byggeweb.objects.project.workspace.panels;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class WSVersionSetsContentPanel extends WorkspaceContentPanel {

    private SelenideElement panelTitle = $(byXpath("//div[contains(@class, 'x-title-text x-title-text-default') and contains(text(), 'Versions sets overview')]"));

    public WSVersionSetsContentPanel() {
        panelTitle.shouldBe(visible);
    }
}
