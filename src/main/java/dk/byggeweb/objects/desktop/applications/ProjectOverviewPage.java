package dk.byggeweb.objects.desktop.applications;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class ProjectOverviewPage extends ApplicationsPage {

    private SelenideElement projectsLabel = $(byXpath("//span[@class='x-panel-header-text' and contains(text(), 'project')]"));
}
