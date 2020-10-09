package dk.byggeweb.objects.project.common.modals;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.project.ModalBase;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class FileDownloadPopup extends ModalBase {

    private final SelenideElement downloadLink = $(byXpath("//a[@class='popup-headline1-standard headline2-bar-standard headline3-underlined']"));

}
