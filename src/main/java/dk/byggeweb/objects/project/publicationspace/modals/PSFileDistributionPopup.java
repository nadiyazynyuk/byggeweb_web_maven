package dk.byggeweb.objects.project.publicationspace.modals;

import dk.byggeweb.objects.project.ModalBase;
import io.qameta.allure.Step;

public class PSFileDistributionPopup extends ModalBase {

    @Step("Distribute file")
    public void distributeFile() {
        getOkButton().click();
        getOkButton().click();
    }

    @Step("Distribute file")
    public void distributeFile(String distributionListName) {
        // TODO
    }
}
