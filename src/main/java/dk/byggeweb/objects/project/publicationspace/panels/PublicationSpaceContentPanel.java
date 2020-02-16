package dk.byggeweb.objects.project.publicationspace.panels;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class PublicationSpaceContentPanel extends PublicationSpaceNodesPanel {

    public SelenideElement getFileByName(String name) {
        return $(byXpath("//tr[@class='  x-grid-row']//*[contains(text(),'" + name + "')]"));
    }
}
