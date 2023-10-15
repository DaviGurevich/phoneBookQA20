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
       String text = alert.getText();
       Assert.assertEquals(text, "Wrong email or password");
       alert.accept();

    }

}