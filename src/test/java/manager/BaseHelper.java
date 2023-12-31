package manager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseHelper {

    WebDriver driver;

    public BaseHelper(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findElementBase(By locator) {
        System.out.println(locator);
        return driver.findElement(locator);
    }

    private List<WebElement> findElementsBase(By locator) {
        System.out.println(locator);
        return driver.findElements(locator);
    }

    public void clickBase(By locator) {
        WebElement el = findElementBase(locator);
        el.click();
    }

    public String getTextBase(By locator) {
        WebElement el = findElementBase(locator);
        return el.getText().trim().toUpperCase();
    }

    public void typeTextBase(By locator, String text) {
        WebElement el = findElementBase(locator);
        el.click();
        el.clear();
        el.sendKeys(text);
    }

    public boolean isTextEqual(By locator, String expectedResult) {
        String actualResult = getTextBase(locator);
        expectedResult = expectedResult.toUpperCase();

        if(expectedResult.equals(actualResult)) {
            return true;
        } else {
            System.out.println("expected result: " + expectedResult +
                    "actual result: " + actualResult);
            return false;
        }
    }

    public String getTextAlert() {
 //       driver.findElementBase(By.linkText("Wrong email or password")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        return alert.getText().toUpperCase().trim();
    }



    public boolean isTextEqualGet2Strings(String expectedResult, String actualResult) {
        if(expectedResult.equals(actualResult)) {
            return true;
        } else {
            System.out.println("expected result: " + expectedResult +
                    "actual result: " + actualResult);
            return false;
        }
    }


}
