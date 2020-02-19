package dk.byggeweb.objects.project.common.modals;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import dk.byggeweb.steps.GeneralSteps;
import io.qameta.allure.Step;

import java.io.File;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class FileEnhancedUploadTab extends FileUploadPopup {

    private SelenideElement dropArea = $(byXpath("//*[@class='au-upldr-list au-upldr-list-horizontal tileList']"));

    @Step("Drop file into drop zone")
    public void dropFile(String file) {
        GeneralSteps.dropFile(new File(file), WebDriverRunner.getWebDriver(), dropArea, 0,0);
        getOkButton().click();
    }

}
