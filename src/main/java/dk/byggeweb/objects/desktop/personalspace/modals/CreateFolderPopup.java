package dk.byggeweb.objects.desktop.personalspace.modals;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class CreateFolderPopup extends ModalBase {

    private SelenideElement folderNameInput = $(byXpath("//input[@id='directory_name']"));

}
