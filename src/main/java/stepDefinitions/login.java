package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {

    WebDriver driver;
    @Given("login page URL")
    public void login_page_url() {
        System.setProperty("webdriver.chrome.driver", "/Users/MohanrajVaratharaj/Downloads/SeleniumIDEInurance/chromedriver");
        driver = new ChromeDriver();

        driver.get("http://tanchan-001-site3.btempurl.com/production/admin/");
        driver.manage().window().fullscreen();
    }
    @Given("Enter username and password")
    public void enter_username_and_password() {
        driver.findElement(By.id("AUser")).click();
        driver.findElement(By.id("AUser")).sendKeys("admin");
        driver.findElement(By.id("APwd")).click();
        driver.findElement(By.id("APwd")).sendKeys("yesm");
    }
    @When("Click on sigh in button")
    public void click_on_sigh_in_button() {
        driver.findElement(By.id("ABtn")).click();
    }
    @When("It will enter you to Home page")
    public void it_will_enter_you_to_home_page() {
        String getTitle=driver.getTitle();
        System.out.println(getTitle);
    }
    @Then("sigh out")
    public void sigh_out() {
        driver.findElement(By.id("AdmSessLnk")).click();
    }
    @Then("Close the page browser")
    public void close_the_page_browser() {
        { driver.quit(); }
    }
}
