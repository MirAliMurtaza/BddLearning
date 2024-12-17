package Screenpages;

import General.Elements;
import General.GeneralFunction;

public class LoginAction extends GeneralFunction {


//    public void OpenUrl() {
//        GotoUrl();
//    }

    public void enterUsername() {
        sendKeys(Elements.username,"standard_user");
    }

    public void enterPassword() {
        sendKeys(Elements.password,"secret_sauce");
    }

    public void enterInvalidEmail() {
        sendKeys(Elements.username,"standard_userrr");
    }

    public void enterInvalidPassword() {
        sendKeys(Elements.password,"invalidpassword");
    }

    public void clickLogin() {
        clickElement(Elements.lgnButtonSetup);
    }
}
