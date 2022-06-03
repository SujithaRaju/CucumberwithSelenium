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

public class loginScenarioOutline {

    WebDriver driver;
    Loginpage loginpage;

    @Given("open the browser")
    public void open_the_browser() {
        System.setProperty("webdriver.chrome.driver", "/Users/MohanrajVaratharaj/Downloads/SeleniumIDEInurance/chromedriver");
        driver = new ChromeDriver();
        loginpage = new Loginpage(driver);
    }

    @And("admin type the login page url {string}")
    public void admin_type_the_login_page_url(String url) {
        driver.get(url);
    }

    @And("admin enter the {string} and {string}")
    public void admin_enter_the_admin2_and_yup(String username, String password) {
        try {
            loginpage.login(username, password);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("Click on sigh in button in login page")
    public void click_on_sigh_in_button_login_page() {
        loginpage.sighIn();
    }
    @Then("It should entered into Home Page")
    public void it_should_entered_into_home_page() {
        Assert.assertEquals("Admin | Insurance Application Testing | Yes-M Systems",driver.getTitle());
    }

    @Then("if admin credentials are correct")
    public void if_admin_credentials_are_correct(){
        if(driver.findElement(By.id("AdmSessLnk")).isDisplayed()==true){
            System.out.println("login success");
            loginpage.sighOut();
        }else {
            System.out.println("login unsuccess");
        }
    }

    @Then("Close the browser")
    public void close_the_browser() {
        { driver.quit(); }
    }
}
