package dk.byggeweb.objects.pages.project.common;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.pages.PageBase;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class TxtFileViewPage extends PageBase {

    private SelenideElement txtFileContent(String content) {
        return $(byXpath("//pre[contains(text(), '" + content + "')]"));
    }

    @Step("Verify file version content")
    public void verifyFileVersionContent(String content) {
        txtFileContent(content).shouldHave(text(content));
    }

}
