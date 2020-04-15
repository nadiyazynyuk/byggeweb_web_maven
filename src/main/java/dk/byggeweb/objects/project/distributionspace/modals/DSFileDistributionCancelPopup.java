package dk.byggeweb.objects.project.distributionspace.modals;

import dk.byggeweb.objects.project.ModalBase;
import io.qameta.allure.Step;

public class DSFileDistributionCancelPopup extends ModalBase {

    @Step
    public void cancelDistribution() {
        pleaseWait(1000);
        getOkButton().click();
    }
}
