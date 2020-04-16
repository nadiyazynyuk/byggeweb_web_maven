package dk.byggeweb.objects;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public abstract class PageBase {

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

    public void pleaseWait(int millis) {
        try {
            synchronized (this) {
                wait(millis);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
