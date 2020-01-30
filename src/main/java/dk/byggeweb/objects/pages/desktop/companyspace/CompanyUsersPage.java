package dk.byggeweb.objects.pages.desktop.companyspace;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class CompanyUsersPage extends CompanySpacePage {

    private SelenideElement companyUsersLabel = $(byXpath("//*[@class='x-panel-header-text' and contains(text(), 'users')]"));

}
