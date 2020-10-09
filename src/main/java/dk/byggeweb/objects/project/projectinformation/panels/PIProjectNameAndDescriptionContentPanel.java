package dk.byggeweb.objects.project.projectinformation.panels;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class PIProjectNameAndDescriptionContentPanel extends ProjectInformationContentPanel {

    private final SelenideElement panelTitle = $(byXpath("//div[contains(@class, 'x-title-text x-title-text-default') and contains(text(), 'Project name')]"));

    public PIProjectNameAndDescriptionContentPanel() {
        panelTitle.shouldBe(visible);
    }
}
