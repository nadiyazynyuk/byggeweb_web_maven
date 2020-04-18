package dk.byggeweb.objects.desktop.personalspace.modals;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class UploadFilesPopup extends ModalBase {

    private final SelenideElement uploadLabel = $(byXpath("//div[contains(@class, 'popup-headline1-standard') and contains(text(), 'Select files for uploading to folder:')]"));
    private final SelenideElement dropArea = $(byXpath("//div[@id='drop-area']"));

}
