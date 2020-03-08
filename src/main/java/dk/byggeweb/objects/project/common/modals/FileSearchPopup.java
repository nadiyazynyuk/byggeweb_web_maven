package dk.byggeweb.objects.project.common.modals;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.project.ModalBase;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class FileSearchPopup extends ModalBase {

    private SelenideElement metadataSelectorDropdown = $(byXpath("//select[@name='fieldname_1']"));

    private SelenideElement fileNameOption = $(byXpath("//select[@name='fieldname_1']/option[@value='Files.Name']"));
    private SelenideElement fileNameInput = $(byXpath("//input[@name='fieldvalue_1_Files.Name']"));

    private SelenideElement searchButton = $(byXpath("//input[contains(@value, 'Search')]"));

}
