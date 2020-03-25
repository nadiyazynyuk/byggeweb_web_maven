package dk.byggeweb.objects.project.publicationspace.modals;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.project.ModalBase;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class PSFilePublishPopup extends ModalBase {

    private SelenideElement localMachineItem = $(byXpath("//span[text()='Local machine']"));
    private SelenideElement workspaceItem = $(byXpath("//span[text()='Workspace']"));

    private SelenideElement getTableItemByName(String folderName) {
        return $(byXpath("//table//td[contains(text(), '" + folderName + "')]"));
    }

    @Step("Publish file from Workspace folder")
    public void publishFileFromWorkspaceFolder(String folderName, String fileName) {
        pleaseWait(1000);
        workspaceItem.click();
        getTableItemByName("Project").click();
        getTableItemByName(folderName).click();
        getTableItemByName(fileName).click();
        getNextButton().click();
        getOkButton().click();
        getCloseButton().click();
    }

}
