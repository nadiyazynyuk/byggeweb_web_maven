package dk.byggeweb.objects.project.publicationspace.modals;

import com.codeborne.selenide.SelenideElement;
import dk.byggeweb.objects.project.ModalBase;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class PSFilePublishPopup extends ModalBase {

    private SelenideElement localMachineItem = $(byXpath("//span[text()='Local machine']"));
    private SelenideElement workspaceItem = $(byXpath("//span[text()='Workspace']"));
}
