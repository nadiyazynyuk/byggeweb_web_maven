package dk.byggeweb.objects.project.common.modals;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public abstract class ModalBase {

    private SelenideElement okButton = $(byXpath("//input[@value='OK']"));
    private SelenideElement cancelButton = $(byXpath("//input[@value='Cancel']"));
    private SelenideElement nextButton = $(byXpath("//input[@value='Next']"));
    private SelenideElement closeButton = $(byXpath("//input[@value='Close']"));

}
