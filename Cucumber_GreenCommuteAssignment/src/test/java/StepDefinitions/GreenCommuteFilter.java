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

public class GreenCommuteFilter {
    WebDriver driver = null;
    LoginPage login;

    @Given("SignIn is Done")
    public void sign_in_is_done() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/Driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://3.12.149.188:3000/");
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
        Thread.sleep(3000);
    }

    @And("press the filter button")
    public void press_the_filter_button() throws InterruptedException {
        driver.findElement(By.cssSelector("button[data-testid=\"filter-button\"]")).click();
        Thread.sleep(2000);
    }

    @When("User selects the filtrate options and apply")
    public void user_selects_the_filtrate_options_and_apply() throws InterruptedException {
        driver.findElement(By.cssSelector("input[value=\"0 - 10 Kms\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input[value=\"11 - 20 Kms\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input[value=\"21 - 30 Kms\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input[value=\"31 - 40 Kms\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input[value=\"Anytime\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input[value=\"Full time\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(),'Apply')]")).click();
        Thread.sleep(5000);

    }

    @Then("Jobs will be shown as per the filtration")
    public void jobs_will_be_shown_as_per_the_filtration() throws IOException, InterruptedException {
        Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'0 - 10 Kms')]")).getText(), "0 - 10 Kms");
        Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'11 - 20 Kms')]")).getText(), "11 - 20 Kms");
        Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'21 - 30 Kms')]")).getText(), "21 - 30 Kms");
        Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'31 - 40 Kms')]")).getText(), "31 - 40 Kms");
        Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Anytime')]")).getText(), "Anytime");
        Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Full time')]")).getText(), "Full time");
        Thread.sleep(1000);
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "http://3.12.149.188:3000/findjobs");
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("src/test/screenshots/JobsWithFilters.png"));
        System.out.println("logout done");
        driver.close();
    }
}

