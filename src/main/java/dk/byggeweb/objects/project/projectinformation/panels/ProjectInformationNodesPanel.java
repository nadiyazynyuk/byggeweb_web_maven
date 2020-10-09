package dk.byggeweb.objects.project.projectinformation.panels;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.project.ProjectHomePage;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class ProjectInformationNodesPanel extends ProjectHomePage {

    private final SelenideElement projectInformationParentNode = $(byXpath("//td[contains(@class, 'WMP_1')]"));
    private final SelenideElement projectNameAndDescriptionNode = $(byXpath("//td[contains(@class, 'WMP_2')]"));
    private final SelenideElement administratorsNode = $(byXpath("//td[contains(@class, 'WMP_3')]"));
    private final SelenideElement areasOfResponsibilityNode = $(byXpath("//td[contains(@class, 'WMP_4')]"));

    @Step("Navigate to Project name and description")
    public void navigateToProjectDescription() {
        projectNameAndDescriptionNode.click();
        new PIProjectNameAndDescriptionContentPanel();
    }

    @Step("Navigate to Administrators")
    public void navigateToAdministrators() {
        administratorsNode.click();
        new PIAdministratorsContentPanel();
    }

    @Step("Navigate to Areas of Responsibility")
    public void navigateToAreasOfResponsibility() {
        areasOfResponsibilityNode.click();
        new PIAreasOfResponsibilityContentPanel();
    }

    public ProjectInformationNodesPanel() {
        projectInformationParentNode.shouldBe(visible);
    }
}
