package dk.byggeweb.steps.project.publicationspace;

import dk.byggeweb.objects.project.publicationspace.modals.PSListCreatePopup;
import dk.byggeweb.objects.project.publicationspace.modals.PSListDeletePopup;
import dk.byggeweb.objects.project.publicationspace.panels.PSDocumentListsContentPanel;
import dk.byggeweb.objects.project.publicationspace.panels.PSFolderContentPanel;
import dk.byggeweb.objects.project.publicationspace.panels.PSSingleDocumentListContentPanel;
import dk.byggeweb.objects.project.publicationspace.panels.PublicationSpaceNodesPanel;
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

    @Step("Navigate to the Folder in Document list")
    public void navigateToFolderInDocumentList(String documentListName, String folderName) {
        PublicationSpaceNodesPanel publicationSpaceNodesPanel = new PublicationSpaceNodesPanel();
        publicationSpaceNodesPanel.getDocumentListNodeByName(documentListName).doubleClick();
        PSFolderContentPanel psFolderContentPanel = new PSFolderContentPanel();
        psFolderContentPanel.getDocumentListNodeByName(folderName).click();
        log.info("Folder " + folderName + " in Document list " + documentListName + " was selected");
        new PSFolderContentPanel(folderName);
    }

    @Step("Create new Document list")
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

    @Step("Rename Document list")
    public void renameDocumentList(String renameListName) {
        PSSingleDocumentListContentPanel psSingleDocumentListContentPanel = new PSSingleDocumentListContentPanel();
        psSingleDocumentListContentPanel.getEditDocumentListButton().click();
        log.info("Edit Document list button was clicked");
        psSingleDocumentListContentPanel.switchToNewWindow();
        PSListCreatePopup psListCreatePopup = new PSListCreatePopup();
        psListCreatePopup.renameDocumentList(renameListName);
        log.info("Document list " + renameListName + " was renamed");
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



    @Step("Verify list is present")
    public void verifyListIsPresent(String name) {
        PublicationSpaceNodesPanel publicationSpaceNodesPanel = new PublicationSpaceNodesPanel();
        publicationSpaceNodesPanel.getDocumentListNodeByName(name).shouldHave(text(name));
    }

    @Step("Verify list is not present")
    public void verifyListIsNotPresent(String name) {

    }

    @Step("Verify folder is present")
    public void verifyFolderIsPresent(String name) {

    }

    @Step("Verify folder is not present")
    public void verifyFolderIsNotPresent(String name) {

    }


}
