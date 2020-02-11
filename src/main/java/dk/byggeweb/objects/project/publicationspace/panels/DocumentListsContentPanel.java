package dk.byggeweb.objects.project.publicationspace.panels;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class DocumentListsContentPanel extends PublicationSpaceContentPanel {

    private SelenideElement panelTitle = $(byXpath("//div[contains(@class, 'x-title-text x-title-text-default') and contains(text(), 'Document lists')]"));

    public DocumentListsContentPanel() {
        panelTitle.shouldBe(visible);
    }

}
