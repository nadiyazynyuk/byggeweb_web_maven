package dk.byggeweb.steps.project.distributionspace;

import dk.byggeweb.objects.project.common.modals.FileAddToVersionSetPopup;
import dk.byggeweb.objects.project.common.modals.FileDownloadPopup;
import dk.byggeweb.objects.project.distributionspace.modals.DSFileDistributionCancelPopup;
import dk.byggeweb.objects.project.distributionspace.panels.DSFileInformationPanel;
import dk.byggeweb.objects.project.distributionspace.panels.DSFolderContentPanel;
import dk.byggeweb.steps.GeneralSteps;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Condition.visible;

@Log4j2
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
        dsFolderContentPanel.switchToNewWindow();
        DSFileDistributionCancelPopup dsFileDistributionCancelPopup = new DSFileDistributionCancelPopup();
        dsFileDistributionCancelPopup.cancelDistribution();
        log.info("Distribution of the file " + fileName + " was canceled");
        dsFolderContentPanel.switchToLastTab();
    }

    @Step("Download single file")
    public void downloadFile(String fileName) {
        selectFile(fileName);
        new DSFolderContentPanel().getFileDownloadButton().click();
        log.info("Download files button was clicked");
    }

    @Step("Download all files from the folder")
    public void generateDownloadFilesLink(String fileName) {
        selectFile(fileName);
        DSFolderContentPanel dsFolderContentPanel = new DSFolderContentPanel();
        GeneralSteps.selectAll();
        dsFolderContentPanel.getFileDownloadButton().click();
        log.info("Download files button was clicked");
        dsFolderContentPanel.switchToNewWindow();
        FileDownloadPopup fileDownloadPopup = new FileDownloadPopup();
        fileDownloadPopup.getOkButton().click();
        fileDownloadPopup.getDownloadLink().shouldBe(visible);
        fileDownloadPopup.getCancelButton().click();
        dsFolderContentPanel.switchToLastTab();
    }

    @Step("Add file to version set")
    public void addFileToVersionSet(String filename, String versionSetName) {
        selectFile(filename);
        DSFolderContentPanel dsFolderContentPanel = new DSFolderContentPanel();
        dsFolderContentPanel.getFileAddToVersionSetButton().click();
        log.info("Add to version sets button was clicked");
        dsFolderContentPanel.switchToNewWindow();
        FileAddToVersionSetPopup fileAddToVersionSetPopup = new FileAddToVersionSetPopup();
        fileAddToVersionSetPopup.addFileToVersionSet(versionSetName);
        log.info("File " + filename + " was added to the version set: " + versionSetName);
        dsFolderContentPanel.switchToLastTab();
    }

    @Step("Start to monitor file")
    public void startMonitorFile(String filename) {
        selectFile(filename);
        new DSFolderContentPanel().getFileMonitorButton().click();
    }

    @Step("Verify file is present in the list")
    public void verifyFileIsPresent(String name) {
        DSFolderContentPanel dsFolderContentPanel = new DSFolderContentPanel();
        dsFolderContentPanel.getFileByName(name).shouldBe(visible);
    }

    @Step("Verify file is not present in the list")
    public void verifyFileIsNotPresent(String name) {
        DSFolderContentPanel dsFolderContentPanel = new DSFolderContentPanel();
        dsFolderContentPanel.getFileByName(name).shouldNotBe(visible);
    }

}
