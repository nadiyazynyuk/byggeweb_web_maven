package dk.byggeweb.objects.project;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public abstract class ModalBase {

//    public ModalBase() {
//        WebDriverRunner.getWebDriver().manage().window().setSize(new Dimension(900, 700));
//    }

    private SelenideElement okButton = $(byXpath("//input[@value='OK']"));
    private SelenideElement cancelButton = $(byXpath("//input[@value='Cancel']"));
    private SelenideElement nextButton = $(byXpath("//input[@value='Next']"));
    private SelenideElement closeButton = $(byXpath("//input[contains(@value, 'Close')]"));
    private SelenideElement deleteButton = $(byXpath("//input[@value='Delete']"));
    private SelenideElement createButton = $(byXpath("//input[@value='Create']"));
    private SelenideElement yesButton = $(byXpath("//input[contains(@value, 'Yes')]"));
    private SelenideElement noButton = $(byXpath("//input[contains(@value, 'No')]"));

    public void pleaseWait(int millis) {
        try {
            synchronized (this) {
                wait(millis);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
