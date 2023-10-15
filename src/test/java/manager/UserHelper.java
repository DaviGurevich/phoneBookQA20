package manager;

import dto.UserDTO;
import dto.UserDTOLombok;
import dto.UserDTOWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class UserHelper extends BaseHelper {

    public UserHelper(WebDriver driver) {
        super(driver);
    }

    By btnLoginNavigatorMenu = By.xpath("//a [@href='/login']");
    By inputEmailLoginForm = By.xpath("//input[@name='email']");
    By inputPasswordLoginForm = By.xpath("//input[@name='password']");
    By btnLoginForm = By.xpath("//button[@type='submit']");
    By messageSuccessLogin = By.xpath("//*[text()='CONTACTS']");

    public void login(UserDTO userDTO) {
        clickBase(btnLoginNavigatorMenu);
        typeTextBase(inputEmailLoginForm, userDTO.getEmail());
        typeTextBase(inputPasswordLoginForm, userDTO.getPassword());
        clickBase(btnLoginForm);
    }

    public void loginUserDTOLombok(UserDTOLombok user) {
        clickBase(btnLoginNavigatorMenu);
        typeTextBase(inputEmailLoginForm, user.getEmail());
        typeTextBase(inputPasswordLoginForm, user.getPassword());
        clickByXY(btnLoginForm, 390, 50);



    }

    private void clickByXY(By locator, double down, int right) {
        Rectangle rect = findElementBase(locator).getRect();
        int x = rect.getX()+(rect.getWidth() / right);
        int y = (int)(rect.getY()+(rect.getHeight() / down));
        Actions actions = new Actions(driver);
        actions.moveByOffset(x, y).click().perform();
    }

    public void login(UserDTOWith userDTO) {
        clickBase(btnLoginNavigatorMenu);
        typeTextBase(inputEmailLoginForm, userDTO.getEmail());
        typeTextBase(inputPasswordLoginForm, userDTO.getPassword());
        clickBase(btnLoginForm);
    }

    public boolean validateMessageSuccessAfterLogin() {
        return isTextEqual(messageSuccessLogin, "CONTACTS");
    }

}
