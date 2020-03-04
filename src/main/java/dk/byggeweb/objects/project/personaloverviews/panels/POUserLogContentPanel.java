package dk.byggeweb.objects.project.personaloverviews.panels;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.project.log.panels.LogContentPanel;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class POUserLogContentPanel extends LogContentPanel {

    private SelenideElement panelTitle = $(byXpath("//div[contains(@class, 'x-title-text x-title-text-default') and contains(text(), 'User log')]"));

    public POUserLogContentPanel() {
        panelTitle.shouldBe(visible);
    }
}
