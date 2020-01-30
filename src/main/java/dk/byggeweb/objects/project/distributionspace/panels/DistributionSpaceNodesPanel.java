package dk.byggeweb.objects.project.distributionspace.panels;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.project.ProjectHomePage;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class DistributionSpaceNodesPanel extends ProjectHomePage {

    private SelenideElement distributionSpaceParentNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Distribution space')]"));

}
