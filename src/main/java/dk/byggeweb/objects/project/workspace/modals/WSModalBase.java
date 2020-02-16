package dk.byggeweb.objects.project.workspace.modals;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public abstract class WSModalBase {

    private SelenideElement okButton = $(byXpath("//input[@value='OK']"));
    private SelenideElement cancelButton = $(byXpath("//input[@value='Cancel']"));
    private SelenideElement nextButton = $(byXpath("//input[@value='Next']"));
    private SelenideElement closeButton = $(byXpath("//input[@value='Close window']"));

}
