package meaventask;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/windows");
		Thread.sleep(100);
		driver.findElement(By.cssSelector("a[href='/windows/new']")).click();
		// Get the current window handle
		String mainWindowHandle = driver.getWindowHandle();
        // Get all window handles
		Set<String> windowHandles = driver.getWindowHandles();
		// Loop through all handles and switch to new window
		for(String handle : windowHandles) {
			if(!handle.equals(mainWindowHandle)) {
				driver.switchTo().window(handle);  // switch to new window
				System.out.println("New window title: " + driver.getTitle());
				driver.close();
				break;
			}
		}
		// switch back to the original window
		driver.switchTo().window(mainWindowHandle);
		// Continue with actions on the main window (if any)
        System.out.println("Main window title: " + driver.getTitle());
     // Close the main window and quit the browser
        driver.quit();
        
	}
	

}
