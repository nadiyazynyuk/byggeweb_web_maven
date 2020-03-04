package dk.byggeweb.objects.project.projectadministration.panels;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class PAApprovalContentPanel extends ProjectAdministrationContentPanel {

    private SelenideElement panelTitle = $(byXpath("//div[contains(@class, 'x-title-text x-title-text-default') and contains(text(), 'Approval')]"));

    public PAApprovalContentPanel() {
        panelTitle.shouldBe(visible);
    }
}
