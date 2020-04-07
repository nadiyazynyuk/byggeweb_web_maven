package dk.byggeweb.objects.project.distributionspace.modals;

import dk.byggeweb.objects.project.ModalBase;

public class DSListDeletePopup extends ModalBase {

    public void deleteList() {
        getOkButton().click();
        getCloseButton().click();
    }

}
