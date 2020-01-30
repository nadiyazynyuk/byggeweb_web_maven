package dk.byggeweb.objects.pages.desktop.applications;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class CaptureOverviewPage extends ApplicationsPage {

    private SelenideElement captureLabel = $(byXpath("//*[@class='headline1-content' and contains(text(), 'Capture')]"));
    private SelenideElement defectManagement = $(byXpath("//*[contains(text(),'" + "Defect" + "')]"));
    private SelenideElement qualityControl = $(byXpath("//*[contains(text(),'" + "Quality" + "')]"));
    private SelenideElement safetyRound = $(byXpath("//*[contains(text(),'" + "Safety" + "')]"));

}
