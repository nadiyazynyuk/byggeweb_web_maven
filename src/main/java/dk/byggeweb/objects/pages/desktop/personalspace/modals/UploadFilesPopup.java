package dk.byggeweb.objects.pages.desktop.personalspace.modals;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class UploadFilesPopup extends ModalBase {

    private SelenideElement uploadLabel = $(byXpath("//div[contains(@class, 'popup-headline1-standard') and contains(text(), 'Select files for uploading to folder:')]"));
    private SelenideElement dropArea = $(byXpath("//div[@id='drop-area']"));

}
