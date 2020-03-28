package dk.byggeweb.steps.project.publicationspace;

import dk.byggeweb.objects.project.publicationspace.modals.*;
import dk.byggeweb.objects.project.publicationspace.panels.*;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;

import static com.codeborne.selenide.Condition.text;

@Log4j
public class PSFolderSteps {

    @Step("Navigate to Document list")
    public void navigateToDocumentList(String documentListName) {
        PublicationSpaceNodesPanel publicationSpaceNodesPanel = new PublicationSpaceNodesPanel();
        publicationSpaceNodesPanel.getDocumentListNodeByName(documentListName).click();
        log.info("Document list " + documentListName + " was selected");
        new PSSingleDocumentListContentPanel();
    }

    @Step("Open Document list")
    public void openDocumentList(String documentListName) {
        PublicationSpaceNodesPanel publicationSpaceNodesPanel = new PublicationSpaceNodesPanel();
        publicationSpaceNodesPanel.getDocumentListNodeByName(documentListName).doubleClick();
        log.info("Document list " + documentListName + " was opened");
        new PSSingleDocumentListContentPanel();
    }

    @Step("Navigate to the Folder inside Document list")
    public void navigateToFolderInsideDocumentList(String folderName) {
        PSFolderContentPanel psFolderContentPanel = new PSFolderContentPanel();
        psFolderContentPanel.getDocumentListNodeByName(folderName).click();
        log.info("Folder " + folderName + " was selected");
        new PSFolderContentPanel(folderName);
    }

    @Step("Navigate to Information inside Document list")
    public void navigateToInformation(String listName) {
        PSFolderContentPanel psFolderContentPanel = new PSFolderContentPanel();
        psFolderContentPanel.getDocumentListNodeByName("Information").click();
        log.info("Information section of the Document list " + listName + " was selected");
        new PSListInformationPanel(listName);
    }

    @Step("Navigate to the Folder in Document list")
    public void navigateToFolderInDocumentList(String documentListName, String folderName) {
        PublicationSpaceNodesPanel publicationSpaceNodesPanel = new PublicationSpaceNodesPanel();
        publicationSpaceNodesPanel.getDocumentListNodeByName(documentListName).doubleClick();
        PSFolderContentPanel psFolderContentPanel = new PSFolderContentPanel();
        psFolderContentPanel.getDocumentListNodeByName(folderName).click();
        log.info("Folder " + folderName + " in Document list " + documentListName + " was selected");
        new PSFolderContentPanel(folderName);
    }

    @Step("Create new Document list without approval procedure")
    public void createDocumentList(String createListName) {
        PublicationSpaceNodesPanel publicationSpaceNodesPanel = new PublicationSpaceNodesPanel();
        publicationSpaceNodesPanel.navigateToRootDocumentList();
        PSDocumentListsContentPanel psDocumentListsContentPanel = new PSDocumentListsContentPanel();
        psDocumentListsContentPanel.getCreateDocumentListButton().click();
        log.info("Create Document list button was clicked");
        psDocumentListsContentPanel.switchToNewWindow();
        PSListCreatePopup psListCreatePopup = new PSListCreatePopup();
        psListCreatePopup.createDocumentList(createListName);
        log.info("Document list " + createListName + " was created");
        psDocumentListsContentPanel.switchToLastTab();
    }

    @Step("Create document list with approval procedure")
    public void createDocumentListWithApproval(String createListName, String approvalProcedureName) {
        PublicationSpaceNodesPanel publicationSpaceNodesPanel = new PublicationSpaceNodesPanel();
        publicationSpaceNodesPanel.navigateToRootDocumentList();
        PSDocumentListsContentPanel psDocumentListsContentPanel = new PSDocumentListsContentPanel();
        psDocumentListsContentPanel.getCreateDocumentListButton().click();
        log.info("Create Document list button was clicked");
        psDocumentListsContentPanel.switchToNewWindow();
        PSListCreatePopup psListCreatePopup = new PSListCreatePopup();
        psListCreatePopup.createDocumentList(createListName, approvalProcedureName);
        log.info("Document list " + createListName + " was created with approval procedure " + approvalProcedureName);
        psDocumentListsContentPanel.switchToLastTab();
    }

    @Step("Rename Document list")
    public void renameDocumentList(String renameListName) {
        PSSingleDocumentListContentPanel psSingleDocumentListContentPanel = new PSSingleDocumentListContentPanel();
        psSingleDocumentListContentPanel.getEditDocumentListButton().click();
        log.info("Edit Document list button was clicked");
        psSingleDocumentListContentPanel.switchToNewWindow();
        PSListCreatePopup psListCreatePopup = new PSListCreatePopup();
        psListCreatePopup.renameDocumentList(renameListName);
        log.info("Document list was renamed to " + renameListName);
        psSingleDocumentListContentPanel.switchToLastTab();
    }

