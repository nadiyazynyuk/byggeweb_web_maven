package dk.byggeweb.objects.project.publicationspace.panels;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class PSFileInformationPanel extends PublicationSpaceContentPanel {

    private SelenideElement panelTitle = $(byXpath("//div[contains(@id, 'mp-common-infocard-docregisterfile')]//div[@class='x-title-text x-title-text-default x-title-item']"));

    private SelenideElement previewButton = $(byXpath("//a[contains(@class, 'WMPi_file_preview_3')]"));
    private SelenideElement openButton = $(byXpath("//a[contains(@class, 'WMPi_file_open_3')]"));
    private SelenideElement moreButton = $(byXpath("//a[contains(@class, 'WMPi_more_3')]"));
    private SelenideElement versionSelector = $(byXpath("//div[contains(@class, 'WMPi_versionselector_3')]"));

    public SelenideElement fileVersionSelector(String versionIndex) {
        return $(byXpath("//li[@data-recordindex=" + versionIndex + "]"));
    }

    public PSFileInformationPanel(String title) {
        panelTitle.shouldHave(text(title));
    }
}
