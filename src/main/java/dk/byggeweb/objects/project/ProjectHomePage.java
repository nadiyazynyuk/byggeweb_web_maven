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

    private SelenideElement projectInformation = $(byXpath("//span[@class='x-btn-inner x-btn-inner-default-small' and contains(text(), 'Project information')]"));
    private SelenideElement workspace = $(byXpath("//span[@class='x-btn-inner x-btn-inner-default-small' and contains(text(), 'Workspace')]"));
    private SelenideElement publicationSpace = $(byXpath("//span[@class='x-btn-inner x-btn-inner-default-small' and contains(text(), 'Publication space')]"));
    private SelenideElement distributionSpace = $(byXpath("//span[@class='x-btn-inner x-btn-inner-default-small' and contains(text(), 'Distribution space')]"));
    private SelenideElement communication = $(byXpath("//span[@class='x-btn-inner x-btn-inner-default-small' and contains(text(), 'Communication')]"));
    private SelenideElement projectAdministration = $(byXpath("//span[@class='x-btn-inner x-btn-inner-default-small' and contains(text(), 'Project administration')]"));
    private SelenideElement log = $(byXpath("//span[@class='x-btn-inner x-btn-inner-default-small' and contains(text(), 'Log')]"));
    private SelenideElement personalOverviews = $(byXpath("//span[@class='x-btn-inner x-btn-inner-default-small' and contains(text(), 'Personal overviews')]"));

    @Step("Navigate to Project Information")
    public void navigateToProjectInformation() {
        projectInformation.click();
        projectInformationNodesPanel = new ProjectInformationNodesPanel();
        projectInformationNodesPanel.getProjectInformationParentNode().shouldHave(text("Project information"));
    }

    @Step("Navigate to Workspace")
    public void navigateToWorkspaceModule() {
        workspace.click();
        workspaceNodesPanel = new WorkspaceNodesPanel();
        workspaceNodesPanel.getWorkspaceParentNode().shouldHave(text("Workspace"));
    }

    @Step("Navigate to Publication Space")
    public void navigateToPublicationSpace() {
        publicationSpace.click();
        publicationSpaceNodesPanel = new PublicationSpaceNodesPanel();
        publicationSpaceNodesPanel.getPublicationSpaceParentNode().shouldHave(text("Publication space"));
    }

    @Step("Navigate to Distribution Space")
    public void navigateToDistributionSpace() {
        distributionSpace.click();
        distributionSpaceNodesPanel = new DistributionSpaceNodesPanel();
        distributionSpaceNodesPanel.getDistributionSpaceParentNode().shouldHave(text("Distribution space"));
    }

    @Step("Navigate to Communication")
    public void navigateToCommunication() {
        communication.click();
        communicationNodesPanel = new CommunicationNodesPanel();
        communicationNodesPanel.getCommunicationParentNode().shouldHave(text("Communication"));
    }

    @Step("Navigate to Project Administration")
    public void navigateToProjectAdministration() {
        projectAdministration.click();
        projectAdministrationNodesPanel = new ProjectAdministrationNodesPanel();
        projectAdministrationNodesPanel.getProjectAdministrationParentNode().shouldHave(text("Project administration"));
    }

    @Step("Navigate to Log")
    public void navigateToLog() {
        log.click();
        logNodesPanel = new LogNodesPanel();
        logNodesPanel.getLogParentNode().shouldHave(text("Log"));
    }

    @Step("Navigate to Personal Overviews")
    public void navigateToPersonalOverviews() {
        personalOverviews.click();
        personalOverviewsNodesPanel = new PersonalOverviewsNodesPanel();
        personalOverviewsNodesPanel.getPersonalOverviewsParentNode().shouldHave(text("Personal overviews"));
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
