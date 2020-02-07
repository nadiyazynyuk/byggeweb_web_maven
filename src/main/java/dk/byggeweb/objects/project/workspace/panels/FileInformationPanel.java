package dk.byggeweb.objects.project.workspace.panels;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import dk.byggeweb.objects.project.common.TxtFileViewPage;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class FileInformationPanel extends WorkspaceContentPanel {

    private SelenideElement panelTitle = $(byXpath("//div[contains(@id, 'mp-common-infocard-workspacefile')]//div[@class='x-title-text x-title-text-default x-title-item']"));

    private SelenideElement openButton = $(byXpath("//span[contains(@id, 'button') and contains(text(), 'Open')]"));
    private SelenideElement previewButton = $(byXpath("//span[contains(@id, 'button') and contains(text(), 'Preview')]"));
    private SelenideElement moreButton = $(byXpath("//span[contains(@id, 'button') and contains(text(), 'More...')]"));
    private SelenideElement saveButton = $(byXpath("//div[contains(@id, 'mp-common-infocard-workspacefile')]//span[contains(text(), 'Save')]"));
    private SelenideElement versionSelector = $(byXpath("//input[contains(@id, 'mp-common-infocard-versionselector')]"));
    private SelenideElement metadataRefField = $(byXpath("//div[contains(@class, 'WMP_Ref')][1]//input"));
    private SelenideElement metadataRevisionField = $(byXpath("//div[contains(@class, 'WMP_RevName')]//input"));
    private SelenideElement metadataRevDateField = $(byXpath("//div[contains(@class, 'WMP_RevDate')]//input"));

    private SelenideElement fileVersionSelector(String versionIndex) {
        return $(byXpath("//li[@data-recordindex=" + versionIndex + "]"));
    }

    @Step("Select file version")
    public void selectFileVersion(String versionIndex) {
        versionSelector.click();
        fileVersionSelector(versionIndex).click();
    }

    @Step("Open file")
    public void openFile(String content) {
        String winHandleBefore = WebDriverRunner.getWebDriver().getWindowHandle();
        openButton.click();
        switchToNewWindow();
        TxtFileViewPage txtFileViewPage = new TxtFileViewPage();
        txtFileViewPage.verifyFileVersionContent(content);
        WebDriverRunner.getWebDriver().close();
        WebDriverRunner.getWebDriver().switchTo().window(winHandleBefore);
    }

    @Step("Open previous file version")
    public void openPreviousFileVersion(String content) {
        String winHandleBefore = WebDriverRunner.getWebDriver().getWindowHandle();
        openButton.click();
        WebDriverRunner.getWebDriver().switchTo().alert().accept();
        switchToLastTab();
        switchToNewWindow();
        TxtFileViewPage txtFileViewPage = new TxtFileViewPage();
        txtFileViewPage.verifyFileVersionContent(content);
        WebDriverRunner.getWebDriver().close();
        WebDriverRunner.getWebDriver().switchTo().window(winHandleBefore);
    }

    @Step("Edit metadata text field")
    public void editMetadataTextField(SelenideElement element, String data) {
        saveButton.shouldBe(Condition.enabled);
        element.click();
        element.clear();
        element.shouldBe(Condition.empty);
        element.setValue(data);
        saveButton.click();
    }

    public FileInformationPanel(String title) {
        panelTitle.shouldHave(text(title));
    }
}


