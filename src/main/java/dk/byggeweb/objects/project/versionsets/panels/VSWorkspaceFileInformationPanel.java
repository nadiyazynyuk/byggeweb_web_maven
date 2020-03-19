package dk.byggeweb.objects.project.versionsets.panels;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class VSWorkspaceFileInformationPanel {

    private SelenideElement panelTitle = $(byXpath("//div[contains(@id, 'mp-common-infocard-workspacefile')]//div[@class='x-title-text x-title-text-default x-title-item']"));

    public VSWorkspaceFileInformationPanel(String title) {
        panelTitle.shouldHave(text(title));
    }
}
