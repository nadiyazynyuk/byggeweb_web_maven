package dk.byggeweb.objects.desktop.companyspace;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class WebsiteTemplatesPage extends CompanySpacePage {

    private SelenideElement websiteTemplatesLabel = $(byXpath("//*[@class='headline1-content' and contains(text(), 'Website')]"));

}
