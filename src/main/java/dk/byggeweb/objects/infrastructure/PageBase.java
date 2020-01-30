package dk.byggeweb.objects.infrastructure;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$;

public abstract class PageBase {

    protected SelenideElement projectTitleLabel = $(By.xpath("//div[@class='WMP_Title']"));

    private WebDriver driver = WebDriverRunner.getWebDriver();

    public void switchToLastTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        try {
            driver.switchTo().window(tabs.get(tabs.size() - 1));
        } catch (IndexOutOfBoundsException ex) {
            throw new RuntimeException("Switching to tab is impossible because it doesn't exist.");
        }
    }

    public void switchToFrame(WebElement frameElement) {
        driver.switchTo().frame(frameElement);
    }

    public void switchToParentFrame() {
        driver.switchTo().parentFrame();
    }

    public void switchToNewWindow() {
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
