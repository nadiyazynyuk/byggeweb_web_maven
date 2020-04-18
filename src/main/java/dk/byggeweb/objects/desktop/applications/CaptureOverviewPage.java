package dk.byggeweb.objects.desktop.applications;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class CaptureOverviewPage extends ApplicationsPage {

    private final SelenideElement captureLabel = $(byXpath("//*[@class='headline1-content' and contains(text(), 'Capture')]"));
    private final SelenideElement defectManagement = $(byXpath("//*[contains(text(),'" + "Defect" + "')]"));
    private final SelenideElement qualityControl = $(byXpath("//*[contains(text(),'" + "Quality" + "')]"));
    private final SelenideElement safetyRound = $(byXpath("//*[contains(text(),'" + "Safety" + "')]"));

}
