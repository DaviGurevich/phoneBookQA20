package tests;

import dto.UserDTO;
import dto.UserDTOLombok;
import dto.UserDTOWith;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void positiveLoginUserDTO() {
        UserDTO userDTO = new UserDTO("dana@dana.mail", "Dana123$%");
        app.getUserHelper().login(userDTO);
        Assert.assertTrue(app.getUserHelper().validateMessageSuccessAfterLogin());
    }

    @Test
    public void positiveLoginUserDTOWith() {
        UserDTOWith userDTOWith = new UserDTOWith().withEmail("cattus@cattus.mail").withPassword("Cattus123$%");
        app.getUserHelper().login(userDTOWith);
        Assert.assertTrue(app.getUserHelper().validateMessageSuccessAfterLogin());
    }

    @Test
    public void positiveLoginUserDTOLombok() {
        UserDTOLombok user = UserDTOLombok.builder().
                email("dana@dana.mail").
                password("Dana123$%").
                build();

        app.getUserHelper().loginUserDTOLombok(user);
        Assert.assertTrue(app.getUserHelper().validateMessageSuccessAfterLogin());
    }

    @Test
    public void negativeLoginUserDTOLombokEmailIncorrect() {
        UserDTOLombok user = UserDTOLombok.builder().
                email("dana@dana@.mail").
                password("Dana123$%").
                build();

        app.getUserHelper().loginUserDTOLombok(user);
//       String text = alert.getText();
        Assert.assertTrue(app.getUserHelper().validateMessageAlert());
//       alert.accept();

    }

    @Test
    public void negativeLoginUserDTOLombokPasswordIncorrect() {
        UserDTOLombok user = UserDTOLombok.builder().
                email("dana@dana@.mail").
                password("123").
                build();

        app.getUserHelper().loginUserDTOLombok(user);
        Assert.assertTrue(app.getUserHelper().validateMessageAlert());


    }

    @Test
    public void negativeLoginUserDTOLombokEmailAndPasswordEmpty() {
        UserDTOLombok user = UserDTOLombok.builder().
                email("").
                password("").
                build();

        app.getUserHelper().loginUserDTOLombok(user);
        Assert.assertTrue(app.getUserHelper().validateMessageAlert());


    }

    @Test
    public void negativeLoginUserDTOLombokEmailWithoutAtSign() {
        UserDTOLombok user = UserDTOLombok.builder().
                email("dana.com").
                password("Dana123$%").
                build();

        app.getUserHelper().loginUserDTOLombok(user);
        Assert.assertTrue(app.getUserHelper().validateMessageAlert());


    }
}

