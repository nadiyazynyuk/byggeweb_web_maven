package dk.byggeweb.objects.project.personaloverviews.panels;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class POProjectSettingsContentPanel extends PersonalOverviewsContentPanel {

    private SelenideElement panelTitle = $(byXpath("//div[contains(@class, 'x-title-text x-title-text-default') and contains(text(), 'Project settings')]"));

    public POProjectSettingsContentPanel() {
        panelTitle.shouldBe(visible);
    }
}
