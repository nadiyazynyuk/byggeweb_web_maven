package dk.byggeweb.objects.project.workspace.panels;

import static com.codeborne.selenide.Condition.text;

public class FolderInformationPanel extends WorkspaceNodesPanel {

    public FolderInformationPanel(String title) {
        getPanelTitle().shouldHave(text(title));
    }

}