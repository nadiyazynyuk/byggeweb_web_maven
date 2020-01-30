package dk.byggeweb.objects.desktop.personalspace;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class DesktopPage extends PersonalSpacePage {

    private SelenideElement addDesktopContentLink = $(byXpath("//span[@id='desktop_addcontent']"));

}
