package StepDefinitions;

import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;

public class GreenCommuteRoutes {
    WebDriver driver = null;
    LoginPage login;

    @Given("Inside the main page after logging in")
    public void inside_the_main_page_after_logging_in() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/Driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://3.12.149.188:3000/");
        Thread.sleep(2000);
        login = new LoginPage(driver);
        login.enterLocation();
        login.selectOption();
        login.pressNextBtn();

        login.enterJobLocation();
        login.selectOption();
        login.pressNextBtn();

        login.enterSkills();
        Thread.sleep(1000);
        login.selectOption();
        Thread.sleep(1000);
        login.pressNextBtn();

        System.out.println("login Done");
        Thread.sleep(3000);
        driver.getPageSource().contains("GREEN COMMUTE");

    }
    @And("Click on a job card")
    public void click_on_a_job_card() throws InterruptedException, IOException {
        driver.findElement(By.xpath("//h6[normalize-space()='BMW']")).click();
        Thread.sleep(1000);
    }

    @When("clicked on the Green Commute Routes")
    public void clicked_on_the_green_commute_routes() throws InterruptedException {
        driver.findElement(By.cssSelector("button[data-testid=\"greenRoutesButton\"]")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//p[contains(text(),'Common Routes')]")).getText(), "Common Routes");
    }

    @Then("Common cabs and bus routes will be shown")
    public void common_cabs_and_bus_routes_will_be_shown() throws IOException, InterruptedException {

        Assert.assertEquals(driver.findElement(By.xpath("//p[contains(text(), 'Ola')]")).getText(), "Ola");
        File src1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src1, new File("src/test/screenshots/cabOptions.png"));
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("button[id=\"bus\"]")).click();
        Thread.sleep(2000);
        File src2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src2, new File("src/test/screenshots/busOptions.png"));
        Thread.sleep(1000);

        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "http://3.12.149.188:3000/findjobs");

        System.out.println("logout done");
        driver.close();
    }
}
