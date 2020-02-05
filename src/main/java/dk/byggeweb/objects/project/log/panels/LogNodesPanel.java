package dk.byggeweb.objects.project.log.panels;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.project.ProjectHomePage;
import lombok.Getter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class LogNodesPanel extends ProjectHomePage {

    private SelenideElement logParentNode = $(byXpath("//td[contains(@class, 'WMP_110')]"));
    private SelenideElement predefinedLogFiltersNode = $(byXpath("//td[contains(@class, 'WMP_111')]"));
    private SelenideElement projectLogFiltersNode = $(byXpath("//td[contains(@class, 'WMP_116')]"));
    private SelenideElement userLogFiltersNode = $(byXpath("//td[contains(@class, 'WMP_118')]"));

    public LogNodesPanel() {
        logParentNode.shouldBe(visible);
    }
}
