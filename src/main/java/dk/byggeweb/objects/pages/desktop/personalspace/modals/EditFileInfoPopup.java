package dk.byggeweb.objects.pages.desktop.personalspace.modals;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class EditFileInfoPopup extends ModalBase {

    private SelenideElement getRowByName(String name) {
        return $(byXpath("//table[@id='edit-table']/tbody/tr[.//*[contains(text(),'" + name + "')]]"));
    }

    public SelenideElement getSubjectNameInput(String name) {
        return getRowByName(name).$(byXpath("./td[2]/input[@type='text']"));
    }

}
