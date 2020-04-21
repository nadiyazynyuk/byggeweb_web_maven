package dk.byggeweb.project.publicationspace.withapproval.lists;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import io.qameta.allure.Link;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AssociateList extends ProjectTestBase {

    private boolean isAssociated;

    @Link(url = "https://itwofm.atlassian.net/browse/TSB-53")

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToDistributionSpace();
        dsFolderSteps.openDistributionList(data.getDistributionListName());
        isAssociated = dsFolderSteps.getListIsPresent(data.getDocumentListName());
    }

    @Test(description = "Change association of the Document list with the Distribution list")
    public void changeDocumentListAssociation() {
        projectHomePage.navigateToPublicationSpace();
        psFolderSteps.openDocumentList(data.getDocumentListName());
        psFolderSteps.changeListAssociation(data.getDistributionListName());
        projectHomePage.navigateToDistributionSpace();
        dsFolderSteps.openDistributionList(data.getDistributionListName());
        if (isAssociated) {
            dsFolderSteps.verifyListIsNotPresent(data.getDocumentListName());
        } else {
            dsFolderSteps.verifyListIsPresent(data.getDocumentListName());
        }
    }

}
