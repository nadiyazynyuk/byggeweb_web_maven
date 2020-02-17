package dk.byggeweb.steps.project.publicationspace;

import dk.byggeweb.objects.project.publicationspace.panels.PSFolderContentPanel;
import dk.byggeweb.objects.project.publicationspace.panels.PublicationSpaceNodesPanel;

public class PSFolderSteps {

    public void navigateToFolderInDocumentList(String documentListName, String folderName) {
        PublicationSpaceNodesPanel publicationSpaceNodesPanel = new PublicationSpaceNodesPanel();
        publicationSpaceNodesPanel.getDocumentListNodeByName(documentListName).doubleClick();
        PSFolderContentPanel psFolderContentPanel = new PSFolderContentPanel();
        psFolderContentPanel.getDocumentListNodeByName(folderName).click();
        new PSFolderContentPanel(folderName);
    }

}
