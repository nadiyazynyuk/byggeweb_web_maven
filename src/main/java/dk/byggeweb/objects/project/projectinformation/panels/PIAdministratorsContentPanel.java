package dk.byggeweb.objects.project.projectinformation.panels;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class PIAdministratorsContentPanel extends ProjectInformationContentPanel {

    private SelenideElement panelTitle = $(byXpath("//div[contains(@class, 'x-title-text x-title-text-default') and contains(text(), 'Administrators')]"));

    public PIAdministratorsContentPanel() {
        panelTitle.shouldBe(visible);
    }
}
