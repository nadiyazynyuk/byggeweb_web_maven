package dk.byggeweb.desktop.companyspace;

import dk.byggeweb.infrastructure.test.DesktopTestBase;
import dk.byggeweb.objects.desktop.companyspace.CompanySpacePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddRemoveCompanyVaultUser extends DesktopTestBase {

    @BeforeClass
    public void removeVaultUserIfPresent() {
        homePage.navigateToCompanySpace();
        CompanySpacePage companySpacePage = new CompanySpacePage();
        companySpacePage.navigateToVaultUsers();

        while (true) {
            try {
                vaultUsersSteps.removeCompanyVaultUser(data.getVaultUsername());
                vaultUsersSteps.verifyNameIsAbsentInTable(data.getTestFileName());
            } catch (com.codeborne.selenide.ex.ElementNotFound e) {
                break;
            }
        }
    }

    @Test(description = "Add new user to Company Vault users")
    public void addVaultUser() {
        vaultUsersSteps.addCompanyVaultUser(data.getVaultUsername());
        vaultUsersSteps.verifyNameIsPresentInTable(data.getVaultUsername());
    }

    @Test(dependsOnMethods = "addVaultUser", description = "Remove user from Company Vault users")
    public void removeVaultUser() {
        vaultUsersSteps.removeCompanyVaultUser(data.getVaultUsername());
        vaultUsersSteps.verifyNameIsAbsentInTable(data.getTestFileName());
    }
}
