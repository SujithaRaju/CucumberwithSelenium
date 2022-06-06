package stepDefinitions;

import PageObject.Loginpage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginScenarioOutline {
    WebDriver driver;
    Loginpage loginpage;

    @Given("open the browser")
    public void open_the_browser() {
        System.setProperty("webdriver.chrome.driver", "/Users/MohanrajVaratharaj/Downloads/SeleniumIDEInurance/chromedriver");
        driver = new ChromeDriver();
        loginpage=new Loginpage(driver);
    }
    @And("admin type the login page url {string}")
    public void admin_type_the_login_page_url(String string) {
        driver.get("http://tanchan-001-site3.btempurl.com/production/admin/");
        driver.manage().window().fullscreen();
    }
    @And("admin enter the {string} and {string}")
    public void admin_enter_the_and(String username, String password) throws InterruptedException {
        loginpage.login(username,password);
    }
    @When("Click on sigh in button in login page")
    public void click_on_sigh_in_button_in_login_page() throws InterruptedException {
        loginpage.sighIn();
        Thread.sleep(1000);
    }
    @And("if admin credentials are correct")
    public void if_admin_credentials_are_correct() throws InterruptedException {
        Thread.sleep(1000);
       loginpage.sighOutValidation();
    }
    @Then("It should entered into Home Page")
    public void it_should_entered_into_home_page() throws InterruptedException {
        Thread.sleep(1000);
       loginpage.sighOut();
    }
    @And("Close the browser")
    public void close_the_browser() {
       loginpage.quitBrowser();
        System.out.println("Quited the browser");
    }
}
