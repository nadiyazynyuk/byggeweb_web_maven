package dk.byggeweb.objects.project.workspace.panels;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class WSFolderContentPanel extends WorkspaceContentPanel {

    private SelenideElement panelTitle = $(byXpath("//div[contains(@class, 'WMP_main-file-grid')]//div[@class='x-title-text x-title-text-default x-title-item']"));

    public SelenideElement getFileContainsLockIcon(String name) {
        return $(byXpath("//img[@class='lock-tipp']/parent::div/parent::td/parent::tr/td/div[contains(text(), '" + name + "')]"));
    }

    public boolean isFileLocked(String name) {
        WSFolderContentPanel wsFolderContentPanel = new WSFolderContentPanel();
        return wsFolderContentPanel.getFileContainsLockIcon(name).isDisplayed();
    }

    public WSFolderContentPanel(String title) {
        panelTitle.shouldHave(text(title));
    }

    public WSFolderContentPanel(){}
}
