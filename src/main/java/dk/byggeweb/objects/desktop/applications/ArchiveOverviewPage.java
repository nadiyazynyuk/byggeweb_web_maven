package dk.byggeweb.objects.desktop.applications;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class ArchiveOverviewPage extends ApplicationsPage {

    private SelenideElement archiveLabel = $(byXpath("//span[@class='x-panel-header-text' and contains(text(), 'archives')]"));

}
