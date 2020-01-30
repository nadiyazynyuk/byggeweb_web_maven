package dk.byggeweb.objects.pages.desktop.companyspace;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class CompanyInformationPage extends CompanySpacePage {

    private SelenideElement companyInformationLabel = $(byXpath("//*[@class='headline1-content' and contains(text(), 'information')]"));

}
