package dk.byggeweb.steps.project.workspace;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import dk.byggeweb.objects.project.common.TxtFileViewPage;
import dk.byggeweb.objects.project.workspace.panels.FileInformationPanel;
import io.qameta.allure.Step;

public class WSFileInformationSteps {

    @Step("Select file version")
    public void selectFileVersion(String fileName, String versionIndex) {
        FileInformationPanel fileInformationPanel = new FileInformationPanel(fileName);
        fileInformationPanel.getVersionSelector().click();
        fileInformationPanel.fileVersionSelector(versionIndex).click();
    }

    @Step("Open file")
    public void openFile(String fileName, String fileContent) {
        String winHandleBefore = WebDriverRunner.getWebDriver().getWindowHandle();
        FileInformationPanel fileInformationPanel = new FileInformationPanel(fileName);
        fileInformationPanel.getOpenButton().click();
        fileInformationPanel.switchToNewWindow();
        TxtFileViewPage txtFileViewPage = new TxtFileViewPage();
        txtFileViewPage.verifyFileVersionContent(fileContent);
        WebDriverRunner.getWebDriver().close();
        WebDriverRunner.getWebDriver().switchTo().window(winHandleBefore);
    }

    @Step("Open previous file version")
    public void openPreviousFileVersion(String fileName, String fileContent) {
        String winHandleBefore = WebDriverRunner.getWebDriver().getWindowHandle();
        FileInformationPanel fileInformationPanel = new FileInformationPanel(fileName);
        fileInformationPanel.getOpenButton().click();
        WebDriverRunner.getWebDriver().switchTo().alert().accept();
        fileInformationPanel.switchToLastTab();
        fileInformationPanel.switchToNewWindow();
        TxtFileViewPage txtFileViewPage = new TxtFileViewPage();
        txtFileViewPage.verifyFileVersionContent(fileContent);
        WebDriverRunner.getWebDriver().close();
        WebDriverRunner.getWebDriver().switchTo().window(winHandleBefore);
    }

    @Step("Edit metadata text field")
    public void editMetadataTextField(String fileName, SelenideElement element, String data) {
        FileInformationPanel fileInformationPanel = new FileInformationPanel(fileName);
        fileInformationPanel.getSaveButton().shouldBe(Condition.enabled);
        element.click();
        element.clear();
        element.shouldBe(Condition.empty);
        element.setValue(data);
        fileInformationPanel.getSaveButton().click();;
    }

}
