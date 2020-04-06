package dk.byggeweb.steps.project.distributionspace;

import dk.byggeweb.objects.project.distributionspace.panels.DSDocumentListContentPanel;
import dk.byggeweb.objects.project.distributionspace.panels.DSFolderContentPanel;
import dk.byggeweb.objects.project.distributionspace.panels.DSSingleDistributionListContentPanel;
import dk.byggeweb.objects.project.distributionspace.panels.DistributionSpaceNodesPanel;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;

@Log4j
public class DSFolderSteps {

    @Step("Navigate to Distribution list")
    public void navigateToDistributionList(String distributionListName) {
        DistributionSpaceNodesPanel distributionSpaceNodesPanel = new DistributionSpaceNodesPanel();
        distributionSpaceNodesPanel.getDistributionListNodeByName(distributionListName).click();
        log.info("Distribution list " + distributionListName + " was selected");
        new DSSingleDistributionListContentPanel();
    }

    @Step("Navigate to the Folder in Document list in Distribution list")
    public void navigateToFolderInDocumentListInDistributionList(String distributionListName, String documentListName, String folderName) {
        DistributionSpaceNodesPanel distributionSpaceNodesPanel = new DistributionSpaceNodesPanel();
        distributionSpaceNodesPanel.getDistributionListNodeByName(distributionListName).doubleClick();
        DSSingleDistributionListContentPanel dsSingleDistributionListContentPanel = new DSSingleDistributionListContentPanel();
        dsSingleDistributionListContentPanel.getDistributionListNodeByName(documentListName).doubleClick();
        DSDocumentListContentPanel dsDocumentListContentPanel = new DSDocumentListContentPanel(documentListName);
        dsDocumentListContentPanel.getDistributionListNodeByName(folderName).click();
        new DSFolderContentPanel(folderName);
    }

}
