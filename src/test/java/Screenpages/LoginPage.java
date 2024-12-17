package Screenpages;

import General.Elements;
import General.GeneralFunction;
import org.openqa.selenium.By;

public class LoginPage {


    public void enterUsername(String username) {
        GeneralFunction.sendKeys(Elements.usernameLocator, username);
    }

    public void enterPassword(String password) {
        GeneralFunction.sendKeys(Elements.passwordLocator, password);
    }

    public void clickLoginButton() {
        GeneralFunction.clickElement(Elements.lgnButton);
    }
}
