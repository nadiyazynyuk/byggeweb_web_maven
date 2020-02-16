package dk.byggeweb.objects.project.workspace.modals;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class WSFileMovePopup extends WSModalBase {

    private SelenideElement getFolderByName(String name) {
        return $(byXpath("//td[@class='foldername']/a[contains(text(), '" + name + "')]"));
    }

    public void clickOnFolder(String name) {
        getFolderByName(name).click();
    }

    @Step("Move file to the parent folder")
    public void moveFile(String name) {
        getNextButton().click();
        clickOnFolder(name);
        getOkButton().click();
        getCloseButton().click();
    }

    @Step("Move file to the inner folder")
    public void moveFile(String folder1, String folder2) {
        getNextButton().click();
        clickOnFolder(folder1);
        clickOnFolder(folder2);
        getOkButton().click();
        getCloseButton().click();
    }
}


