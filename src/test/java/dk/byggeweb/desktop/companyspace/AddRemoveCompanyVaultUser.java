package dk.byggeweb.desktop.companyspace;

import dk.byggeweb.infrastructure.test.DesktopTestBase;
import dk.byggeweb.objects.desktop.companyspace.CompanySpacePage;
import dk.byggeweb.objects.desktop.companyspace.VaultUsersPage;
import org.testng.annotations.BeforeClass;

public class AddRemoveCompanyVaultUser extends DesktopTestBase {

    private VaultUsersPage vaultUsersPage;

    @BeforeClass
    public void removeVaultUserIfPresent() {
        homePage.navigateToCompanySpace();
        CompanySpacePage companySpacePage = new CompanySpacePage();
        companySpacePage.navigateToVaultUsers();
        vaultUsersPage = new VaultUsersPage();

        while (true) {
            try {
                vaultUsersPage.removeCompanyVaultUser(data.getUserName());
                //remove user
            } catch (com.codeborne.selenide.ex.ElementNotFound e) {
                break;
            }
        }
    }
}
