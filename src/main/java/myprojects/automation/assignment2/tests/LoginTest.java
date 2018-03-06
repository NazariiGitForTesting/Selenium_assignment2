package myprojects.automation.assignment2.tests;

import myprojects.automation.assignment2.BaseScript;
import myprojects.automation.assignment2.utils.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

public class LoginTest extends BaseScript {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = getDriver();


        String login = "webinar.test@gmail.com";
        String password = "Xcg7299bnSmMuRLp9ITw";
        driver.get(Properties.getBaseAdminUrl());
        WebElement loginField = driver.findElement(By.xpath("//*[@id = 'email']"));
        WebElement passwordField = driver.findElement(By.xpath("//*[@id = 'passwd']"));
        WebElement submitLoginButton = driver.findElement(By.xpath("//*[@name='submitLogin']"));

        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        submitLoginButton.click();

        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        WebElement smallAvatar = driver.findElement(By.xpath("//*[@class = 'employee_avatar_small']"));
        WebElement logOutButton = driver.findElement(By.xpath("//*[@id = 'header_logout']"));
        smallAvatar.click();
        logOutButton.click();

    }
}
