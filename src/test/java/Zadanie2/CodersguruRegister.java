package Zadanie2;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class CodersguruRegister {
    WebDriver driver;

    @Given("^I'm on website on website \"([^\"]*)\"$")
    public void iMOnWebsiteOnWebsite(String arg0) {
        System.setProperty("webdriver.gecko.driver",
                "src/test/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://men-men-s-01.codersguru.pl/");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

        @When("^I click button \"([^\"]*)\"$")
        public void iClickButton(String arg0) {
            WebElement buttonCreateAccount = driver.findElement(By.className("main-page-top__email-input-sent"));
            buttonCreateAccount.click();

        }

        @And("^I click on button \"([^\"]*)\"$")
        public void iClickOnButton(String arg0) {
            WebElement buttonPrivate = driver.findElement(By.id("person"));
            buttonPrivate.click();
        }

        @And("^I register user with \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
        public void iRegisterUserWith(String email, String name, String surname, String password, String city, String postal_code, String street, String house_number) {
            WebElement eMail = driver.findElement(By.id("fos_user_registration_form_email"));
            eMail.click();
            eMail.clear();
            eMail.sendKeys(email);

            WebElement firstName = driver.findElement(By.id("fos_user_registration_form_name"));
            firstName.click();
            firstName.clear();
            firstName.sendKeys(name);

            WebElement lastName = driver.findElement(By.id("fos_user_registration_form_lastname"));
            lastName.click();
            lastName.clear();
            lastName.sendKeys(surname);

            WebElement accessPassword = driver.findElement(By.id("fos_user_registration_form_plainPassword_first"));
            accessPassword.click();
            accessPassword.clear();
            accessPassword.sendKeys(password);

            WebElement repeatedPassword = driver.findElement(By.id("fos_user_registration_form_plainPassword_second"));
            repeatedPassword.click();
            repeatedPassword.clear();
            repeatedPassword.sendKeys(password);

            WebElement cityOfLiving = driver.findElement(By.id("form_city"));
            cityOfLiving.click();
            cityOfLiving.clear();
            cityOfLiving.sendKeys(city);

            WebElement codePostal = driver.findElement(By.id("form_postal_code"));
            codePostal.click();
            codePostal.clear();
            codePostal.sendKeys(postal_code);

            WebElement adressStreet = driver.findElement(By.id("form_street"));
            adressStreet.click();
            adressStreet.clear();
            adressStreet.sendKeys(street);

            WebElement numberOfHouse = driver.findElement(By.id("form_number"));
            numberOfHouse.click();
            numberOfHouse.clear();
            numberOfHouse.sendKeys(house_number);
        }


        @And("^I click on checkbox \"([^\"]*)\"$")
        public void iClickOnCheckbox(String arg0) {
            WebElement checkboxRulebook = driver.findElement(By.xpath("/html/body/div/div/div/form/div[12]/input"));
            checkboxRulebook.click();

        }

        @And("^click on button \"([^\"]*)\"$")
        public void clickOnButton(String arg0) {
            WebElement registerButton = driver.findElement(By.id("registration-main-form"));
            registerButton.submit();
        }
        @Then("^on the left the main website should contain \"([^\"]*)\"$")
        public void onTheLeftTheMainWebsiteShouldContain(String name) {
            WebElement usersNameDisplayed = driver.findElement(By.id("user-name"));
           Assert.assertTrue(usersNameDisplayed.getText().contains(name));
        }

        @And("^user is registered$")
        public void userIsRegistered() {
        }
    }
