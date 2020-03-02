package dk.byggeweb.steps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import dk.byggeweb.objects.desktop.HomePage;
import dk.byggeweb.objects.desktop.authorization.LoginPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class GeneralSteps {

    public static HomePage loginAsVerifiedUser(String username, String password, String user) {
        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);
        return new HomePage(user);
    }

    public static void launchProject(String url) {
        Selenide.open(url);
    }

    public static void dropFile(File filePath, WebDriver driver, WebElement target, int offsetX, int offsetY) {
        if (!filePath.exists()) {
            throw new WebDriverException("File not found: " + filePath.toString());
        }

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, 30);

        String JS_DROP_FILE =
                "var target = arguments[0]," +
                        "    offsetX = arguments[1]," +
                        "    offsetY = arguments[2]," +
                        "    document = target.ownerDocument || document," +
                        "    window = document.defaultView || window;" +
                        "" +
                        "var input = document.createElement('INPUT');" +
                        "input.type = 'file';" +
                        "input.style.display = 'none';" +
                        "input.onchange = function () {" +
                        "  var rect = target.getBoundingClientRect()," +
                        "      x = rect.left + (offsetX || (rect.width >> 1))," +
                        "      y = rect.top + (offsetY || (rect.height >> 1))," +
                        "      dataTransfer = { files: this.files };" +
                        "" +
                        "  ['dragenter', 'dragover', 'drop'].forEach(function (name) {" +
                        "    var evt = document.createEvent('MouseEvent');" +
                        "    evt.initMouseEvent(name, !0, !0, window, 0, 0, 0, x, y, !1, !1, !1, !1, 0, null);" +
                        "    evt.dataTransfer = dataTransfer;" +
                        "    target.dispatchEvent(evt);" +
                        "  });" +
                        "" +
                        "  setTimeout(function () { document.body.removeChild(input); }, 25);" +
                        "};" +
                        "document.body.appendChild(input);" +
                        "return input;";

        WebElement input = (WebElement) jse.executeScript(JS_DROP_FILE, target, offsetX, offsetY);
        input.sendKeys(filePath.getAbsoluteFile().toString());
        wait.until(ExpectedConditions.stalenessOf(input));
    }

    public static void selectAll() {
        Actions action = new Actions(WebDriverRunner.getWebDriver());
        if (System.getProperty("os.name").contains("Mac OS")) {
            action.keyDown(Keys.COMMAND).sendKeys(String.valueOf('\u0061')).perform();
            action.keyUp(Keys.COMMAND).perform();
        } else {
            action.keyDown(Keys.CONTROL).sendKeys(String.valueOf('\u0061')).perform();
            action.keyUp(Keys.CONTROL).perform();
        }
    }

    public static void waitForTheFileToDownload(String fileName, String outputDirectory) {
        File directory = new File(outputDirectory);
        File[] listOfFiles = directory.listFiles();
        for (int retry = 0; retry < 10; retry++) {
            for (File file : listOfFiles) {
                if (file.getName().equalsIgnoreCase(fileName)) {
                    break;
                }
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void clearOutputDirectory(File outputDirectory) {
        try {
            FileUtils.cleanDirectory(outputDirectory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteFileFromDirectory(String fileName, String outputDirectory) {
        File file = new File(outputDirectory + "/" + fileName);
        if (file.exists()) file.delete();
    }

    public static boolean isFilePresentInDirectory(String fileName, String outputDirectory) {
        boolean result = false;
        File directory = new File(outputDirectory);
        File[] listOfFiles = directory.listFiles();
        for (File file : listOfFiles) {
            if (file.getName().equalsIgnoreCase(fileName)) {
                result = true;
                break;
            }
        }
        return result;
    }

}
