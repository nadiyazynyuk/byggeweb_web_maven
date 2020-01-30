package dk.byggeweb.objects.pages.project.workspace.modals;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class FileCopyPopup extends ModalBase{

    private SelenideElement getFolderByName(String name) {
        return $(byXpath("//td[@class='foldername']/a[contains(text(), '" + name + "')]"));
    }

    public void clickOnFolder(String name) {
        getFolderByName(name).click();
    }

    @Step("Copy file to the parent folder")
    public void copyFile(String name) {
        getNextButton().click();
        clickOnFolder(name);
        getOkButton().click();
        getCloseButton().click();
    }

    @Step("Copy file to the inner folder")
    public void copyFile(String folder1, String folder2) {
        getNextButton().click();
        clickOnFolder(folder1);
        clickOnFolder(folder2);
        getOkButton().click();
        getCloseButton().click();
    }
}
