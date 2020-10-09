package dk.byggeweb.objects.project.log.panels;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.project.ProjectHomePage;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class LogNodesPanel extends ProjectHomePage {

    private final SelenideElement logParentNode = $(byXpath("//td[contains(@class, 'WMP_110')]"));
    private final SelenideElement predefinedLogFiltersNode = $(byXpath("//td[contains(@class, 'WMP_111')]"));
    private final SelenideElement projectLogFiltersNode = $(byXpath("//td[contains(@class, 'WMP_116')]"));
    private final SelenideElement userLogFiltersNode = $(byXpath("//td[contains(@class, 'WMP_118')]"));

    @Step("Navigate to Predefined log filters")
    public void navigateToPredefinedLog() {
        predefinedLogFiltersNode.click();
        new LogPredefinedLogContentPanel();
    }

    @Step("Navigate to Project log filters")
    public void navigateToProjectLog() {
        projectLogFiltersNode.click();
        new LogProjectLogContentPanel();
    }

    @Step("Navigate to User log filters")
    public void navigateToUserLog() {
        userLogFiltersNode.click();
        new LogUserLogContentPanel();
    }

    public LogNodesPanel() {
        logParentNode.shouldBe(visible);
    }
}
