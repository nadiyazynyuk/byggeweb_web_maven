package dk.byggeweb.steps.project.common;

import com.codeborne.selenide.WebDriverRunner;
import dk.byggeweb.objects.project.common.modals.FileSearchPopup;
import dk.byggeweb.objects.project.publicationspace.panels.PSFolderContentPanel;
import dk.byggeweb.objects.project.publicationspace.panels.PSQuickSearchResultContentPanel;
import dk.byggeweb.objects.project.publicationspace.panels.PSSearchResultContentPanel;
import dk.byggeweb.objects.project.workspace.panels.WSFolderContentPanel;
import dk.byggeweb.objects.project.workspace.panels.WSQuickSearchResultContentPanel;
import dk.byggeweb.objects.project.workspace.panels.WSSearchResultContentPanel;
import io.qameta.allure.Step;

public class SearchSteps {

    @Step("Quick search for file in Workspace")
    public void quickSearchFileInWorkspace(String fileName) {
        WSFolderContentPanel wsFolderContentPanel = new WSFolderContentPanel();
        wsFolderContentPanel.getQuickSearchInput().setValue(fileName).pressEnter();
        new WSQuickSearchResultContentPanel();
    }

    @Step("Advanced search for file by filename value in Workspace")
    public void advancedSearchFileByNameInWorkspace(String value) {
        String winHandleBefore = WebDriverRunner.getWebDriver().getWindowHandle();
        WSFolderContentPanel wsFolderContentPanel = new WSFolderContentPanel();
        wsFolderContentPanel.getFileAdvancedSearchButton().click();
        wsFolderContentPanel.switchToNewWindow();
        FileSearchPopup fileSearchPopup = new FileSearchPopup();

        fileSearchPopup.getMetadataSelectorDropdown().click();
        fileSearchPopup.getFileNameOption().click();
        fileSearchPopup.getFileNameInput().setValue(value);
        fileSearchPopup.getSearchButton().click();

        WebDriverRunner.getWebDriver().switchTo().window(winHandleBefore);
        new WSSearchResultContentPanel();
    }

    @Step("Quick search for file in Publication space")
    public void quickSearchFileInPublicationSpace(String fileName) {
        PSFolderContentPanel psFolderContentPanel = new PSFolderContentPanel();
        psFolderContentPanel.getQuickSearchInput().setValue(fileName).pressEnter();
        new PSQuickSearchResultContentPanel();
    }

    @Step("Advanced search for file by filename value in Publication space")
    public void advancedSearchFileByNameInPublicationSpace(String value) {
        String winHandleBefore = WebDriverRunner.getWebDriver().getWindowHandle();
        PSFolderContentPanel psFolderContentPanel = new PSFolderContentPanel();
        psFolderContentPanel.getFileAdvancedSearchButton().click();
        psFolderContentPanel.switchToNewWindow();
        FileSearchPopup fileSearchPopup = new FileSearchPopup();

        fileSearchPopup.getMetadataSelectorDropdown().click();
        fileSearchPopup.getFileNameOption().click();
        fileSearchPopup.getFileNameInput().setValue(value);
        fileSearchPopup.getSearchButton().click();

        WebDriverRunner.getWebDriver().switchTo().window(winHandleBefore);
        new PSSearchResultContentPanel();
    }

}
