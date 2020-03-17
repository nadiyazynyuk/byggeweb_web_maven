package dk.byggeweb.objects.project.versionsets.panels;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.project.ProjectHomePage;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class VersionSetsNodesPanel extends ProjectHomePage {

    public SelenideElement getVersionSetByName(String name) {
        return $(By.xpath("//span[@class='x-tree-node-text ' and contains(text(), '" + name + "')]"));
    }

    private SelenideElement workspaceInVersionSet = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), '[Workspace]')]"));
    private SelenideElement publicationSpaceInVersionSet = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), '[Publication space]')]"));
    private SelenideElement messagesInVersionSet = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Messages')]"));
    private SelenideElement logInVersionSet = $(byXpath("//span[@class='x-tree-node-text ' and contains(text(), 'Log')]"));

    private SelenideElement newVersionSetButton = $(byXpath("//span[@data-locator='locator-btn-new_versionset']"));
    private SelenideElement editVersionSetButton = $(byXpath("//span[@data-locator='locator-btn-edit_versionset']"));
    private SelenideElement deleteVersionSetButton = $(byXpath("//span[@data-locator='locator-btn-delete_versionset']"));
}
