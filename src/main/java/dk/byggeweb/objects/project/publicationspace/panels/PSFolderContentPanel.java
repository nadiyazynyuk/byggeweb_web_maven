package dk.byggeweb.objects.project.publicationspace.panels;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class PSFolderContentPanel extends PublicationSpaceContentPanel {

    private SelenideElement panelTitle = $(byXpath("//div[contains(@class, 'WMP_main-file-grid')]//div[@class='x-title-text x-title-text-default x-title-item']"));

    public PSFolderContentPanel(String title) {
        panelTitle.shouldHave(text(title));
    }

    public PSFolderContentPanel() {}
}
