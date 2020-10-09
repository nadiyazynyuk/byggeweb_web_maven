package dk.byggeweb.objects.project.common.modals;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class FileStandardUploadTab extends FileUploadPopup {

    private final SelenideElement selectFile1 = $(byXpath("//input[@name='file0']"));
    private final SelenideElement selectFile2 = $(byXpath("//input[@name='file1']"));
    private final SelenideElement selectFile3 = $(byXpath("//input[@name='file2']"));
    private final SelenideElement selectFile4 = $(byXpath("//input[@name='file3']"));
    private final SelenideElement selectFile5 = $(byXpath("//input[@name='file4']"));
    private final SelenideElement selectFile6 = $(byXpath("//input[@name='file5']"));
    private final SelenideElement selectFile7 = $(byXpath("//input[@name='file6']"));
    private final SelenideElement selectFile8 = $(byXpath("//input[@name='file7']"));
    private final SelenideElement selectFile9 = $(byXpath("//input[@name='file8']"));
    private final SelenideElement selectFile10 = $(byXpath("//input[@name='file9']"));

    @Step("Select file to upload")
    public void selectFileToUpload(String file) {
        selectFile1.setValue(file);
        getOkButton().click();
    }
}
