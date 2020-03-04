package dk.byggeweb.objects.project.personaloverviews.panels;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.project.projectadministration.panels.ProjectAdministrationContentPanel;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class POPrintOrdersContentPanel extends ProjectAdministrationContentPanel {

    private SelenideElement panelTitle = $(byXpath("//div[contains(@class, 'x-title-text x-title-text-default') and contains(text(), 'Print orders')]"));

    public POPrintOrdersContentPanel() {
        panelTitle.shouldBe(visible);
    }
}
