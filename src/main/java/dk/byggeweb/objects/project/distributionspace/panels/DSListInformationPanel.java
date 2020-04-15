package dk.byggeweb.objects.project.distributionspace.panels;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class DSListInformationPanel extends DistributionSpaceContentPanel {

    private SelenideElement panelTitle = $(byXpath("//div[contains(@id, 'mp-distribution-info') and contains(@class, 'x-title-text x-title-text-default x-title-item')]"));

    private SelenideElement getAssociatedListFromTable(String listName) {
        return $(byXpath("//div[@class='x-panel-body x-grid-with-row-lines x-grid-body x-panel-body-default x-panel-body-default x-noborder-rbl']//div[contains(text(), '" + listName + "')]"));
    }

    public boolean isListAssociated(String listName) {
        return getAssociatedListFromTable(listName).isDisplayed();
    }

    public DSListInformationPanel(String title) {
        panelTitle.shouldHave(text(title));
    }

}
