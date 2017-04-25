import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by DIPAK on 3/28/2017.
 */
public class Argos01
{
    public static void main(String[] args)
    {


        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.argos.co.uk/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        // click on clearance

        driver.findElement(By.xpath("//div[@class='text-right header-links-bau']/a[1]")).click();
        //click on home & garden sign
        driver.findElement(By.xpath("//*[@id='cbhome']")).click();
        //click on garden furniture
        driver.findElement(By.xpath("//img[@alt='Garden furniture']")).click();

        //select checkbox for same day delivery
        driver.findElement(By.xpath("//*[@id='FastTrack-refinement']/div[2]/div/label/span")).click();

        //click on cus rationg
        driver.findElement(By.xpath("//*[@id='Customer Rating-refinement']/div[2]/label[2]/span")).click();
        //cilck on clear all
        driver.findElement(By.cssSelector("#refineform-reset-bottom")).click();
        //click on revelance
      //  driver.findElement(By.xpath("//*[@id='stop']")).click();

        WebElement revelance_dd= driver.findElement(By.xpath("//div[@class='mask']/fieldset/select/option"));
        Select revelance_ddd = new Select(revelance_dd);
        List<WebElement>revelance_list=revelance_ddd.getAllSelectedOptions();

        int revelance_total=revelance_list.size();
        System.out.println("Total="+revelance_total);

        for (WebElement element:revelance_list)
        {
            String innerText = element.getAttribute("innerText");
            if (innerText.contentEquals("Price: High - Low"))
            {
                element.click();
                break;
            }
            System.out.println(innerText);
        }
        //click on hogh to low
        driver.findElement(By.xpath("//*[@id='stop']/option[4]")).click();


        //click on add to cart
        driver.findElement(By.xpath("//*[@id='1057296']/dd[5]/a[1]")).click();
        //click on continue button
        driver.findElement(By.xpath("//li[@class='marginLeft25']/a")).click();

        System.out.println("*");


    }
}
