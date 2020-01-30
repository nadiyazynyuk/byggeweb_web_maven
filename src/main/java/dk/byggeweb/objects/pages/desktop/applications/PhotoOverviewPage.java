package dk.byggeweb.objects.pages.desktop.applications;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class PhotoOverviewPage extends ApplicationsPage {

    private SelenideElement photoLabel = $(byXpath("//*[@class='headline1-content' and contains(text(), 'Photo')]"));

}
