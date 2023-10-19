package tests;

import dto.UserDTOLombok;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.RandomUtils;

public class RegistrationTests extends BaseTest {

    @Test
    public void positiveRegistration() {
        RandomUtils randomUtils = new RandomUtils();
        String email = randomUtils.generateEmail(7);
        UserDTOLombok user = UserDTOLombok.builder()
                .email(email)
                .password("12345Qwerty#$&")
                .build();

        app.getUserHelper().loginUserDTOLombok(user);
        Assert.assertTrue(app.getUserHelper().validateMessageSuccessAfterLogin());
    }

    @Test
    public void negativeRegistrationPasswordIncorrect() {
        RandomUtils randomUtils = new RandomUtils();
        String email = randomUtils.generateEmail(7);
        UserDTOLombok user = UserDTOLombok.builder()
                .email(email)
                .password("123")
                .build();

        app.getUserHelper().loginUserDTOLombok(user);
        Assert.assertTrue(app.getUserHelper().validateMessageAlert());

    }

    @Test
    public void negativeRegistrationEmailIncorrect() {
        RandomUtils randomUtils = new RandomUtils();
        String password = randomUtils.generatePassword(10);
        UserDTOLombok user = UserDTOLombok.builder()
                .email("dana@1")
                .password(password)
                .build();

        app.getUserHelper().loginUserDTOLombok(user);
        Assert.assertTrue(app.getUserHelper().validateMessageAlertWrongEmailOrPassword());

    }

    @Test
    public void negativeRegistrationEmailEmpty() {
        RandomUtils randomUtils = new RandomUtils();
        String email = randomUtils.generateEmail(7);
        UserDTOLombok user = UserDTOLombok.builder()
                .email("")
                .password("Daba12345$!")
                .build();

        app.getUserHelper().loginUserDTOLombok(user);
        Assert.assertTrue(app.getUserHelper().validateMessageAlertWrongEmailOrPassword());

    }

    @Test
    public void negativeRegistrationPasswordEmpty() {
        RandomUtils randomUtils = new RandomUtils();
        String email = randomUtils.generateEmail(7);
        UserDTOLombok user = UserDTOLombok.builder()
                .email(email)
                .password("")
                .build();

        app.getUserHelper().loginUserDTOLombok(user);
        Assert.assertTrue(app.getUserHelper().validateMessageAlertWrongEmailOrPassword());

    }

}
