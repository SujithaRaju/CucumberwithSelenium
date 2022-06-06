package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

    WebDriver driver;

    DashboardPage dashboardPage=new DashboardPage();

    public Loginpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "AUser")
    private WebElement adminUserName;

    @FindBy(id = "APwd")
    private WebElement adminPassword;

    @FindBy(id = "ABtn")
    private WebElement signInButton;

    @FindBy(id="AdmSessLnk")
    private WebElement signOutButton;


    public void login(String userName, String password) throws InterruptedException
    {
        adminUserName.click();
        adminUserName.sendKeys(userName);
        adminPassword.click();
        adminPassword.sendKeys(password);

    }

    public void sighIn() throws InterruptedException {
        signInButton.click();
        Thread.sleep(1000);

    }

    public void sighOut(){
        try{
            if(driver.findElement(By.xpath("//a[@href='/production/admin/signout']")).getText().equalsIgnoreCase("SIGN OUT")) {
                signOutButton.click();
                System.out.println("Logged out");
            }
        }catch (NoSuchElementException noSuchElementException){
            System.out.println("Sorry, Page not available");
        }
    }

    public void quitBrowser(){
        driver.quit();
    }


    public void sighOutValidation(){
        try{
            if(driver.findElement(By.xpath("//a[@href='/production/admin/signout']")).getText().equalsIgnoreCase("SIGN OUT")){
                System.out.println("login success");
            }
        }catch (NoSuchElementException noSuchElementException){
            System.out.println("Please Enter Valid credentials");
        }
    }

}
