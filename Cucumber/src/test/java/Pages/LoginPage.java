package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    private By txt_fullname = By.id("name");
    private By txt_password = By.id("password");
    private By btn_login = By.id("login");
    private By btn_logout = By.id("logout");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        if(!driver.getTitle().equals("TestProject Demo")) {
            throw new IllegalStateException("This is not the correct page. The current page name is : " + driver.getTitle());
        }
    }


    public void enterFullName(String FullName) {
        driver.findElement(txt_fullname).sendKeys(FullName);
    }
    public void enterPassword(String Password) {
        driver.findElement(txt_password).sendKeys(Password);
    }
    public void clickLogin() {
        driver.findElement(btn_login).click();
    }

    public void checkLogOutIsDisplayed() {
        driver.findElement(btn_logout).isDisplayed();
    }


}
