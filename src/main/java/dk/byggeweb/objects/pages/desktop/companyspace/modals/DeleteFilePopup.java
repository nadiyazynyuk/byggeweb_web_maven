package dk.byggeweb.objects.pages.desktop.companyspace.modals;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class DeleteFilePopup extends ModalBase {

    private SelenideElement deleteLabel = $(byXpath("//div[contains(@class, 'popup-headline1-red') and contains(text(), 'Delete the selected files from the company space? The deletion cannot be reversed.')]"));

}
