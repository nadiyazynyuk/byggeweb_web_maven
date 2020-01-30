package dk.byggeweb.objects.pages.desktop.applications;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class TenderOverviewPage extends ApplicationsPage {

    private SelenideElement tendersLabel = $(byXpath("//*[@class='headline1-content' and contains(text(),'Tenders')]"));

}
