package dk.byggeweb.objects.project.versionsets.modals;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.project.ModalBase;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class VersionSetCreatePopup extends ModalBase {

    private SelenideElement popupTitle = $(byXpath("//h1[contains(text(), 'New version set')]"));

    private SelenideElement versionSetNameInput = $(byXpath("//input[@name='VersionSet.Name']"));
    private SelenideElement versionSetDescriptionInput = $(byXpath("//textarea[@name='VersionSet.Description']"));

    @Step("Create Version set with name")
    public void createVersionSet(String name) {
        versionSetNameInput.setValue(name);
        getNextButton().click();
        getOkButton().click();
    }

    public VersionSetCreatePopup() {
        popupTitle.shouldBe(visible);
    }

}
