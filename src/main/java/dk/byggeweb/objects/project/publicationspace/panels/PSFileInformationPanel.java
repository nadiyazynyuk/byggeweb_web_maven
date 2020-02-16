package dk.byggeweb.objects.project.publicationspace.panels;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class PSFileInformationPanel extends PublicationSpaceContentPanel {

    private SelenideElement panelTitle = $(byXpath("//div[contains(@id, 'mp-common-infocard-workspacefile')]//div[@class='x-title-text x-title-text-default x-title-item']"));

    public PSFileInformationPanel(String title) {
        panelTitle.shouldHave(text(title));
    }
}
