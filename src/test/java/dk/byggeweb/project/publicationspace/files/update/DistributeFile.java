package dk.byggeweb.project.publicationspace.files.update;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DistributeFile extends ProjectTestBase {

    // https://itwofm.atlassian.net/browse/TSB-70

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToDistributionSpace();
        dsFolderSteps.navigateToFolderInDocumentListInDistributionList(data.getDistributionListName(), data.getDocumentListName(), data.getDocumentListFolderName());

        while(true) {
            try{
                dsFileSteps.cancelFileDistribution(data.getTestFileName());
            } catch (com.codeborne.selenide.ex.ElementNotFound e) {
                break;
            }
        }

        projectHomePage.navigateToPublicationSpace();
        psFolderSteps.navigateToFolderInDocumentList(data.getDocumentListName(), data.getDocumentListFolderName());
        uploadFileIfMNotPresentInDocumentListFolder(data.getFileToUploadPath(), data.getTestFileName());
    }

    @Test(description = "Distribute file from Document list")
    public void distributeFile() {
        psFileSteps.distributeFile(data.getTestFileName(), data.getDistributionListName());
        projectHomePage.navigateToDistributionSpace();
        dsFileSteps.verifyFileIsPresent(data.getTestFileName());
    }

}