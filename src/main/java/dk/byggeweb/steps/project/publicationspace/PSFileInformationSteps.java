package dk.byggeweb.steps.project.publicationspace;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import dk.byggeweb.objects.project.common.TxtFileViewPage;
import dk.byggeweb.objects.project.publicationspace.panels.PSFileInformationPanel;
import io.qameta.allure.Step;

public class PSFileInformationSteps {

    @Step("Select file version")
    public void selectFileVersion(String fileName, String versionIndex) {
        PSFileInformationPanel psFileInformationPanel = new PSFileInformationPanel(fileName);
        psFileInformationPanel.getVersionSelector().click();
        psFileInformationPanel.fileVersionSelector(versionIndex).click();
    }

    @Step("Open file and verify its content")
    public void openFile(String fileName, String fileContent) {
        String winHandleBefore = WebDriverRunner.getWebDriver().getWindowHandle();
        PSFileInformationPanel psFileInformationPanel = new PSFileInformationPanel(fileName);
        psFileInformationPanel.getOpenButton().click();
        psFileInformationPanel.switchToNewWindow();
        TxtFileViewPage txtFileViewPage = new TxtFileViewPage();
        txtFileViewPage.verifyFileVersionContent(fileContent);
        WebDriverRunner.getWebDriver().close();
        WebDriverRunner.getWebDriver().switchTo().window(winHandleBefore);
    }

    @Step("Open previous file version and verify its content")
    public void openPreviousFileVersion(String fileName, String fileContent) {
        String winHandleBefore = WebDriverRunner.getWebDriver().getWindowHandle();
        PSFileInformationPanel psFileInformationPanel = new PSFileInformationPanel(fileName);
        psFileInformationPanel.getOpenButton().click();
        WebDriverRunner.getWebDriver().switchTo().alert().accept();
        psFileInformationPanel.switchToLastTab();
        psFileInformationPanel.switchToNewWindow();
        TxtFileViewPage txtFileViewPage = new TxtFileViewPage();
        txtFileViewPage.verifyFileVersionContent(fileContent);
        WebDriverRunner.getWebDriver().close();
        WebDriverRunner.getWebDriver().switchTo().window(winHandleBefore);
    }

    @Step("Edit metadata text field")
    public void editMetadataTextField(String fileName, SelenideElement element, String data) {
        PSFileInformationPanel psFileInformationPanel = new PSFileInformationPanel(fileName);
        psFileInformationPanel.getSaveButton().shouldBe(Condition.enabled);
        element.click();
        element.clear();
        element.shouldBe(Condition.empty);
        element.setValue(data);
        psFileInformationPanel.getSaveButton().click();
    }
}
