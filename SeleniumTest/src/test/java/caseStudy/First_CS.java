package caseStudy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class First_CS 
{
    WebDriver driver;
    String s ="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    
    @BeforeTest
    public void start()
    {
    	WebDriverManager.chromedriver().setup();
    	driver = new ChromeDriver();
    	driver.get(s);
    	driver.manage().window().maximize();
    }
    
    @Test
    public void mac() throws InterruptedException
    {
    	Thread.sleep(4000);
    	driver.findElement(By.name("username")).sendKeys("Admin");
    	Thread.sleep(2000);
    	driver.findElement(By.name("password")).sendKeys("admin123");
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//button[@type='submit']")).click();
    	Thread.sleep(2000);
    }
    
    @Test
    public void mac1()
    {
    	List<WebElement> list = driver.findElements(By.tagName("a"));
        System.out.println(list.size());
        for(int i=0;i<list.size();i++)
        {
        	System.out.println(list.get(i).getAttribute("href"));
        	System.out.println(list.get(i).getText());
        }
    }
    
    @Test
    public void mac2() throws InterruptedException
    {
    	Thread.sleep(3000);
    	driver.findElements(By.xpath("//*[@class='oxd-icon bi-check oxd-checkbox-input-icon']")).get(6).click();
    	Thread.sleep(4000);
    	driver.findElements(By.xpath("//*[@class='oxd-icon bi-trash']")).get(6).click();
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")).click();
    }
    
    @AfterTest
    public void stop() throws InterruptedException
    {
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//*[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//a[text()='Logout']")).click();
    	Thread.sleep(3000);
    	driver.close();
    }
}
