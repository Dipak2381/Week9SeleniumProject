
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

/**
 * Created by DIPAK on 3/25/2017.
 */
public class Ebay01
{
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.ebay.co.uk/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

       // driver.findElement(By.xpath("//tr[@role='list']/td[4]/a")).click();

        WebElement Fashion =  driver.findElement(By.xpath("//tr[@role='list']/td[4]/a"));
        Actions act = new Actions(driver);
        act.moveToElement(Fashion).build().perform();

         driver.findElement(By.xpath("//ul[@class='col']/li[2]/a")).click();
        //Actions act1 = new Actions(driver);
       // act.moveToElement(men).build().perform();
        driver.findElement(By.xpath("//img[@alt='Underwear & Socks ']")).click();
        //img[@alt='Underwear & Socks ']
        // click on categaries

        driver.findElement(By.className("icon-deals-caret")).click();
      // click on best seller
        driver.findElement(By.xpath("//a[@title='Best Sellers']")).click();
        //scroll down
        Thread.sleep(5000);

        ((JavascriptExecutor)driver).executeScript("0,2000");

        System.out.println("hello");
    }
    }

