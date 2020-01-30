package dk.byggeweb.objects.project.personaloverviews.panels;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.project.ProjectHomePage;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class PersonalOverviewsNodesPanel extends ProjectHomePage {

    private SelenideElement personalOverviewsParentNode = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Personal overviews')]"));

}
