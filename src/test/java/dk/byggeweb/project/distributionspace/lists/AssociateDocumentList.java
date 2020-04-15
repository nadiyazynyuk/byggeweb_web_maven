package dk.byggeweb.project.distributionspace.lists;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import io.qameta.allure.Link;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AssociateDocumentList extends ProjectTestBase {

    @Link(url = "https://itwofm.atlassian.net/browse/TSB-73")

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToDistributionSpace();
        try {
            dsFolderSteps.openDistributionList(data.getDistributionListName());
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            dsFolderSteps.createCoordinatorDistributionList(data.getDistributionListName());
            dsFolderSteps.openDistributionList(data.getDistributionListName());
        }

        boolean isAssociated = dsFolderSteps.getListIsPresent(data.getDocumentListName());
        while (true) {
            if (isAssociated) {
                try {
                    dsFolderSteps.changeDocumentListAssociation(data.getDocumentListName());
                    isAssociated = false;
                } catch (com.codeborne.selenide.ex.ElementNotFound e) {
                    break;
                }
            } else {
                break;
            }
        }
    }


    @Test(description = "Add association of the Distribution list with the Document list")
    public void associateDocumentList() {
        dsFolderSteps.changeDocumentListAssociation(data.getDocumentListName());
        Assert.assertTrue(dsFolderSteps.getListIsPresent(data.getDocumentListName()));
    }

    @Test(dependsOnMethods = "associateDocumentList", description = "Remove association of the Distribution list with the Document list")
    public void removeDocumentListAssociation() {
        dsFolderSteps.changeDocumentListAssociation(data.getDocumentListName());
        Assert.assertFalse(dsFolderSteps.getListIsPresent(data.getDocumentListName()));
    }

}
