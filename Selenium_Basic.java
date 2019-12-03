package check;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class Selenium_Basic {

	public static void main(String[] args) {
		
		boolean scroll = true;
		
		WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
            driver.manage().window().maximize();
            driver.get("https://google.bg");
            driver.findElement(By.name("q")).sendKeys("Явор Георгиев Колев" + Keys.ENTER);
            wait.until(presenceOfElementLocated(By.linkText("Изображения")));
            driver.findElement(By.linkText("Изображения")).click();
            while (scroll)
            {
            	JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0,25)", "");
             
                if(driver.findElement(By.id("smb")).isDisplayed()){
                	scroll = false;
                }
                
            }
            driver.quit();

	}

}
