package dk.byggeweb.objects.project.versionsets.panels;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class VSSpaceContentPanel extends VersionSetsContentPanel {

    private SelenideElement panelTitle = $(byXpath("//div[contains(@class, 'x-title-text x-title-text-default') and contains(text(), 'space]')]"));

    private SelenideElement downloadFilesButton = $(byXpath("//span[@data-locator='locator-btn-file_vs_download']"));
    private SelenideElement removeFromVersionSetButton = $(byXpath("//span[@data-locator='locator-btn-file_vs_remove']"));
    private SelenideElement changeFileVersionsButton = $(byXpath("//span[@data-locator='locator-btn-file_vs_change']"));

    public VSSpaceContentPanel() {
        panelTitle.shouldHave(visible);
    }

}
