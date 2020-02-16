package dk.byggeweb.steps.project.workspace;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import dk.byggeweb.objects.project.common.TxtFileViewPage;
import dk.byggeweb.objects.project.workspace.panels.WSFileInformationPanel;
import io.qameta.allure.Step;

public class WSFileInformationSteps {

    @Step("Select file version")
    public void selectFileVersion(String fileName, String versionIndex) {
        WSFileInformationPanel wsFileInformationPanel = new WSFileInformationPanel(fileName);
        wsFileInformationPanel.getVersionSelector().click();
        wsFileInformationPanel.fileVersionSelector(versionIndex).click();
    }

    @Step("Open file")
    public void openFile(String fileName, String fileContent) {
        String winHandleBefore = WebDriverRunner.getWebDriver().getWindowHandle();
        WSFileInformationPanel wsFileInformationPanel = new WSFileInformationPanel(fileName);
        wsFileInformationPanel.getOpenButton().click();
        wsFileInformationPanel.switchToNewWindow();
        TxtFileViewPage txtFileViewPage = new TxtFileViewPage();
        txtFileViewPage.verifyFileVersionContent(fileContent);
        WebDriverRunner.getWebDriver().close();
        WebDriverRunner.getWebDriver().switchTo().window(winHandleBefore);
    }

    @Step("Open previous file version")
    public void openPreviousFileVersion(String fileName, String fileContent) {
        String winHandleBefore = WebDriverRunner.getWebDriver().getWindowHandle();
        WSFileInformationPanel wsFileInformationPanel = new WSFileInformationPanel(fileName);
        wsFileInformationPanel.getOpenButton().click();
        WebDriverRunner.getWebDriver().switchTo().alert().accept();
        wsFileInformationPanel.switchToLastTab();
        wsFileInformationPanel.switchToNewWindow();
        TxtFileViewPage txtFileViewPage = new TxtFileViewPage();
        txtFileViewPage.verifyFileVersionContent(fileContent);
        WebDriverRunner.getWebDriver().close();
        WebDriverRunner.getWebDriver().switchTo().window(winHandleBefore);
    }

    @Step("Edit metadata text field")
    public void editMetadataTextField(String fileName, SelenideElement element, String data) {
        WSFileInformationPanel wsFileInformationPanel = new WSFileInformationPanel(fileName);
        wsFileInformationPanel.getSaveButton().shouldBe(Condition.enabled);
        element.click();
        element.clear();
        element.shouldBe(Condition.empty);
        element.setValue(data);
        wsFileInformationPanel.getSaveButton().click();;
    }

}