package dk.byggeweb.objects.desktop.applications;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class DigitalHandoverOverviewPage extends ApplicationsPage {

    private SelenideElement digitalHandoverLabel = $(byXpath("//*[@class='headline1-content' and contains(text(), 'Digital')]"));

}
