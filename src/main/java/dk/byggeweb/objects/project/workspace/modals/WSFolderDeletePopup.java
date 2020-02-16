package dk.byggeweb.objects.project.workspace.modals;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import dk.byggeweb.objects.desktop.personalspace.modals.ModalBase;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class WSFolderDeletePopup extends ModalBase {

    private SelenideElement okButton = $(byXpath("//input[@value='OK']"));

    @Step("Delete folder")
    public void deleteFolder() {
        okButton.click();
        WebDriverRunner.getWebDriver().switchTo().alert().accept();
    }

}
