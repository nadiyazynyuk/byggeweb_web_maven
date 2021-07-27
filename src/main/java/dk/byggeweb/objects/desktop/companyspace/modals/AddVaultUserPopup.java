package dk.byggeweb.objects.desktop.companyspace.modals;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class AddVaultUserPopup extends ModalBase {

    private SelenideElement searchBox = $(byXpath("//input[@id='searchbox']"));
    private SelenideElement addButton = $(byXpath("//input[@value='Add']"));
    private SelenideElement userRadioButton = $(byXpath("//input[@name='userid']"));
}
