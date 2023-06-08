package StepDefinitions;

import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class GreenCommuteSave {
    WebDriver driver = null;
    LoginPage login;

    @Given("User is in the main page")
    public void user_is_in_the_main_page() throws InterruptedException {
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

    @And("click the first job card")
    public void click_the_first_job_card() throws InterruptedException {
        driver.findElement(By.xpath("//h6[contains(text(),'HP')]")).click();
        Thread.sleep(1000);
    }

    @When("clicking the save option in the job")
    public void clicking_the_save_option_in_the_job() {
        driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();
    }

    @Then("the job will be shown in Saved Jobs section")
    public void the_job_will_be_shown_in_saved_jobs_section() throws InterruptedException {
        driver.findElement(By.cssSelector("a[href=\"/savejobs\"]")).click();
        Thread.sleep(2000);
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "http://3.12.149.188:3000/savejobs");
        Thread.sleep(1000);
        Assert.assertEquals(driver.findElement(By.xpath("//p[contains(text(),'User Experience Designer')]")).getText(), "User Experience Designer");
        System.out.println("logout done");
        driver.close();
    }
}