    @Step("Delete Document list")
    public void deleteDocumentList() {
        PSSingleDocumentListContentPanel psSingleDocumentListContentPanel = new PSSingleDocumentListContentPanel();
        psSingleDocumentListContentPanel.getDeleteDocumentListButton().click();
        log.info("Delete Document list button was clicked");
        psSingleDocumentListContentPanel.switchToNewWindow();
        PSListDeletePopup psListDeletePopup = new PSListDeletePopup();
        psListDeletePopup.deleteList();
        log.info("Document list was deleted");
        psSingleDocumentListContentPanel.switchToLastTab();
        new PSDocumentListsContentPanel();
    }

    @Step("Create folder in Document list")
    public void createFolder(String createFolderName) {
        PSSingleDocumentListContentPanel psSingleDocumentListContentPanel = new PSSingleDocumentListContentPanel();
        psSingleDocumentListContentPanel.getCreateFolderButton().click();
        log.info("Create folder button was clicked");
        psSingleDocumentListContentPanel.switchToNewWindow();
        PSFolderCreatePopup psFolderCreatePopup = new PSFolderCreatePopup();
        psFolderCreatePopup.createFolder(createFolderName);
        log.info("Folder " + createFolderName + " was created");
        psSingleDocumentListContentPanel.switchToLastTab();
    }

    @Step("Rename folder in Document list")
    public void renameFolder(String renameFolderName) {
        PSSingleDocumentListContentPanel psSingleDocumentListContentPanel = new PSSingleDocumentListContentPanel();
        psSingleDocumentListContentPanel.getRenameFolderButton().click();
        log.info("Rename folder button was clicked");
        psSingleDocumentListContentPanel.switchToNewWindow();
        PSFolderCreatePopup psFolderCreatePopup = new PSFolderCreatePopup();
        psFolderCreatePopup.renameFolder(renameFolderName);
        log.info("Folder was renamed to " + renameFolderName);
        psSingleDocumentListContentPanel.switchToLastTab();
    }

    @Step("Delete folder in Document list")
    public void deleteFolder() {
        PSSingleDocumentListContentPanel psSingleDocumentListContentPanel = new PSSingleDocumentListContentPanel();
        psSingleDocumentListContentPanel.getDeleteFolderButton().click();
        log.info("Delete folder button was clicked");
        psSingleDocumentListContentPanel.switchToNewWindow();
        PSFolderDeletePopup psFolderDeletePopup = new PSFolderDeletePopup();
        psFolderDeletePopup.deleteFolder();
        log.info("Folder was deleted");
        psSingleDocumentListContentPanel.switchToLastTab();
    }

    @Step("Get Document list association status")
    public boolean getListAssociationStatus(String listName) {
        return new PSListInformationPanel(listName).isListAssociated(listName);
    }

    @Step("Add Document list association with Distribution list")
    public void changeListAssociation(String distributionListName) {
        PublicationSpaceContentPanel publicationSpaceContentPanel = new PublicationSpaceContentPanel();
        publicationSpaceContentPanel.getAssociateDocumentListButton().click();
        log.info("Associate distribution list button was clicked");
        publicationSpaceContentPanel.switchToNewWindow();
        PSListAssociatingPopup psListAssociatingPopup = new PSListAssociatingPopup();
        psListAssociatingPopup.associateList(distributionListName);
        log.info("Document list was associated with distribution list " + distributionListName);
        publicationSpaceContentPanel.switchToLastTab();
    }

    @Step("Verify list is present")
    public void verifyListIsPresent(String name) {
        PublicationSpaceNodesPanel publicationSpaceNodesPanel = new PublicationSpaceNodesPanel();
        publicationSpaceNodesPanel.getDocumentListNodeByName(name).shouldHave(text(name));
    }

    @Step("Verify list is not present")
    public void verifyListIsNotPresent(String name) {
        PublicationSpaceNodesPanel publicationSpaceNodesPanel = new PublicationSpaceNodesPanel();
        publicationSpaceNodesPanel.getDocumentListNodeByName(name).shouldNotHave(text(name));
    }

    @Step("Verify folder is present")
    public void verifyFolderIsPresent(String name) {
        PublicationSpaceNodesPanel publicationSpaceNodesPanel = new PublicationSpaceNodesPanel();
        publicationSpaceNodesPanel.getDocumentListNodeByName(name).shouldHave(text(name));
    }

    @Step("Verify folder is not present")
    public void verifyFolderIsNotPresent(String name) {
        PublicationSpaceNodesPanel publicationSpaceNodesPanel = new PublicationSpaceNodesPanel();
        publicationSpaceNodesPanel.getDocumentListNodeByName(name).shouldNotHave(text(name));
    }


}
