package dk.byggeweb.objects.project.projectadministration.panels;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.project.ProjectHomePage;
import lombok.Getter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class ProjectAdministrationNodesPanel extends ProjectHomePage {

    private SelenideElement projectAdministrationParentNode = $(byXpath("//td[contains(@class, 'WMP_90')]"));
    private SelenideElement systemInformationNode = $(byXpath("//td[contains(@class, 'WMP_91')]"));
    private SelenideElement approvalNode = $(byXpath("//td[contains(@class, 'WMP_92')]"));
    private SelenideElement backupOrdersNode = $(byXpath("//td[contains(@class, 'WMP_95')]"));
    private SelenideElement printOrdersNode = $(byXpath("//td[contains(@class, 'WMP_96')]"));
    private SelenideElement groupsNode = $(byXpath("//td[contains(@class, 'WMP_99')]"));
    private SelenideElement usersNode = $(byXpath("//td[contains(@class, 'WMP_101')]"));

    public ProjectAdministrationNodesPanel() {
        projectAdministrationParentNode.shouldBe(visible);
    }

}
