package tests;

import dto.UserDTOLombok;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.RandomUtils;

public class RegistrationTests extends BaseTest {

    @Test
    public void positiveRegistration() {
        String email = RandomUtils.generateEmail(7);
        UserDTOLombok user = UserDTOLombok().builder()
                .email(email)
                .password("12345Qwerty#$&")
                .build();

        app.getUserHelper().loginUserDTOLombok(user);
        Assert.assertTrue(app.getUserHelper().validateMessageSuccessAfterLogin());
    }

    @Test
    public void negativeRegistrationPasswordIncorrect() {
        String email = RandomUtils.generateEmail(7);
        UserDTOLombok user = UserDTOLombok().builder()
                .email(email)
                .password("123")
                .build();

        app.getUserHelper().loginUserDTOLombok(user);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String text = alert.getText();
        Assert.assertEquals(text, "Wrong email or password format");
        alert.accept();
    }

}
