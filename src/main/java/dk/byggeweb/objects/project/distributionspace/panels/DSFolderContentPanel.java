package dk.byggeweb.objects.project.distributionspace.panels;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class DSFolderContentPanel extends DistributionSpaceContentPanel {

    private final SelenideElement panelTitle = $(byXpath("//div[contains(@class, 'WMP_main-file-grid')]//div[@class='x-title-text x-title-text-default x-title-item']"));

    public DSFolderContentPanel(String title) {
        panelTitle.shouldHave(text(title));
    }

    public DSFolderContentPanel() {}

}
