package dk.byggeweb.objects.pages.project.log.panels;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.pages.project.ProjectHomePage;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class LogNodesPanel extends ProjectHomePage {

    private SelenideElement logParentNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Log')]"));

}
