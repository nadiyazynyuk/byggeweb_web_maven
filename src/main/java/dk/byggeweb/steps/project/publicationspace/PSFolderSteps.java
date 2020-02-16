package dk.byggeweb.steps.project.publicationspace;

import dk.byggeweb.objects.project.publicationspace.panels.PSFolderContentPanel;
import dk.byggeweb.objects.project.publicationspace.panels.PSDocumentListsContentPanel;

public class PSFolderSteps {

    public void navigateToFolderInDocumentList(String documentListName, String folderName) {
        PSDocumentListsContentPanel panel = new PSDocumentListsContentPanel();
        panel.getDocumentListNodeByName(documentListName).doubleClick();
        panel.getDocumentListNodeByName(folderName).click();
        new PSFolderContentPanel(folderName);
    }

}
