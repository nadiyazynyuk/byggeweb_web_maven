package dk.byggeweb.objects.project.personaloverviews.panels;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.project.ProjectHomePage;
import lombok.Getter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class PersonalOverviewsNodesPanel extends ProjectHomePage {

    private SelenideElement personalOverviewsParentNode = $(byXpath("//td[contains(@class, 'WMP_130')]"));
    private SelenideElement projectSettingsNode = $(byXpath("//td[contains(@class, 'WMP_131')]"));
    private SelenideElement printOrdersNode = $(byXpath("//td[contains(@class, 'WMP_132')]"));
    private SelenideElement userLogNode = $(byXpath("//td[contains(@class, 'WMP_133')]"));
    private SelenideElement backupOrdersNode = $(byXpath("//td[contains(@class, 'WMP_134')]"));

    public PersonalOverviewsNodesPanel() {
        personalOverviewsParentNode.shouldBe(visible);
    }

}
