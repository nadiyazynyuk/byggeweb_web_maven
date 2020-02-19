package dk.byggeweb.objects.project.workspace.panels;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class WSFileInformationPanel extends WorkspaceContentPanel {

    private SelenideElement panelTitle = $(byXpath("//div[contains(@id, 'mp-common-infocard-workspacefile')]//div[@class='x-title-text x-title-text-default x-title-item']"));

    private SelenideElement previewButton = $(byXpath("//a[contains(@class, 'WMPi_file_preview_1')]"));
    private SelenideElement openButton = $(byXpath("//a[contains(@class, 'WMPi_file_open_1')]"));
    private SelenideElement moreButton = $(byXpath("//a[contains(@class, 'WMPi_more_1')]"));
    private SelenideElement saveButton = $(byXpath("//div[contains(@id, 'mp-common-infocard-workspacefile')]//span[contains(text(), 'Save')]"));
    private SelenideElement versionSelector = $(byXpath("//div[contains(@class, 'WMPi_versionselector_1')]"));
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


