package starttests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTests {

    WebDriver driver;

    @BeforeClass
    public void preconditions() {

        driver = new ChromeDriver();
        driver.navigate().to("https://telranedu.web.app/home");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }


    @Test
    public void loginPositive() {
        WebElement btnLogin = driver.findElement(By.xpath("//a[contains(@href, '/login')]"));
        btnLogin.click();

        WebElement inputEmail= driver.findElement(By.xpath("//input[@name='email']"));
        inputEmail.click();
        inputEmail.clear();
        inputEmail.sendKeys("bbbb@mail.com");


        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='password']"));
        inputPassword.click();
        inputPassword.clear();
        inputPassword.sendKeys("12345Qwerty&");


        WebElement buttonLogin = driver.findElement(By.xpath("//button[@name='login']"));
        buttonLogin.click();

        WebElement pageContacts = driver.findElement(By.xpath("//div[contains(@class, 'contact-page')]"));




    }

    @AfterClass
    public void postConditions() {


        driver.quit();
    }

}
