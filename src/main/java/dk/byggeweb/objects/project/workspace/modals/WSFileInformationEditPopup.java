package dk.byggeweb.objects.project.workspace.modals;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class WSFileInformationEditPopup {

    private SelenideElement okButton = $(byXpath("//*[@data-ref='btnInnerEl' and (text()='OK')]"));

    @Step("Close Edit file information popup")
    public void closeEditFileInformation() {
        okButton.click();
    }

}
