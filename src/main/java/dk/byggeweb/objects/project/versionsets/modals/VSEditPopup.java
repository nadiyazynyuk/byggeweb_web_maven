package dk.byggeweb.objects.project.versionsets.modals;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.project.ModalBase;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class VSEditPopup extends ModalBase {

    private SelenideElement popupTitle = $(byXpath("//h1[contains(text(), 'Edit version set')]"));

    private SelenideElement versionSetNameInput = $(byXpath("//input[@name='VersionSet.Name']"));
    private SelenideElement versionSetDescriptionInput = $(byXpath("//textarea[@name='VersionSet.Description']"));

    @Step("Rename Version set")
    public void renameVersionSet(String name) {
        versionSetNameInput.clear();
        versionSetNameInput.setValue(name);
        getNextButton().click();
        getOkButton().click();
    }

    public VSEditPopup() {
        popupTitle.shouldBe(visible);
    }
}
