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

public class GreenCommuteUnsaved {
    WebDriver driver = null;
    LoginPage login;

    @Given("After login main page")
    public void after_login_main_page() throws InterruptedException {
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
    @And("Click on the Saved Jobs tab panel")
    public void click_on_the_saved_jobs_tab_panel() throws InterruptedException {
        driver.findElement(By.cssSelector("a[href=\"/savejobs\"]")).click();
        Thread.sleep(2000);
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "http://3.12.149.188:3000/savejobs");
        Thread.sleep(2000);
    }

    @When("Clicked on the present job card and click on Unsaved option")
    public void clicked_on_the_present_job_card_and_click_on_unsaved_option() throws InterruptedException {
        driver.findElement(By.xpath("//p[contains(text(),'User Experience Designer')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[contains(text(),'Unsave')]")).click();
        Thread.sleep(3000);
    }

    @Then("There will no jobs in the saved jobs section")
    public void there_will_no_jobs_in_the_saved_jobs_section() {
        Assert.assertEquals(driver.findElement(By.xpath("//h3[normalize-space()='No Jobs Found']")).getText(), "No Jobs Found");
        System.out.println("logout done");
        driver.close();
    }
}
