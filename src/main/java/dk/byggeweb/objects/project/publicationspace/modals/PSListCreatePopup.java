package dk.byggeweb.objects.project.publicationspace.modals;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.project.ModalBase;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class PSListCreatePopup extends ModalBase {

    private SelenideElement nameInput = $(byXpath("//input[@name='DocListing__Name']"));

    @Step("Create new document list")
    public void createDocumentList(String name) {
        nameInput.setValue(name);
        getCreateButton().click();
        getNoButton().click();
    }

    @Step("Rename document list")
    public void renameDocumentList(String name) {
        nameInput.setValue(name);
        getOkButton().click();
        getCloseButton().click();
    }

}
