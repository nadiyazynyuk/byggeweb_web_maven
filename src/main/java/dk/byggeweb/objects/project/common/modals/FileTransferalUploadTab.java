package dk.byggeweb.objects.project.common.modals;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class FileTransferalUploadTab extends FileUploadPopup {

    private final SelenideElement myFoldersItem = $(byXpath("//span[text()='My folders']"));
    private final SelenideElement sharedFoldersItem = $(byXpath("//span[text()='Shared folders']"));
    private final SelenideElement dociaProjectsItem = $(byXpath("//span[text()='Docia projects']"));
    private final SelenideElement dociaArchivesItem = $(byXpath("//span[text()='Docia archives']"));
    private final SelenideElement dociaTendersItem = $(byXpath("//span[text()='Docia Tenders']"));
    private final SelenideElement transferButton = $(byXpath("//input[@value='Transfer']"));

    private SelenideElement getCheckBoxByFileName(String name) {
        return $(byXpath("//td[contains(text(),'" + name + "')]/preceding-sibling::td/preceding-sibling::td/input[@type='checkbox']"));
    }

    @Step("Transfer file from My Folders")
    public void transferFileFromMyFolders(String file) {
        myFoldersItem.click();
        getCheckBoxByFileName(file).click();
        transferButton.click();
    }

}
