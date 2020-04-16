package dk.byggeweb.project.versionsets;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import io.qameta.allure.Link;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddRemoveFileFromPublicationSpace extends ProjectTestBase {

    @Link(url = "https://itwofm.atlassian.net/browse/TSB-50")

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToPublicationSpace();
        projectHomePage.getPublicationSpaceNodesPanel().openVersionSets();
        versionSetsSteps.openVersionSetPublicationSpace(data.getVersionSetName());

        try {
            versionSetsSteps.removeFileFromPublicationSpaceVersionSet(data.getDocumentListName() + "/" + data.getDocumentListFolderName(), data.getTestFileName());
        } catch (com.codeborne.selenide.ex.ElementNotFound ignored) {
        }

        psFolderSteps.navigateToFolderInDocumentList(data.getDocumentListName(), data.getDocumentListFolderName());
        uploadFileIfNotPresentInDocumentListFolder(data.getFileToUploadPath(), data.getTestFileName());
    }

    @Test(description = "Add file to version set")
    public void addFileToVersionSet() {
        psFileSteps.addFileToVersionSet(data.getTestFileName(), data.getVersionSetName());
        projectHomePage.getPublicationSpaceNodesPanel().navigateToVersionSets();
        versionSetsSteps.navigateToVersionSetPublicationSpace(data.getVersionSetName());
        versionSetsSteps.verifyFileIsPresent(data.getDocumentListName() + "/" + data.getDocumentListFolderName(), data.getTestFileName());
    }

    @Test(dependsOnMethods = "addFileToVersionSet", description = "Remove file from version set")
    public void removeFileFromVersionSet() {
        versionSetsSteps.removeFileFromPublicationSpaceVersionSet(data.getDocumentListName() + "/" + data.getDocumentListFolderName(), data.getTestFileName());
        versionSetsSteps.verifyFileIsNotPresent(data.getDocumentListName() + "/" + data.getDocumentListFolderName(), data.getTestFileName());
    }

}
