package dk.byggeweb.objects.project.distributionspace.modals;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.project.ModalBase;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class DSListCreatePopup extends ModalBase {

    private SelenideElement nameInput = $(byXpath("//input[@name='DistributionList.Name']"));
    private SelenideElement selectReservedListOption = $(byXpath("//select[@name='DistributionList.ListType']/option[@value='0']"));
    private SelenideElement selectOpenListOption = $(byXpath("//select[@name='DistributionList.ListType']/option[@value='1']"));
    private SelenideElement selectCoordinatorListOption = $(byXpath("//select[@name='DistributionList.ListType']/option[@value='2']"));

    @Step("Create Coordinator Distribution list")
    public void createCoordinatorDistributionList(String distributionListName) {
        nameInput.setValue(distributionListName);
        selectCoordinatorListOption.click();
        getOkButton().click();
        getOkButton().click();
    }

    @Step("Create Open Distribution list")
    public void createOpenDistributionList(String distributionListName) {
        nameInput.setValue(distributionListName);
        selectOpenListOption.click();
        getOkButton().click();
        getOkButton().click();
    }

    @Step("Create Reserved Distribution list")
    public void createReservedDistributionList(String distributionListName) {
        nameInput.setValue(distributionListName);
        selectReservedListOption.click();
        getOkButton().click();
        getOkButton().click();
    }

    @Step("Rename Distribution list")
    public void renameDistributionList(String name) {
        nameInput.clear();
        nameInput.setValue(name);
        getOkButton().click();
    }
}
