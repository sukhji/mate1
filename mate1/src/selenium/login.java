package selenium;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.security.Credentials;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

public class login {
	public static Boolean Elementexist(By i,WebDriver driver)
	{ 
		try {
	        driver.findElement(i);
	        return true;
	    } catch (org.openqa.selenium.NoSuchElementException e) {
	        return false;
	    }
		
	}
	
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");

		WebDriver driver =new ChromeDriver();
		driver.get("http://www.mate1.com/ajax/login?iframe");

	//inserts the credentials
driver.findElement(By.xpath("//*[@id='email']")).sendKeys("mails.sukh@gmail.com");
driver.findElement(By.xpath("//*[@id='password']")).sendKeys("sukh_4321");

//logs in		 
driver.findElement(By.xpath("//*[@id='member_login']/div[5]/input")).submit();
//checks for the error
boolean b=Elementexist(By.xpath("//*[@id='member_login_errors']"), driver);

if(b)
{
	System.out.println("Invalid username or password");

	System.exit(0);
}
//goes to my profile
driver.findElement(By.xpath("//*[@id='profile_dd_li']/a")).click();
driver.findElement(By.xpath("//*[@id='profile_dd_li']/ul/li[1]/a")).click();
driver.findElement(By.xpath("//*[@id='profile_dd_li']/a")).click();
//goes to edit page
driver.findElement(By.xpath(" //*[@id='profile_dd_li']/ul/li[2]/a")).click();
List<WebElement> el = driver.findElements(By.cssSelector("*"));
int i=0;
//gets the title input field
WebElement j=driver.findElement(By.id("page-mask"));
j=j.findElement(By.id("page-wrapper"));
j=j.findElement(By.id("content"));
j=j.findElement(By.id("centerColumn"));
j=j.findElement(By.className("profile-page"));
j=j.findElement(By.id("form_basic_information"));
WebElement form=j; 
j=j.findElement(By.xpath("//*[@id='container_basic_information']/table/tbody/tr/td[2]"));
j=j.findElement(By.xpath("//*[@id='basic_information']"));
//j=j.findElement(By.xpath("//*[@id='basic_information']/ul"));
j=j.findElement(By.xpath("//*[@id='basic_information']/ul/li[1]"));

j=j.findElement(By.xpath("//*[@id='title']"));
//sets the value of title input field
((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('value', 'asfasf')", j);
form=form.findElement(By.xpath("//*[@id='container_basic_information']/div[4]"));
//submits the changed data
form.findElement(By.xpath("//*[@id='submit_basic_information']")).click();

	}
		

	
	

}


