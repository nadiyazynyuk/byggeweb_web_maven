package dk.byggeweb.steps.project.distributionspace;

import dk.byggeweb.objects.project.distributionspace.modals.DSFileDistributionCancelPopup;
import dk.byggeweb.objects.project.distributionspace.panels.DSFileInformationPanel;
import dk.byggeweb.objects.project.distributionspace.panels.DSFolderContentPanel;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;

import static com.codeborne.selenide.Condition.text;

@Log4j
public class DSFileSteps {

    @Step("Select file")
    public void selectFile(String fileName) {
        new DSFolderContentPanel().getFileByName(fileName).click();
        log.info("File " + fileName + " was selected");
        new DSFileInformationPanel(fileName);
    }

    @Step("Cancel file distribution")
    public void cancelFileDistribution(String fileName) {
        selectFile(fileName);
        DSFolderContentPanel dsFolderContentPanel = new DSFolderContentPanel();
        dsFolderContentPanel.getFileCancelDistributionButton().click();
        log.info("Cancel file distribution button was clicked");
        DSFileDistributionCancelPopup dsFileDistributionCancelPopup = new DSFileDistributionCancelPopup();
        dsFileDistributionCancelPopup.getOkButton().click();
    }

    @Step("Verify file is present in the list")
    public void verifyFileIsPresent(String name) {
        DSFolderContentPanel dsFolderContentPanel = new DSFolderContentPanel();
        dsFolderContentPanel.getFileByName(name).shouldHave(text(name));
    }
}
