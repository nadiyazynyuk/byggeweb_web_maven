package dk.byggeweb.objects.project.workspace.modals;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class FileInformationEditPopup {

    private SelenideElement okButton = $(By.xpath("//*[@data-ref='btnInnerEl' and (text()='OK')]"));

    @Step("Close Edit file information popup")
    public void closeEditFileInformation() {
        okButton.click();
    }

}
