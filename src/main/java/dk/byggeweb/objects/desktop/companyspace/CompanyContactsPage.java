package dk.byggeweb.objects.desktop.companyspace;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class CompanyContactsPage extends CompanySpacePage {

    private SelenideElement companyContactsLabel = $(byXpath("//*[@class='headline1-content' and contains(text(), 'Contacts')]"));

}
