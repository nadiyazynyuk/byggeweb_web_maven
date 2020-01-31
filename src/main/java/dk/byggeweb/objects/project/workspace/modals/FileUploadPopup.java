package dk.byggeweb.objects.project.workspace.modals;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class FileUploadPopup extends ModalBase {

    private SelenideElement enhancedUploadTab = $(byXpath("//table[@id='advanced_tab']"));
    private SelenideElement standardUploadTab = $(byXpath("//table[@id='standard_tab']"));
    private SelenideElement transferalUploadTab = $(byXpath("//table[@id='transfer_tab']"));

    @Step("Switch to enhanced upload tab")
    public void switchToEnhancedUploadTab() {
        enhancedUploadTab.click();
    }

    @Step("Switch to standard upload tab")
    public void switchToStandardUploadTab() {
        standardUploadTab.click();
    }

    @Step("Switch to transferal upload tab")
    public void switchToTransferalUploadTab() {
        transferalUploadTab.click();
    }

}