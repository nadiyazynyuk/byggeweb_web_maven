package dk.byggeweb.objects.project.workspace.modals;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class WSFileLockPopup extends WSModalBase {

    private SelenideElement commentArea = $(byXpath("//textarea[@name='comment']"));

    @Step("Lock file with comment")
    public void lockFileWithComment(String text) {
        commentArea.setValue(text);
        getOkButton().click();
    }

    @Step("Unlock file")
    public void unlockFile() {
        getOkButton().click();
    }
}
