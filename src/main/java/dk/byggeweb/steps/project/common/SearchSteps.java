package dk.byggeweb.steps.project.common;

import com.codeborne.selenide.WebDriverRunner;
import dk.byggeweb.objects.project.common.modals.FileSearchPopup;
import dk.byggeweb.objects.project.workspace.panels.WSFolderContentPanel;
import dk.byggeweb.objects.project.workspace.panels.WSQuickSearchResultContentPanel;
import dk.byggeweb.objects.project.workspace.panels.WSSearchResultContentPanel;
import io.qameta.allure.Step;

public class SearchSteps {

    @Step("Quick search for file")
    public void quickSearchFile(String fileName) {
        WSFolderContentPanel wsFolderContentPanel = new WSFolderContentPanel();
        wsFolderContentPanel.getQuickSearchInput().setValue(fileName).pressEnter();
        new WSQuickSearchResultContentPanel();
    }

    @Step("Advanced search for file by filename value")
    public void advancedSearchFileByName(String value) {
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

}
