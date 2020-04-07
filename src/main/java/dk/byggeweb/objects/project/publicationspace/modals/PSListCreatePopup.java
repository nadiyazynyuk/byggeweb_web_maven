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

    private SelenideElement getApprovalProcedureOption(String approvalProcedureName) {
        return $(byXpath("//select[@name='DocListing__ApprovalProcedure_ID']/option[contains(text(), '" + approvalProcedureName + "')]"));
    }

    @Step("Create new document list")
    public void createDocumentList(String listName) {
        nameInput.setValue(listName);
        getCreateButton().click();
        getNoButton().click();
    }

    @Step("Create new document list with approval procedure")
    public void createDocumentList(String listName, String approvalProcedureName) {
        nameInput.setValue(listName);
        getApprovalProcedureOption(approvalProcedureName).click();
        getCreateButton().click();
        getNoButton().click();
    }

    @Step("Rename document list")
    public void renameDocumentList(String name) {
        nameInput.clear();
        nameInput.setValue(name);
        getOkButton().click();
        getCloseButton().click();
    }

}
