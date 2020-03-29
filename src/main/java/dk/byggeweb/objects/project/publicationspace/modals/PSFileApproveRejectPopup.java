package dk.byggeweb.objects.project.publicationspace.modals;

import dk.byggeweb.objects.project.ModalBase;
import io.qameta.allure.Step;

public class PSFileApproveRejectPopup extends ModalBase {

    @Step("Approve file")
    public void approveFile() {
        getApproveButton().click();
    }

    @Step("Reject and delete file")
    public void rejectAndDeleteFile() {
        getRejectButton().click();
        getDeleteButton().click();
        getOkButton().click();
    }

    @Step("Reject and save file")
    public void rejectAndSaveFile() {
        getRejectButton().click();
        getSaveButton().click();
        getOkButton().click();
    }

}
