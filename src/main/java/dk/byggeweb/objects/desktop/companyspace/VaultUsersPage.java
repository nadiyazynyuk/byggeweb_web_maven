package dk.byggeweb.objects.desktop.companyspace;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class VaultUsersPage extends CompanySpacePage {

    private final SelenideElement vaultUsersLabel = $(byXpath("//*[@class='headline1-content' and contains(text(), 'Vault users')]"));
    private final SelenideElement addButton = $(byXpath("//div[@id='vaultusers_grid']//button[contains(@class, 'x-btn-text') and contains(text(), 'Add')]"));

}
