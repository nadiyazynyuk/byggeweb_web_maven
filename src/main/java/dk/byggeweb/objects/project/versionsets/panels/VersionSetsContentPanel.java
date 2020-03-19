package dk.byggeweb.objects.project.versionsets.panels;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class VersionSetsContentPanel extends VersionSetsNodesPanel {

    private SelenideElement panelTitle = $(byXpath("//div[@class='x-panel x-fit-item x-panel-default']/div[contains(@class, 'x-panel-header')]//div[contains(@class, 'x-title-text x-title-text-default')]"));

    public SelenideElement getFileByFolderAndName(String folderPath, String fileName) {
        return $(byXpath("//div[@data-groupname='" + folderPath + "']/parent::td/parent::tr/parent::tbody/tr/td/div[contains(text(), '" + fileName + "')]"));
    }

    public VersionSetsContentPanel(String title) {
        panelTitle.shouldHave(text(title));
    }

    public VersionSetsContentPanel() {
    }

}
