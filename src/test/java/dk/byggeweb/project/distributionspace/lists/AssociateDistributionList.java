package dk.byggeweb.project.distributionspace.lists;

import dk.byggeweb.infrastructure.test.ProjectTestBase;
import io.qameta.allure.Link;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AssociateDistributionList extends ProjectTestBase {

    @Link(url = "https://itwofm.atlassian.net/browse/TSB-74")

    @BeforeClass
    public void prepareData() {
        projectHomePage.navigateToDistributionSpace();
        dsFolderSteps.openDistributionList(data.getDistributionListName());
        dsFolderSteps.navigateToInformation(data.getDistributionListName());

        boolean isAssociated = dsFolderSteps.getDistributionListAssociationStatus(data.getDistributionListName(), data.getDistributionList2Name());
        System.out.println("Associated ---> " + isAssociated);
        while (true) {
            if (isAssociated) {
                try {
                    dsFolderSteps.changeDistributionListAssociation(data.getDistributionList2Name());
                    isAssociated = false;
                } catch (com.codeborne.selenide.ex.ElementNotFound e) {
                    break;
                }
            } else {
                break;
            }
        }
    }

    @Test(description = "Add association of the Distribution list with the Distribution list")
    public void addDistributionListAssociation() {
        dsFolderSteps.changeDistributionListAssociation(data.getDistributionList2Name());
        Assert.assertTrue(dsFolderSteps.getDistributionListAssociationStatus(data.getDistributionListName(), data.getDistributionList2Name()));
    }

    @Test(dependsOnMethods = "addDistributionListAssociation", description = "Remove association of the Distribution list with Distribution list")
    public void removeDistributionListAssociation() {
        dsFolderSteps.changeDistributionListAssociation(data.getDistributionList2Name());
        Assert.assertFalse(dsFolderSteps.getDistributionListAssociationStatus(data.getDistributionListName(), data.getDistributionList2Name()));
    }

}

// associate Coordinator list with another distribution list
// create coordinator list if not present
// check if associated