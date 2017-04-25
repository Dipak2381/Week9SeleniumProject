
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

/**
 * Created by DIPAK on 3/25/2017.
 */
public class Fcaebook01
{
    public static void main(String[] args)
    {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://en-gb.facebook.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("u_0_r")).click();

        driver.findElement(By.id("u_0_1")).sendKeys("ray");

        driver.findElement(By.id("u_0_3")).sendKeys("rock");

        driver.findElement(By.cssSelector("#u_0_6")).sendKeys("01233374567");

        driver.findElement(By.cssSelector("#u_0_d")).sendKeys("aa456789bb");
//day
        WebElement select_day = driver.findElement(By.cssSelector("#day"));

        Select dd = new Select(select_day);

        dd.selectByIndex(15);
        //month
        WebElement select_month = driver.findElement(By.cssSelector("#month"));

        Select mm = new Select(select_month);

        mm.selectByIndex(05);

        //year
        WebElement select_year = driver.findElement(By.cssSelector("#year"));

        Select yy = new Select(select_year);

        yy.selectByIndex(20);

        //gender
        driver.findElement(By.cssSelector("#u_0_h")).click();

        driver.findElement(By.cssSelector("#u_0_l")).click();

        Assert.assertTrue("Log in to Facebook",driver.findElement(By.xpath("//span[@text()='Log in to Facebook'")).isEnabled());
        System.out.println("Log in to Facebook");

    }
    }

