package dk.byggeweb.steps.desktop.companyspace;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.desktop.companyspace.VaultUsersPage;
import dk.byggeweb.objects.desktop.companyspace.modals.AddVaultUserPopup;
import dk.byggeweb.objects.desktop.companyspace.modals.EditVaultUserPopup;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

@Log4j2
public class VaultUsersSteps {

    private SelenideElement getRowByName(String name) {
        return $(byXpath("//div[@id='vaultusers_grid']//*[contains(text(),'" + name + "')]"));
    }

    @Step("Add Company vault user")
    public void addCompanyVaultUser(String name) {
        VaultUsersPage vaultUsersPage = new VaultUsersPage();
        vaultUsersPage.getAddButton().click();
        AddVaultUserPopup addVaultUserPopup = new AddVaultUserPopup();
        vaultUsersPage.switchToFrame(addVaultUserPopup.getIFrame());
        addVaultUserPopup.getSearchBox().setValue(name);
        addVaultUserPopup.getAddButton().click();
        addVaultUserPopup.getUserRadioButton().click();
        log.info("User " + name + " was selected");
        vaultUsersPage.switchToParentFrame();
        addVaultUserPopup.getOkButton().click();
        addVaultUserPopup.getOkButton().click();
        log.info("User " + name + " was added to Vault users");
    }

    @Step("Remove Company vault user")
    public void removeCompanyVaultUser(String name) {
        getRowByName(name).click();
        log.info("User " + name + " was selected");
        EditVaultUserPopup editVaultUserPopup = new EditVaultUserPopup();
        editVaultUserPopup.getDeleteButton().click();
        switchTo().alert().accept();
        log.info("User " + name + " was removed from Vault users");
    }

    @Step("Verify name is present or absent in table")
    public void verifyNameIsPresentInTable(String name) {
        getRowByName(name).should(Condition.visible);
    }

    @Step("Verify name is present or absent in table")
    public void verifyNameIsAbsentInTable(String name) {
        getRowByName(name).shouldNot(Condition.visible);
    }

}
