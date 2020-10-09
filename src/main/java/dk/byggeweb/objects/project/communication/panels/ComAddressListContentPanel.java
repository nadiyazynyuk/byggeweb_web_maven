package dk.byggeweb.objects.project.communication.panels;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ComAddressListContentPanel extends CommunicationContentPanel {

    private final SelenideElement panelTitle = $(byXpath("//div[contains(@class, 'x-title-text x-title-text-default') and contains(text(), 'Address list')]"));

    public ComAddressListContentPanel() {
        panelTitle.shouldBe(visible);
    }
}
