package dk.byggeweb.objects.desktop.personalspace.modals;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class DeleteFolderPopup extends ModalBase {

    private final SelenideElement deleteLabel = $(byXpath("//div[contains(@class, 'popup-headline1-red') and contains(text(), 'Delete the selected folder:')]"));

}
