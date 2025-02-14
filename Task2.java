package meaventask;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/frames");
		// Verify the page title
        String pageTitle = driver.getTitle();
        System.out.println("Page title: " + pageTitle);
        assert pageTitle.equals("Frames");
        
		driver.get("https://the-internet.herokuapp.com/nested_frames");
        
		driver.switchTo().frame("frame-top");
		//verify there are three frames left,middle,right
		int frameCount = driver.findElements(By.xpath("//frame")).size();
        System.out.println("Frame count in Top Frame: " + frameCount);
        
        // Switch to the left frame and verify the text
        driver.switchTo().frame("frame-left");
        String leftText = driver.findElement(By.xpath("//body")).getText();
        System.out.println("Left frame text: " + leftText);
        assert leftText.equals("LEFT");
        
     // Switch back to the top frame
        driver.switchTo().parentFrame();
        
     // Switch to the middle frame and verify text
        driver.switchTo().frame("frame-middle");
        String middleText = driver.findElement(By.xpath("//div")).getText();
        System.out.println("Middle frame text: " + middleText);
        assert middleText.equals("MIDDLE");

        // Switch back to the top frame
        driver.switchTo().parentFrame();
        
        // Switch to the right frame and verify text
        driver.switchTo().frame("frame-right");
        String rightText = driver.findElement(By.xpath("//body")).getText();
        System.out.println("Right frame text: " + rightText);
        assert rightText.equals("RIGHT");

        // Switch back to the top frame
        driver.switchTo().parentFrame();
        
     // Switch to the bottom frame and verify text
        driver.switchTo().defaultContent();  // Go to the main page
        driver.switchTo().frame("frame-bottom");
        String bottomText = driver.findElement(By.xpath("//body")).getText();
        System.out.println("Bottom frame text: " + bottomText);
        assert bottomText.equals("BOTTOM");

        // Switch back to the top frame (main page)
        driver.switchTo().defaultContent();
        
     // Close the browser
        driver.quit();

	}

}
