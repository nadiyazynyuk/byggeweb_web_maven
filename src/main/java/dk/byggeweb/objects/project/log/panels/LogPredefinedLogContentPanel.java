package dk.byggeweb.objects.project.log.panels;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LogPredefinedLogContentPanel extends LogContentPanel {

    private final SelenideElement panelTitle = $(byXpath("//div[contains(@class, 'x-title-text x-title-text-default') and contains(text(), 'Predefined log')]"));

    public LogPredefinedLogContentPanel() {
        panelTitle.shouldBe(visible);
    }
}
