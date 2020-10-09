package dk.byggeweb.objects.project.personaloverviews.panels;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.project.ProjectHomePage;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class PersonalOverviewsNodesPanel extends ProjectHomePage {

    private final SelenideElement personalOverviewsParentNode = $(byXpath("//td[contains(@class, 'WMP_130')]"));
    private final SelenideElement projectSettingsNode = $(byXpath("//td[contains(@class, 'WMP_131')]"));
    private final SelenideElement printOrdersNode = $(byXpath("//td[contains(@class, 'WMP_132')]"));
    private final SelenideElement userLogNode = $(byXpath("//td[contains(@class, 'WMP_133')]"));
    private final SelenideElement backupOrdersNode = $(byXpath("//td[contains(@class, 'WMP_134')]"));

    @Step("Navigate to Project settings")
    public void navigateToProjectSettings() {
        projectSettingsNode.click();
        new POProjectSettingsContentPanel();
    }

    @Step("Navigate to Print orders")
    public void navigateToPrintOrders() {
        printOrdersNode.click();
        new POPrintOrdersContentPanel();
    }

    @Step("Navigate to User log")
    public void navigateToUserLog() {
        userLogNode.click();
        new POUserLogContentPanel();
    }

    @Step("Navigate to Backup Orders")
    public void navigateToBackupOrders() {
        backupOrdersNode.click();
        new POBackupOrdersContentPanel();
    }

    public PersonalOverviewsNodesPanel() {
        personalOverviewsParentNode.shouldBe(visible);
    }

}
