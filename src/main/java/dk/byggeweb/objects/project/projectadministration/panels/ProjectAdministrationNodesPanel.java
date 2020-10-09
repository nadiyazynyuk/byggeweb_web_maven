package dk.byggeweb.objects.project.projectadministration.panels;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.project.ProjectHomePage;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class ProjectAdministrationNodesPanel extends ProjectHomePage {

    private final SelenideElement projectAdministrationParentNode = $(byXpath("//td[contains(@class, 'WMP_90')]"));
    private final SelenideElement systemInformationNode = $(byXpath("//td[contains(@class, 'WMP_91')]"));
    private final SelenideElement approvalNode = $(byXpath("//td[contains(@class, 'WMP_92')]"));
    private final SelenideElement backupOrdersNode = $(byXpath("//td[contains(@class, 'WMP_95')]"));
    private final SelenideElement printOrdersNode = $(byXpath("//td[contains(@class, 'WMP_96')]"));
    private final SelenideElement groupsNode = $(byXpath("//td[contains(@class, 'WMP_99')]"));
    private final SelenideElement usersNode = $(byXpath("//td[contains(@class, 'WMP_101')]"));

    @Step("Navigate to System Information")
    public void navigateToSystemInformation() {
        systemInformationNode.click();
        new PASystemInformationContentPanel();
    }

    @Step("Navigate to Approval")
    public void navigateToApproval() {
        approvalNode.click();
        new PAApprovalContentPanel();
    }

    @Step("Navigate to Backup orders")
    public void navigateToBackupOrders() {
        backupOrdersNode.click();
        new PABackupOrdersContentPanel();
    }

    @Step("Navigate to Print orders")
    public void navigateToPrintOrders() {
        printOrdersNode.click();
        new PAPrintOrdersContentPanel();
    }

    @Step("Navigate to Groups")
    public void navigateToGroups() {
        groupsNode.click();
        new PAGroupsContentPanel();
    }

    @Step("Navigate to Users")
    public void navigateToUsers() {
        usersNode.click();
        new PAUsersContentPanel();
    }

    public ProjectAdministrationNodesPanel() {
        projectAdministrationParentNode.shouldBe(visible);
    }

}
