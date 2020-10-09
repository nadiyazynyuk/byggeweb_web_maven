package dk.byggeweb.objects.project.communication.panels;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ComMessagesContentPanel extends CommunicationContentPanel {

    private final SelenideElement panelTitle = $(byXpath("//span[@class='x-btn-inner x-btn-inner-default-toolbar-small' and contains(text(), 'All messages')]"));

    public ComMessagesContentPanel() {
        panelTitle.shouldBe(visible);
    }

}
