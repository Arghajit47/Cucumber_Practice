package StepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginSteps {
    WebDriver driver = null;
    @Given("user is on the WebPage")
    public void user_is_on_the_webPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://thinking-tester-contact-list.herokuapp.com");
    }
    @When("user enters email and password")
    public void user_enters_email_and_password() {
        driver.findElement(By.id("email")).sendKeys("arghajitsingha47@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Asughan4711");
    }
    @When("user enters Invalid email and password")
    public void user_enters_invalid_email_and_password() {
        driver.findElement(By.id("email")).sendKeys("arghajitsingha47@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Asughan@4711");
    }
    @Then("click on Submit Button")
    public void click_on_submit_button() {
        driver.findElement(By.id("submit")).click();
    }
    @And("sees Login confirmation")
    public void sees_login_confirmation() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("logout")).isDisplayed();
        driver.findElement(By.cssSelector("html>body>div>p")).equals("Click on any contact to view the Contact Details");
        driver.findElement(By.id("add-contact")).isDisplayed();
        driver.getCurrentUrl().equals("https://thinking-tester-contact-list.herokuapp.com/contactList");
        driver.close();
    }
    @And("sees Incorrect username or password error message")
    public void sees_incorrect_username_or_password_error_message() {
        driver.findElement(By.id("error")).equals("Incorrect username or password");
        driver.close();
    }
}
