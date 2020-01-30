package dk.byggeweb.objects.pages.desktop.applications;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class iTWOfmOverviewPage extends ApplicationsPage {

    private SelenideElement iTWOfmLabel = $(byXpath("//*[@class='headline1-content' and contains(text(), 'Portfolios')]"));

}
