package dk.byggeweb.steps.project.distributionspace;

import dk.byggeweb.objects.project.distributionspace.modals.DSListCreatePopup;
import dk.byggeweb.objects.project.distributionspace.modals.DSListDeletePopup;
import dk.byggeweb.objects.project.distributionspace.panels.*;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;

import static com.codeborne.selenide.Condition.text;

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

    @Step("Create Coordinator Distribution list")
    public void createCoordinatorDistributionList(String createListName) {
        DistributionSpaceNodesPanel distributionSpaceNodesPanel = new DistributionSpaceNodesPanel();
        distributionSpaceNodesPanel.navigateToRootDistributionList();
        DSDistributionListsContentPanel dsDistributionListsContentPanel = new DSDistributionListsContentPanel();
        dsDistributionListsContentPanel.getCreateDistributionListButton().click();
        log.info("Create Distribution list button was clicked");
        dsDistributionListsContentPanel.switchToNewWindow();
        DSListCreatePopup dsListCreatePopup = new DSListCreatePopup();
        dsListCreatePopup.createCoordinatorDistributionList(createListName);
        log.info("Coordinator Distribution list " + createListName + " was created");
        dsDistributionListsContentPanel.switchToLastTab();
    }

    @Step("Create Open Distribution list")
    public void createOpenDistributionList(String createListName) {
        DistributionSpaceNodesPanel distributionSpaceNodesPanel = new DistributionSpaceNodesPanel();
        distributionSpaceNodesPanel.navigateToRootDistributionList();
        DSDistributionListsContentPanel dsDistributionListsContentPanel = new DSDistributionListsContentPanel();
        dsDistributionListsContentPanel.getCreateDistributionListButton().click();
        log.info("Create Distribution list button was clicked");
        dsDistributionListsContentPanel.switchToNewWindow();
        DSListCreatePopup dsListCreatePopup = new DSListCreatePopup();
        dsListCreatePopup.createOpenDistributionList(createListName);
        log.info("Open Distribution list " + createListName + " was created");
        dsDistributionListsContentPanel.switchToLastTab();
    }

    @Step("Create Reserved Distribution list")
    public void createReservedDistributionList(String createListName) {
        DistributionSpaceNodesPanel distributionSpaceNodesPanel = new DistributionSpaceNodesPanel();
        distributionSpaceNodesPanel.navigateToRootDistributionList();
        DSDistributionListsContentPanel dsDistributionListsContentPanel = new DSDistributionListsContentPanel();
        dsDistributionListsContentPanel.getCreateDistributionListButton().click();
        log.info("Create Distribution list button was clicked");
        dsDistributionListsContentPanel.switchToNewWindow();
        DSListCreatePopup dsListCreatePopup = new DSListCreatePopup();
        dsListCreatePopup.createReservedDistributionList(createListName);
        log.info("Reserved Distribution list " + createListName + " was created");
        dsDistributionListsContentPanel.switchToLastTab();
    }

    @Step("Rename Distribution list")
    public void renameDistributionList(String createListName, String renameListName) {
        DistributionSpaceNodesPanel distributionSpaceNodesPanel = new DistributionSpaceNodesPanel();
        distributionSpaceNodesPanel.getDistributionListNodeByName(createListName).click();
        DSSingleDistributionListContentPanel dsSingleDistributionListContentPanel = new DSSingleDistributionListContentPanel();
        dsSingleDistributionListContentPanel.getEditDistributionListButton().click();
        log.info("Edit Distribution list button was clicked");
        dsSingleDistributionListContentPanel.switchToNewWindow();
        DSListCreatePopup dsListCreatePopup = new DSListCreatePopup();
        dsListCreatePopup.renameDistributionList(renameListName);
        log.info("Distribution list was renamed to " + renameListName);
        dsSingleDistributionListContentPanel.switchToLastTab();
    }

    @Step("Delete Distribution list")
    public void deleteDistributionList() {
        DSSingleDistributionListContentPanel dsSingleDistributionListContentPanel = new DSSingleDistributionListContentPanel();
        dsSingleDistributionListContentPanel.getDeleteDistributionListButton().click();
        log.info("Delete Distribution list button was clicked");
        dsSingleDistributionListContentPanel.switchToNewWindow();
        DSListDeletePopup dsListDeletePopup = new DSListDeletePopup();
        dsListDeletePopup.deleteList();
        log.info("Distribution list was deleted");
        dsSingleDistributionListContentPanel.switchToLastTab();
        new DSDistributionListsContentPanel();
    }

    @Step("Verify list is present")
    public void verifyListIsPresent(String name) {
        DistributionSpaceNodesPanel distributionSpaceNodesPanel = new DistributionSpaceNodesPanel();
        distributionSpaceNodesPanel.getDistributionListNodeByName(name).shouldHave(text(name));
    }

    @Step("Verify list is not present")
    public void verifyListIsNotPresent(String name) {
        DistributionSpaceNodesPanel distributionSpaceNodesPanel = new DistributionSpaceNodesPanel();
        distributionSpaceNodesPanel.getDistributionListNodeByName(name).shouldNotHave(text(name));
    }

}
