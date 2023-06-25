package StepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class contactListSteps {
    WebDriver driver = null;
    @Given("user starting the WebDriver")
    public void user_starting_the_WebDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://thinking-tester-contact-list.herokuapp.com");
    }
    @Given("Login to the webPage")
    public void login_to_the_web_page() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("email")).sendKeys("arghajitsingha47@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Asughan4711");
        driver.findElement(By.id("submit")).click();
    }
    @When("sees contactList Url for login confirmation")
    public void sees_contact_list_url_for_login_confirmation() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        Thread.sleep(2000);
        driver.getCurrentUrl().equals("https://thinking-tester-contact-list.herokuapp.com/contactList");
    }
    @Then("sees the Contact List Page")
    public void sees_the_contact_list_page() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        Thread.sleep(2000);
        driver.findElement(By.id("logout")).isDisplayed();
        driver.findElement(By.cssSelector("html>body>div>p")).equals("Click on any contact to view the Contact Details");
        driver.findElement(By.id("add-contact")).isDisplayed();
        driver.close();
    }
    @And("click on Add button")
    public void click_on_Add_button() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("add-contact")).click();
    }
    @When("fill the required fields")
    public void fill_the_required_fields() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("firstName")).sendKeys("Arghajit");
        driver.findElement(By.id("lastName")).sendKeys("Singha");
        driver.findElement(By.id("birthdate")).sendKeys("1999-11-19");
        driver.findElement(By.id("email")).sendKeys("arghajitsingha@gmail.com");
        driver.findElement(By.id("phone")).sendKeys("7608584995");
        driver.findElement(By.id("street1")).sendKeys("122 k.b. lane, Raniganj, West Bengal");
        driver.findElement(By.id("street2")).sendKeys("Sai Krupa Heights, Hyderabad, Telangana");
        driver.findElement(By.id("city")).sendKeys("Hyderabad");
        driver.findElement(By.id("stateProvince")).sendKeys("Telangana");
        driver.findElement(By.id("postalCode")).sendKeys("500048");
        driver.findElement(By.id("country")).sendKeys("India");
    }
    @And("click on confirm button")
    public void click_on_confirm_button() throws InterruptedException {
        driver.findElement(By.id("submit")).click();
        Thread.sleep(2000);
    }
    @Then("sees contact in the table")
    public void sees_contact_in_the_table() throws InterruptedException {
        Thread.sleep(2000);
        for (int i = 0; i < 7; i++){
            driver.findElements(By.cssSelector("table#myTable>tr>td")).get(i).isDisplayed();
        }
        driver.close();
    }

    @And("click on the contact to see Contact Details page")
    public void clickOnTheContactToSeeContactDetailsPage() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("table#myTable>tr")).click();
        Thread.sleep(2000);
        driver.getCurrentUrl().equals("https://thinking-tester-contact-list.herokuapp.com/contactDetails");
        driver.findElement(By.id("edit-contact")).isDisplayed();
        driver.findElement(By.id("delete")).isDisplayed();
        driver.findElement(By.id("return")).isDisplayed();
        driver.findElement(By.id("phone")).equals("760858995");
    }

    @When("click on Edit Contact to see Edit Contact page")
    public void clickOnEditContactToSeeEditContactPage() throws InterruptedException {
        driver.findElement(By.id("edit-contact")).click();
        Thread.sleep(2000);
        driver.getCurrentUrl().equals("https://thinking-tester-contact-list.herokuapp.com/editContact");
    }

    @And("change phone number")
    public void changePhoneNumber() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("phone")).sendKeys("7809895446");
    }

    @Then("checks the number is updated")
    public void checksTheNumberIsUpdated() {
        driver.findElement(By.id("phone")).clear();
        driver.findElement(By.id("phone")).equals("7809895446");
        driver.close();
    }

    @When("click on Delete button")
    public void clickOnDeleteButton() throws InterruptedException {
        driver.findElement(By.id("delete")).click();
        Thread.sleep(2000);
    }

    @Then("confirm the Delete")
    public void confirmTheDelete() throws InterruptedException {
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        driver.getCurrentUrl().equals("https://thinking-tester-contact-list.herokuapp.com/contactList");
    }

    @And("Log out from Account to see Login page")
    public void logOutFromAccountToSeeLoginPage() throws InterruptedException {
        driver.findElement(By.id("logout")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("email")).isDisplayed();
        driver.findElement(By.id("password")).isDisplayed();
        driver.findElement(By.id("submit")).isDisplayed();
        driver.findElement(By.id("signup")).isDisplayed();
        driver.quit();
    }
}
