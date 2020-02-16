package dk.byggeweb.objects.project.workspace.panels;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class WSFileInformationPanel extends WorkspaceContentPanel {

    private SelenideElement panelTitle = $(byXpath("//div[contains(@id, 'mp-common-infocard-workspacefile')]//div[@class='x-title-text x-title-text-default x-title-item']"));

    private SelenideElement openButton = $(byXpath("//span[contains(@id, 'button') and contains(text(), 'Open')]"));
    private SelenideElement previewButton = $(byXpath("//span[contains(@id, 'button') and contains(text(), 'Preview')]"));
    private SelenideElement moreButton = $(byXpath("//span[contains(@id, 'button') and contains(text(), 'More...')]"));
    private SelenideElement saveButton = $(byXpath("//div[contains(@id, 'mp-common-infocard-workspacefile')]//span[contains(text(), 'Save')]"));
    private SelenideElement versionSelector = $(byXpath("//input[contains(@id, 'mp-common-infocard-versionselector')]"));
    private SelenideElement metadataRefField = $(byXpath("//div[contains(@class, 'WMP_Ref')][1]//input"));
    private SelenideElement metadataRevisionField = $(byXpath("//div[contains(@class, 'WMP_RevName')]//input"));
    private SelenideElement metadataRevDateField = $(byXpath("//div[contains(@class, 'WMP_RevDate')]//input"));

    public SelenideElement fileVersionSelector(String versionIndex) {
        return $(byXpath("//li[@data-recordindex=" + versionIndex + "]"));
    }

    public WSFileInformationPanel(String title) {
        panelTitle.shouldHave(text(title));
    }
}


