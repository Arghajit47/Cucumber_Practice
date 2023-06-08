//package StepDefinitions;
//
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import java.util.concurrent.TimeUnit;
//
//public class DemoLoginSteps {
//
//    WebDriver driver = null;
//    @Given("Open the Browser")
//    public void open_the_browser() {
//        System.out.println("Browser is open");
//        System.setProperty("webdriver.chrome.driver", "src/test/Driver/chromedriver");
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//    }
//    @And("User is navigated to the Demo Website")
//    public void user_is_navigated_to_the_demo_website() throws InterruptedException {
//        System.out.println("User is on Search Page");
//        driver.get("https://example.testproject.io/web/");
//        Thread.sleep(3000);
//    }
//    @When("^User input the (.*) and (.*)$")
//    public void user_input_the_full_name_and_password(String FullName, String Password) throws InterruptedException {
//        driver.findElement(By.cssSelector("input[id=\"name\"]")).sendKeys(FullName);
//        Thread.sleep(2000);
//        driver.findElement(By.cssSelector("input[id=\"password\"]")).sendKeys(Password);
//        Thread.sleep(2000);
//        driver.findElement(By.cssSelector("button[id=\"login\"]")).click();
//        Thread.sleep(3000);
//    }
//    @Then("User is navigated to the home page")
//    public void user_is_navigated_to_the_home_page() {
//        driver.findElement(By.id("logout")).isDisplayed();
//
//        driver.close();
//        driver.quit();
//    }
//}
