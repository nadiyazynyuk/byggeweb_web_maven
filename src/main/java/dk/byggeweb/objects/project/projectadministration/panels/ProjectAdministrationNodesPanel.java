package dk.byggeweb.objects.project.projectadministration.panels;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.project.ProjectHomePage;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class ProjectAdministrationNodesPanel extends ProjectHomePage {

    private SelenideElement projectAdministrationParentNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Project administration')]"));

}
