package dk.byggeweb.objects.project.workspace.panels;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class WSFolderInformationPanel extends WorkspaceNodesPanel {

    private SelenideElement panelTitle = $(byXpath("//div[contains(@id, 'mp-common-infocard-directory')]//div[@class='x-title-text x-title-text-default x-title-item']"));

    public WSFolderInformationPanel(String title) {
        panelTitle.shouldHave(text(title));
    }

}
