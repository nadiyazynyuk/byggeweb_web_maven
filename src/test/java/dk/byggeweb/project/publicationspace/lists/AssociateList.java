package dk.byggeweb.project.publicationspace.lists;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AssociateList extends ProjectTestBase {

    // https://itwofm.atlassian.net/browse/TSB-53

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToPublicationSpace();
        psFolderSteps.openDocumentList(data.getDocumentListName());
        psFolderSteps.navigateToInformation(data.getDocumentListName());

        boolean isAssociated = psFolderSteps.getListAssociationStatus(data.getDocumentListName());
        while (true) {
            if (isAssociated) {
                try {
                    psFolderSteps.changeListAssociation(data.getDistributionListName());
                    isAssociated = false;
                } catch (com.codeborne.selenide.ex.ElementNotFound e) {
                    break;
                }
            } else {
                break;
            }
        }
    }

    @Test(description = "Add association of the Document list with the Distribution list")
    public void addDocumentListAssociation() {
        psFolderSteps.changeListAssociation(data.getDistributionListName());
        Assert.assertTrue(psFolderSteps.getListAssociationStatus(data.getDocumentListName()));
    }

    @Test(dependsOnMethods = "addDocumentListAssociation", description = "Remove association of the Document list with Distribution list")
    public void removeDocumentListAssociation() {
        psFolderSteps.changeListAssociation(data.getDistributionListName());
        Assert.assertFalse(psFolderSteps.getListAssociationStatus(data.getDocumentListName()));
    }

}


/*
open list
check if associated

associate
check if associated
cancel association
check if not associated
 */
