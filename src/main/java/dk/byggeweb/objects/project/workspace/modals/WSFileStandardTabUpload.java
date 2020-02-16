package dk.byggeweb.objects.project.workspace.modals;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class WSFileStandardTabUpload extends WSFileUploadPopup {

    private SelenideElement selectFile1 = $(byXpath("//input[@name='file0']"));
    private SelenideElement selectFile2 = $(byXpath("//input[@name='file1']"));
    private SelenideElement selectFile3 = $(byXpath("//input[@name='file2']"));
    private SelenideElement selectFile4 = $(byXpath("//input[@name='file3']"));
    private SelenideElement selectFile5 = $(byXpath("//input[@name='file4']"));
    private SelenideElement selectFile6 = $(byXpath("//input[@name='file5']"));
    private SelenideElement selectFile7 = $(byXpath("//input[@name='file6']"));
    private SelenideElement selectFile8 = $(byXpath("//input[@name='file7']"));
    private SelenideElement selectFile9 = $(byXpath("//input[@name='file8']"));
    private SelenideElement selectFile10 = $(byXpath("//input[@name='file9']"));

    @Step("Select file to upload")
    public void selectFileToUpload(String file) {
        selectFile1.setValue(file);
        getOkButton().click();
    }
}
