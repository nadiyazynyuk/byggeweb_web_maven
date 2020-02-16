package dk.byggeweb.objects.project.workspace.modals;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class WSDownloadFilesPopup extends WSModalBase {

    SelenideElement downloadLink = $(byXpath("//a[@class='popup-headline1-standard headline2-bar-standard headline3-underlined']"));

}
