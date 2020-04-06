package dk.byggeweb.objects.project.distributionspace.panels;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class DSFileInformationPanel extends DistributionSpaceContentPanel {

    private SelenideElement panelTitle = $(byXpath("//div[contains(@id, 'mp-common-infocard-distributionfile')]//div[@class='x-title-text x-title-text-default x-title-item']"));

    private SelenideElement previewButton = $(byXpath("//a[contains(@class, 'WMPi_file_preview_11')]"));
    private SelenideElement openButton = $(byXpath("//a[contains(@class, 'WMPi_file_open_11')]"));
    private SelenideElement moreButton = $(byXpath("//a[contains(@class, 'WMPi_more_11')]"));
    private SelenideElement versionSelector = $(byXpath("//div[contains(@class, 'WMPi_versionselector_11')]"));

    public SelenideElement fileVersionSelector(String versionIndex) {
        return $(byXpath("//li[@data-recordindex=" + versionIndex + "]"));
    }

    public DSFileInformationPanel(String title) {
        panelTitle.shouldHave(text(title));
    }
}
