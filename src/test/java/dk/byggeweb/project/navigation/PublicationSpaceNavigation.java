package dk.byggeweb.project.navigation;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import org.testng.annotations.Test;

public class PublicationSpaceNavigation extends ProjectTestBase {

    @Test(description = "Navigate through Publication space nodes")
    public void publicationSpaceNavigation() {
        projectHomePage.navigateToPublicationSpace();

        projectHomePage.getPublicationSpaceNodesPanel().navigateToRootDocumentList();
        projectHomePage.getPublicationSpaceNodesPanel().navigateToVersionSets();
        projectHomePage.getPublicationSpaceNodesPanel().navigateToWaitingForApproval();
        projectHomePage.getPublicationSpaceNodesPanel().navigateToRejectedFileVersions();
        projectHomePage.getPublicationSpaceNodesPanel().navigateToUnpublishedFileVersions();
        projectHomePage.getPublicationSpaceNodesPanel().navigateToFilesNotDistributed();
        projectHomePage.getPublicationSpaceNodesPanel().navigateToRecentlyApprovedFileVersions();
        projectHomePage.getPublicationSpaceNodesPanel().navigateToRecentlyPublishedFileVersions();
        projectHomePage.getPublicationSpaceNodesPanel().navigateToRecentlyReleasedFileVersions();
        projectHomePage.getPublicationSpaceNodesPanel().navigateToMonitoredFolders();
        projectHomePage.getPublicationSpaceNodesPanel().navigateToMonitoredFiles();
        projectHomePage.getPublicationSpaceNodesPanel().navigateToSearch();
    }
}
