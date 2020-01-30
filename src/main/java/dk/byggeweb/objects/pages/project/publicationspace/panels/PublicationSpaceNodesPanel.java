package dk.byggeweb.objects.pages.project.publicationspace.panels;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.pages.project.ProjectHomePage;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class PublicationSpaceNodesPanel extends ProjectHomePage {

    private SelenideElement publicationSpaceParentNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Publication space')]"));

}
