package dk.byggeweb.objects.project;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.PageBase;
import dk.byggeweb.objects.project.communication.panels.CommunicationNodesPanel;
import dk.byggeweb.objects.project.distributionspace.panels.DistributionSpaceNodesPanel;
import dk.byggeweb.objects.project.log.panels.LogNodesPanel;
import dk.byggeweb.objects.project.personaloverviews.panels.PersonalOverviewsNodesPanel;
import dk.byggeweb.objects.project.projectadministration.panels.ProjectAdministrationNodesPanel;
import dk.byggeweb.objects.project.projectinformation.panels.ProjectInformationNodesPanel;
import dk.byggeweb.objects.project.publicationspace.panels.PublicationSpaceNodesPanel;
import dk.byggeweb.objects.project.workspace.panels.WorkspaceNodesPanel;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class ProjectHomePage extends PageBase {

    public ProjectInformationNodesPanel projectInformationNodesPanel;
    public WorkspaceNodesPanel workspaceNodesPanel;
    public PublicationSpaceNodesPanel publicationSpaceNodesPanel;
    public DistributionSpaceNodesPanel distributionSpaceNodesPanel;
    public CommunicationNodesPanel communicationNodesPanel;
    public ProjectAdministrationNodesPanel projectAdministrationNodesPanel;
    public LogNodesPanel logNodesPanel;
    public PersonalOverviewsNodesPanel personalOverviewsNodesPanel;

    private SelenideElement projectTitleLabel = $(byXpath("//div[@class='WMP_Title']"));
    private SelenideElement projectInformation = $(byXpath("//a[contains(@class, 'WMP_module_14')]"));
    private SelenideElement workspace = $(byXpath("//a[contains(@class, 'WMP_module_1')]//span[contains(text(), 'Workspace')]"));
    private SelenideElement publicationSpace = $(byXpath("//a[contains(@class, 'WMP_module_3')]"));
    private SelenideElement distributionSpace = $(byXpath("//a[contains(@class, 'WMP_module_11')]"));
    private SelenideElement communication = $(byXpath("//a[contains(@class, 'WMP_module_4')]"));
    private SelenideElement projectAdministration = $(byXpath("//a[contains(@class, 'WMP_module_10')]"));
    private SelenideElement log = $(byXpath("//a[contains(@class, 'WMP_module_9')]"));
    private SelenideElement personalOverviews = $(byXpath("//a[contains(@class, 'WMP_module_18')]"));

    @Step("Navigate to Project Information")
    public void navigateToProjectInformation() {
        projectInformation.click();
        projectInformationNodesPanel = new ProjectInformationNodesPanel();
    }

    @Step("Navigate to Workspace")
    public void navigateToWorkspaceModule() {
        workspace.click();
        workspaceNodesPanel = new WorkspaceNodesPanel();
    }

    @Step("Navigate to Publication Space")
    public void navigateToPublicationSpace() {
        publicationSpace.click();
        publicationSpaceNodesPanel = new PublicationSpaceNodesPanel();
    }

    @Step("Navigate to Distribution Space")
    public void navigateToDistributionSpace() {
        distributionSpace.click();
        distributionSpaceNodesPanel = new DistributionSpaceNodesPanel();
    }

    @Step("Navigate to Communication")
    public void navigateToCommunication() {
        communication.click();
        communicationNodesPanel = new CommunicationNodesPanel();
    }

    @Step("Navigate to Project Administration")
    public void navigateToProjectAdministration() {
        projectAdministration.click();
        projectAdministrationNodesPanel = new ProjectAdministrationNodesPanel();
    }

    @Step("Navigate to Log")
    public void navigateToLog() {
        log.click();
        logNodesPanel = new LogNodesPanel();
    }

    @Step("Navigate to Personal Overviews")
    public void navigateToPersonalOverviews() {
        personalOverviews.click();
        personalOverviewsNodesPanel = new PersonalOverviewsNodesPanel();
    }

    @Step("Verify project title")
    public void verifyProjectTitle(String title) {
        projectTitleLabel.shouldHave(text(title));
    }

    public ProjectHomePage(String title) {
        verifyProjectTitle(title);
    }

    public ProjectHomePage() {
        super();
    }
}
