package dk.byggeweb.objects.project.versionsets.modals;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.project.ModalBase;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class VSCreatePopup extends ModalBase {

    private SelenideElement versionSetNameInput = $(byXpath("//input[@name='VersionSet.Name']"));
    private SelenideElement versionSetDescriptionInput = $(byXpath("//textarea[@name='VersionSet.Description']"));

    @Step("Create Version set with name")
    public void createVersionSet(String name) {
        versionSetNameInput.setValue(name);
        getNextButton().click();
        getOkButton().click();
    }

    @Step("Rename Version set")
    public void renameVersionSet(String name) {
        versionSetNameInput.clear();
        versionSetNameInput.setValue(name);
        getNextButton().click();
        getOkButton().click();
    }

}
