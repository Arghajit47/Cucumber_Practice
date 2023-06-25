package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class GoogleSearchSteps {

    WebDriver driver = null ;
    @Given("Browser is open")
    public void browser_is_open() {
        System.out.println("Browser is open");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }
    @And("User is on Google search page")
    public void user_is_on_google_search_page() throws InterruptedException {
        System.out.println("User is on Search Page");
        driver.get("https://google.com");
        Thread.sleep(3000);
    }
    @When("User enters text in Search box")
    public void user_enters_text_in_search_box() throws InterruptedException {
        driver.findElement(By.name("q")).sendKeys("Automation Step By Step");
        System.out.println("User enters text in search box");
        Thread.sleep(2000);
    }
    @And("Hits enter")
    public void hits_enter() throws InterruptedException {
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        System.out.println("User hits enter");
        Thread.sleep(3000);
    }
    @Then("User is navigated to search results")
    public void user_is_navigated_to_search_results() {
        driver.getPageSource().contains("Online Courses");
        System.out.println("User is navigated to search results");
        driver.close();
        driver.quit();
    }

}
