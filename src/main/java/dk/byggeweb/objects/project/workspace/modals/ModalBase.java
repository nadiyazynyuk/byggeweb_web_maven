package dk.byggeweb.objects.project.workspace.modals;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public abstract class ModalBase {

    private SelenideElement okButton = $(byXpath("//input[@type='button' and @value='OK']"));
    private SelenideElement cancelButton = $(byXpath("//input[@type='button' and @value='Cancel']"));
    private SelenideElement nextButton = $(byXpath("//input[@type='submit' and @value='Next']"));
    private SelenideElement closeButton = $(byXpath("//input[@type='button' and @value='Close window']"));

}
