package dk.byggeweb.objects.desktop.personalspace;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class ReportsPage extends PersonalSpacePage {

    private SelenideElement reportsLabel = $(byXpath("//*[@class='headline1-content' and contains(text(),'Reports')]"));

}
