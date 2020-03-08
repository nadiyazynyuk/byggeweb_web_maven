package dk.byggeweb.steps.project.common;

import dk.byggeweb.objects.project.workspace.panels.WSFolderContentPanel;
import io.qameta.allure.Step;

public class SearchSteps {

    @Step("Quick search for file")
    public void quickSearchFile(String fileName) {
        WSFolderContentPanel wsFolderContentPanel = new WSFolderContentPanel();
        wsFolderContentPanel.getQuickSearchInput().setValue(fileName).pressEnter();
        new WSFolderContentPanel("Quick search");
    }
}
