package tests;

import dto.UserDTO;
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
}
