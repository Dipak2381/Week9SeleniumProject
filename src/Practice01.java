import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by DIPAK on 3/30/2017.
 * URL : https://enterprise-demo.orangehrmlive.com/auth/login
 TC : 1
 Admin user should be able to add Employee successfully.
 1.       Login with username “admin” and Password “Admin”
 2.       Click on PIM
 3.       Click Add Employee
 4.       Fill all the compulsory fields
 5.       Save it
 6.       Edit Personal details and fill License Expiry, Marital status, DOB.
 7.       Save it
 8.       Verify “Successfully Saved” message displayed
 9.       Click Employee list
 10.   Search employee by ID
 11.   Verify  same employee(Name) is present in data base at bottom
 */
public class Practice01
{
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        // Open Website
        driver.get("https://enterprise-demo.orangehrmlive.com/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Type Username
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
        // Type Password
        driver.findElement(By.cssSelector("#txtPassword")).sendKeys("admin");
        // Click on Login
        driver.findElement(By.id("btnLogin")).click();
        // Click on PIM
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        // Click Add Employee
        driver.findElement(By.xpath("//a[@id='menu_pim_addEmployee']")).click();
//        DateFormat dateFormat = new SimpleDateFormat("ddhhss");
//        Date date = new Date();
//        String date1 = dateFormat.format(date);
//        String userName = "John"+date1;
//        String username1= "Smith"+date1;
        // Type First name
        driver.findElement(By.id("firstName")).sendKeys("John");
        // Type Last name
        driver.findElement(By.id("lastName")).sendKeys("Smith");
        Random random = new Random();
        int eID = random.nextInt(1000);
        // Click on Location
        driver.findElement(By.id("employeeId")).clear();
        driver.findElement(By.id("employeeId")).sendKeys(""+eID);
        // Click on
        WebElement location_dd = driver.findElement(By.xpath("//select[@id='location']"));
        Select location = new Select(location_dd);
        location.selectByIndex(9);
        // Click Save
        driver.findElement(By.id("btnSave")).click();
        // Click on edit
        driver.findElement(By.xpath("//input[@value='Edit']")).click();
        // Click on licences expiry
        driver.findElement(By.id("personal_txtLicExpDate")).click();
        // Select date
        driver.findElement(By.xpath("html/body/div[4]/table/tbody/tr[5]/td[2]/a")).click();
        // Click on marital box
        driver.findElement(By.id("personal_cmbMarital")).click();
        // Click on married
        driver.findElement(By.xpath("//select[@name='personal[cmbMarital]']/option[3]")).click();
        // Click on Dob box
        driver.findElement(By.id("personal_DOB")).click();
        //click month box
        Select month_dd = new Select(driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[1]")));
        month_dd.selectByVisibleText("Jul");
        // Select Year
        Select year_dd = new Select(driver.findElement(By.xpath("//div/select[2]")));
        year_dd.selectByIndex(35);
        // Click on Date
        driver.findElement(By.xpath("//table/tbody/tr[4]/td[4]/a")).click();
        // Click Save
        driver.findElement(By.id("btnSave")).click();
        // Verify Successfully Saved Message
        //Assert
        Assert.assertTrue("Successfully Saved",driver.findElement(By.xpath("html/body/div[1]/div[3]/div/div[2]/div[2]/div")).isEnabled());
        System.out.println("Successfully Saved");
        //assert1
//        String expectedText = "Successfully Saved";
//        String actualText = driver.findElement(By.xpath("html/body/div[1]/div[3]/div/div[2]/div[2]/div")).getText();
//        Assert.assertEquals(expectedText,actualText);

        // Click Employee List
        driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
//        Thread.sleep(3000);
//        //click on emp name
//        driver.findElement(By.xpath("//input[@id='empsearch_employee_name_empName']")).sendKeys(userName + username1);

//        // Type Employee ID
//        driver.findElement(By.id("empsearch_id")).sendKeys(" "+eID);
//        // Clear Employee ID
//        driver.findElement(By.id("empsearch_id")).clear();
        Thread.sleep(2000);
        // Search Emp by ID
        driver.findElement(By.id("empsearch_id")).sendKeys(""+eID);
        // Search Employee By ID
//        driver.findElement(By.id("searchBtn")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("searchBtn")).click();

        //Assert
        Assert.assertTrue("John",driver.findElement(By.xpath("//tbody/tr/td[3]/a")).isEnabled());
        System.out.println("John");

//
    }
}
