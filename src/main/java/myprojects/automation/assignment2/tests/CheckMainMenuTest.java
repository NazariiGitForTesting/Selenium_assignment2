package myprojects.automation.assignment2.tests;

import myprojects.automation.assignment2.BaseScript;
import myprojects.automation.assignment2.utils.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheckMainMenuTest extends BaseScript {

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

        List<WebElement> menuList = driver.findElements(By.xpath("//*[@class = 'menu']/li/a"));
        List<String> linkList = new ArrayList<>();
        for (int i =0; i<menuList.size();i++){
            String link = menuList.get(i).getAttribute("href");
            linkList.add(link);
        }

        for(int i =0; i<linkList.size();i++){
            driver.navigate().to(linkList.get(i));
            String title = driver.getTitle();
            System.out.println(title);
            driver.navigate().refresh();
            String titleAfterRefresh = driver.getTitle();
            if (title.equals(titleAfterRefresh)){
                System.out.println("The title before refresh ("+title+") is equals the title after refresh("+ titleAfterRefresh+ ") - true");
            }else System.out.println("The title before refresh ("+title+") is not equals the title after refresh("+ titleAfterRefresh+ ") - false");



        }



    }
}
