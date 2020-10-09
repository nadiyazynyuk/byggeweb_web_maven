package dk.byggeweb.objects.project.common.modals;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.project.ModalBase;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class FileUploadPopup extends ModalBase {

    private final SelenideElement enhancedUploadTab = $(byXpath("//table[@id='advanced_tab']"));
    private final SelenideElement standardUploadTab = $(byXpath("//table[@id='standard_tab']"));
    private final SelenideElement transferalUploadTab = $(byXpath("//table[@id='transfer_tab']"));

    @Getter
    private final SelenideElement uploadFileIFrame = $(byXpath("//div/iframe[@data-ref='iframeEl']"));

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
