package dk.byggeweb.objects.project.projectinformation.panels;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.project.ProjectHomePage;
import lombok.Getter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class ProjectInformationNodesPanel extends ProjectHomePage {

    private SelenideElement projectInformationParentNode = $(byXpath("//td[contains(@class, 'WMP_1')]"));
    private SelenideElement projectNameAndDescriptionNode = $(byXpath("//td[contains(@class, 'WMP_2')]"));
    private SelenideElement administratorsNode = $(byXpath("//td[contains(@class, 'WMP_3')]"));
    private SelenideElement areasOfResponsibilityNode = $(byXpath("//td[contains(@class, 'WMP_4')]"));

    public ProjectInformationNodesPanel() {
        projectInformationParentNode.shouldBe(visible);
    }
}
