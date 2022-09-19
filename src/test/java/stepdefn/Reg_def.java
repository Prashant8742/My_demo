package stepdefn;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class Reg_def {
        WebDriver d1;
    protected Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());

    @Test
    @Given("open chrome browser and url of the application")
    public void open_chrome_browser_and_url_of_the_application() {
        // Write code here that turns the phrase above into concrete actions
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
        d1=new ChromeDriver();
        d1.get("https://www.allendigital.in");
        d1.manage().window().maximize();
        d1.manage().deleteAllCookies();
        logger.info("Opne URL of Application");


    }
    @Test
    @And("Click on Sign up button for Registration")
    public void click_on_sign_up_button_for_registration() {
        // Write code here that turns the phrase above into concrete actions
        WebElement a = d1.findElement(By.xpath("//*[@id=\"navbarNavDropdown\"]/ul/li[5]/button"));
        a.click();
        d1.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        d1.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        logger.info("Clicked on Signup button");
    }
    @Test
    @Then("Enter all the details in Registration form")
    public void enter_all_the_details_in_registration_form() throws InterruptedException, IllegalMonitorStateException {
        // Write code here that turns the phrase above into concrete actions
//        //Declare and initialise a fluent wait
        FluentWait wait = new FluentWait(d1);
        //Specify the timout of the wait
        wait.withTimeout(5000, TimeUnit.MILLISECONDS);
        //Specify polling time
        wait.pollingEvery(1000, TimeUnit.MILLISECONDS);
        //Specify what exceptions to ignore
        wait.ignoring(NoSuchElementException.class);

        //This is how we specify the condition to wait on.
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("onetrust-accept-btn-handler")));

        //Accepted Cookies
        d1.findElement(By.id("onetrust-accept-btn-handler")).click();
        logger.info("Cookies Accepted");



        //Enter First Name
        d1.findElement(By.id("mat-input-0")).sendKeys("TestName");
        logger.info("FIlled First name Value");

        //Enter Last Name
        d1.findElement(By.id("mat-input-1")).sendKeys("TestG");
        logger.info("FIlled Last name Value");

        //Enter Email Name
        d1.findElement(By.id("mat-input-2")).sendKeys("Test@gmail.com");
        logger.info("FIlled Email Value");

        //Enter Mobile No.
        d1.findElement(By.id("mat-input-3")).sendKeys("8696864130");
        logger.info("FIlled Mobile No. Value");

        //Enter Password Value
        d1.findElement(By.id("mat-input-10")).sendKeys("Passw12345@");
        logger.info("FIlled Password Value");

        //Enter Confirm Password Value
        d1.findElement(By.id("mat-input-11")).sendKeys("Passw12345@");
        logger.info("FIlled Confirm Password Value");

        //select the Country
        d1.findElement(By.id("mat-select-2")).click();
        WebElement Country = d1.findElement(By.xpath("//*[@id=\"mat-option-389\"]/span"));
        Country.click();
        logger.info("selected the Country");

        //select the State
        d1.findElement(By.id("mat-select-4")).click();
       WebElement State =  d1.findElement(By.xpath("//*[@id=\"mat-option-29\"]/span"));
       State.click();
        logger.info("selected the state");




        //See Terms and condition
        d1.findElement(By.linkText("Terms & Conditions")).click();
        String currentHandle= d1.getWindowHandle();
        d1.switchTo().window(currentHandle);
        logger.info("Terms and condition should be visible");


        //Go agian to Reg form window
//        d1.navigate().forward();
//        JavascriptExecutor js = (JavascriptExecutor) d1;
//        ((JavascriptExecutor) d1).executeScript("window.history.go(-1)");
        wait.withTimeout(5000, TimeUnit.MILLISECONDS);
        //Specify polling time
        wait.pollingEvery(1000, TimeUnit.MILLISECONDS);
        //Specify what exceptions to ignore
        wait.ignoring(NoSuchElementException.class);

        //This is how we specify the condition to wait on.
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"home-back-button\"]/span[1]/mat-icon")));
//
        d1.findElement(By.xpath("//*[@id=\"home-back-button\"]/span[1]/mat-icon")).click();
        logger.info("Going to Reg Form");

        //Accept terms and condition
        d1.findElement(By.id("mat-checkbox-1-input")).click();

        //click on next
        d1.findElement(By.xpath("//*[@id=\"cdk-step-content-0-0\"]/div/form/button")).click();


        //closing window
        d1.close();

    }

    @When("enter username and password")
    public void enter_username_and_password() {
        // Write code here that turns the phrase above into concrete actions
        d1.findElement(By.id("userName")).sendKeys("username");
        d1.findElement(By.id("password")).sendKeys("password");

        System.out.println("when done");
    }

    @Then("Login success")
    public void login_success() {
        // Write code here that turns the phrase above into concrete actions
        d1.findElement(By.id("submitBtn")).click();

        System.out.println("then done");
    }

    }

