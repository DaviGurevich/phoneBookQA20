package starttests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.RandomUtils;

import java.util.concurrent.TimeUnit;

public class RegistrationTests {

WebDriver driver;

    RandomUtils randomUtils = new RandomUtils();

    @BeforeClass
    public void preconditions() {

        driver = new ChromeDriver();
        driver.navigate().to("https://telranedu.web.app/home");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @Test
    public void registrationPositive() {

        String email = randomUtils.generateEmail(7);
        System.out.println(email);

        String password = randomUtils.generatePassword(10);
        System.out.println(password);

        WebElement btnLogin = driver.findElement(By.xpath("//a[contains(@href, '/login')]"));
        btnLogin.click();

        WebElement inputEmail= driver.findElement(By.xpath("//input[@name='email']"));
        inputEmail.click();
        inputEmail.clear();
        inputEmail.sendKeys(email);

        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='password']"));
        inputPassword.click();
        inputPassword.clear();
        inputPassword.sendKeys(password);


        driver.findElement(By.xpath("//button[@name='registration']")).click();

        WebElement textMessage = driver.findElement(By.xpath("//h2[contains(text(), 'new by clicking')]"));
        System.out.println(textMessage.getText());


    }


    @AfterClass
    public void postConditions() {

        driver.quit();
    }
}
