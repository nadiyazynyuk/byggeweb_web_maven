package dk.byggeweb.objects.project.workspace.panels;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MonitoredFilesContentPanel extends WorkspaceContentPanel {

    private SelenideElement panelTitle = $(byXpath("//div[contains(@class, 'x-title-text x-title-text-default') and contains(text(), 'Monitored files')]"));

    @Step("Stop monitor file")
    public void stopMonitorFile(String filename) {
        clickOnFile(filename);
        getFileMonitorButton().click();
    }

    public MonitoredFilesContentPanel() {
        panelTitle.shouldBe(visible);
    }
}
