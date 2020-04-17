package dk.byggeweb.project.versionsets;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import io.qameta.allure.Link;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddRemoveFileFromDistributionSpace extends ProjectTestBase {

    @Link(url = "https://itwofm.atlassian.net/browse/TSB-81")

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToPublicationSpace();
        projectHomePage.getPublicationSpaceNodesPanel().openVersionSets();
        versionSetsSteps.openVersionSetPublicationSpace(data.getVersionSetName());

        try {
            versionSetsSteps.removeFileFromPublicationSpaceVersionSet(data.getDocumentListName() + "/" + data.getDocumentListFolderName(), data.getTestFileName());
        } catch (com.codeborne.selenide.ex.ElementNotFound ignored) {
        }

        projectHomePage.navigateToDistributionSpace();
        dsFolderSteps.navigateToFolderInDocumentListInDistributionList(data.getDistributionListName(), data.getDocumentListName(), data.getDocumentListFolderName());

        try {
            dsFileSteps.verifyFileIsPresent(data.getTestFileName());
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            projectHomePage.navigateToPublicationSpace();
            psFolderSteps.navigateToFolderInDocumentList(data.getDocumentListName(), data.getDocumentListFolderName());
            uploadFileIfNotPresentInDocumentListFolder(data.getFileToUploadPath(), data.getTestFileName());
            psFileSteps.distributeFile(data.getTestFileName(), data.getDistributionListName());
            projectHomePage.navigateToDistributionSpace();
        }
    }

    @Test(description = "Add file to version set")
    public void addFileToVersionSet() {
        dsFileSteps.addFileToVersionSet(data.getTestFileName(), data.getVersionSetName());
        projectHomePage.getDistributionSpaceNodesPanel().openVersionSets();
        versionSetsSteps.openVersionSetPublicationSpace(data.getVersionSetName());
        versionSetsSteps.verifyFileIsPresent(data.getDocumentListName() + "/" + data.getDocumentListFolderName(), data.getTestFileName());
    }

    @Test(dependsOnMethods = "addFileToVersionSet", description = "Remove file from version set")
    public void removeFileFromVersionSet() {
        versionSetsSteps.removeFileFromPublicationSpaceVersionSet(data.getDocumentListName() + "/" + data.getDocumentListFolderName(), data.getTestFileName());
        versionSetsSteps.verifyFileIsNotPresent(data.getDocumentListName() + "/" + data.getDocumentListFolderName(), data.getTestFileName());
    }
}
