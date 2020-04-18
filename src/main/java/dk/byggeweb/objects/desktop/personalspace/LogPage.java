package dk.byggeweb.objects.desktop.personalspace;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class LogPage extends PersonalSpacePage {

    private final SelenideElement logLabel = $(byXpath("//*[@class='headline1-content' and contains(text(),'Log')]"));

}
