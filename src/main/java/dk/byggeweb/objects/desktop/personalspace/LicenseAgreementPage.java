package dk.byggeweb.objects.desktop.personalspace;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class LicenseAgreementPage extends PersonalSpacePage {

    private final SelenideElement licenseAgreementLabel = $(byXpath("//*[@class='headline1-content' and contains(text(),'License')]"));

}
