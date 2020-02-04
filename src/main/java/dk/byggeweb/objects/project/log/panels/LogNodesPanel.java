package dk.byggeweb.objects.project.log.panels;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.project.ProjectHomePage;
import lombok.Getter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class LogNodesPanel extends ProjectHomePage {

    private SelenideElement logParentNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Log')]"));
    private SelenideElement predefinedLogFiltersNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Predefined log filters')]"));
    private SelenideElement projectLogFiltersNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Project log filters')]"));
    private SelenideElement userLogFiltersNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'User log filters')]"));

    public LogNodesPanel() {
        logParentNode.shouldBe(visible);
    }
}
