package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class LoginPage {
    WebDriver driver;

    private By input_location = By.cssSelector("input[id=\"combo-box-demo\"]");
    private By input_jobLocation = By.cssSelector("input[id=\"combo-box-demo\"]");
    private By input_skills = By.cssSelector("input[id=\"combo-box-demo\"]");
    private By btn_next = By.cssSelector("button[data-testid=\"nextButton\"]");
    private By select_option = By.cssSelector("div[role=\"presentation\"]");
    String location1 = "Hyderabad";
    String jobLocation = "Hyderabad";
    String skills = "Product Designer";


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }



    public void enterLocation() {
        driver.findElement(input_location).sendKeys(location1);
    }
    public void enterJobLocation() {
        driver.findElement(input_jobLocation).sendKeys(jobLocation);
    }
    public void enterSkills() {
        driver.findElement(input_skills).sendKeys(skills);
    }
    public void pressNextBtn() {
        driver.findElement(btn_next).click();
    }
    public void selectOption() {
        driver.findElement(select_option).click();
    }
}
