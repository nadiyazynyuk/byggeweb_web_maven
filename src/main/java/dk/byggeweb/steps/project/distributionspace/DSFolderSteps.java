package dk.byggeweb.steps.project.distributionspace;

import com.codeborne.selenide.WebDriverRunner;
import dk.byggeweb.objects.project.distributionspace.modals.*;
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

    @Step("Open Distribution list")
    public void openDistributionList(String distributionListName) {
        DistributionSpaceNodesPanel distributionSpaceNodesPanel = new DistributionSpaceNodesPanel();
        distributionSpaceNodesPanel.getDistributionListNodeByName(distributionListName).doubleClick();
        log.info("Distribution list " + distributionListName + " was opened");
        new DSSingleDistributionListContentPanel();
    }

    @Step("Navigate to Information inside Distribution list")
    public void navigateToInformation(String listName) {
        DSSingleDistributionListContentPanel dsSingleDistributionListContentPanel = new DSSingleDistributionListContentPanel();
        dsSingleDistributionListContentPanel.getDistributionListNodeByName("Information").click();
        log.info("Information section of the Distribution list " + listName + " was selected");
        new DSListInformationPanel(listName);
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

    @Step("Get Distribution list association status")
    public boolean getDistributionListAssociationStatus(String listName, String associatedListName) {
        return new DSListInformationPanel(listName).isListAssociated(associatedListName);
    }

    @Step("Add Distribution list association with another Distribution list")
    public void changeDistributionListAssociation(String distributionListName) {
        DSSingleDistributionListContentPanel dsSingleDistributionListContentPanel = new DSSingleDistributionListContentPanel();
        dsSingleDistributionListContentPanel.getAssociateDistributionListButton().click();
        log.info("Associate distribution list button was clicked");
        dsSingleDistributionListContentPanel.switchToNewWindow();
        DSDistributionListAssociatingPopup dsDistributionListAssociatingPopup = new DSDistributionListAssociatingPopup();
        dsDistributionListAssociatingPopup.associateList(distributionListName);
        log.info("Distribution list was associated with distribution list " + distributionListName);
        dsSingleDistributionListContentPanel.switchToLastTab();
    }

    @Step("Add Distribution list association with Document list")
    public void changeDocumentListAssociation(String documentListName) {
        DSSingleDistributionListContentPanel dsSingleDistributionListContentPanel = new DSSingleDistributionListContentPanel();
        dsSingleDistributionListContentPanel.getAssociateDocumentListButton().click();
        log.info("Associate document list button was clicked");
        dsSingleDistributionListContentPanel.switchToNewWindow();
        DSDocumentListAssociatingPopup dsDocumentListAssociatingPopup = new DSDocumentListAssociatingPopup();
        dsDocumentListAssociatingPopup.associateList(documentListName);
        log.info("Distribution list was associated with document list " + documentListName);
        dsSingleDistributionListContentPanel.switchToLastTab();
    }

    @Step("Distribute file from Distribution list")
    public void distributeFile(String fileName) {
        DSSingleDistributionListContentPanel dsSingleDistributionListContentPanel = new DSSingleDistributionListContentPanel();
        dsSingleDistributionListContentPanel.getFileDistributeButton().click();
        log.info("Distribute file button was clicked");
        dsSingleDistributionListContentPanel.switchToNewWindow();
        DSFileDistributionPopup dsFileDistributionPopup = new DSFileDistributionPopup();
        dsFileDistributionPopup.distributeFile(fileName);
        log.info("File " + fileName + " was distributed to distribution list");
        dsSingleDistributionListContentPanel.switchToLastTab();
    }

    @Step("Start folder monitoring")
    public void startMonitorFolder() {
        String winHandleBefore = WebDriverRunner.getWebDriver().getWindowHandle();
        DSFolderContentPanel dsFolderContentPanel = new DSFolderContentPanel();
        dsFolderContentPanel.getMonitorFolderButton().click();
        dsFolderContentPanel.switchToNewWindow();
        DSMonitorFolderPopup dsMonitorFolderPopup = new DSMonitorFolderPopup();
        dsMonitorFolderPopup.getOkButton().click();
        dsMonitorFolderPopup.getCloseButton().click();
        WebDriverRunner.getWebDriver().switchTo().window(winHandleBefore);
    }

    public boolean getListIsPresent(String name) {
        DSSingleDistributionListContentPanel dsSingleDistributionListContentPanel = new DSSingleDistributionListContentPanel();
        dsSingleDistributionListContentPanel.pleaseWait(1000);
        return dsSingleDistributionListContentPanel.getListByName(name).isDisplayed();
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
