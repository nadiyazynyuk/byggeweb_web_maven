package dk.byggeweb.desktop.personalspace;

import dk.byggeweb.infrastructure.steps.GeneralSteps;
import dk.byggeweb.infrastructure.test.DesktopTestBase;
import dk.byggeweb.objects.desktop.HomePage;
import dk.byggeweb.objects.desktop.personalspace.MySettingsPage;
import dk.byggeweb.objects.desktop.personalspace.PersonalSpacePage;
import org.testng.annotations.Test;

public class UpdateUserData extends DesktopTestBase {

    // https://itwofm.atlassian.net/browse/TSB-12

    @Test(description = "Change first name in Personal settings")
    public void changeFirstName() {
        HomePage homePage = GeneralSteps.loginAsVerifiedUser(data.getUserName(), data.getPassword(), data.getName());
        homePage.navigateToPersonalSpace();
        PersonalSpacePage personalSpacePage = new PersonalSpacePage();

        personalSpacePage.navigateToMySettings();
        MySettingsPage mySettingsPage = new MySettingsPage();
        mySettingsPage.verifyPageIsLoaded(mySettingsPage.getMySettingsLabel());

        mySettingsPage.changePersonalData(data.getNewName());
        mySettingsPage.verifyCurrentUser(data.getNewName());

        mySettingsPage.changePersonalData(data.getName());
        mySettingsPage.verifyCurrentUser(data.getName());
    }

}
