package dk.byggeweb.objects.desktop.companyspace;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class VaultUsersPage extends CompanySpacePage {

    private final SelenideElement vaultUsersLabel = $(byXpath("//*[@class='headline1-content' and contains(text(), 'Vault users')]"));

}
