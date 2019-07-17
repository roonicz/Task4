import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RedBusTask4 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("--disable-notifications");
		WebDriver dr = new ChromeDriver ();
		
		dr.get("https://www.redbus.in/");
		dr.manage().window().maximize();
		Thread.sleep(3000);
		
		// Click 'block' button in show notifications popup
		
		try {

			   // Check the presence of alert
			   //Alert alert = dr.SwitchTo().Alert();
			   Alert alert = dr.switchTo().alert();

			   // if present consume the alert
//			   alert.accept();
			   alert.dismiss();
			   System.out.println("Alert dismissed");
			   
			   
			   

			  } catch (NoAlertPresentException ex) {
			     System.out.println("No Alert displayed");
			  }
		
		// Hover rPoolNew link in header - it should be show "cars"
		
		WebElement rPool = dr.findElement(By.xpath("//a[@href=' /rPool/']"));
		Actions action = new Actions(dr);
		action.moveToElement(rPool).perform();
		String tooltipmessage = rPool.getText();
		System.out.println("Tooltip message is:  "+tooltipmessage );
		Thread.sleep(3000);
		
		// Click the rPoolNew link
		rPool.click();
		Thread.sleep(5000);
		
		// Check "How it works"- check "Find Ride" is selected or not? it should be selected
		
		dr.findElement(By.xpath("//div[@class='findride-details']"));
		String CurrentSelection = dr.findElement(By.xpath("//span[@class='selected']")).getText();
		System.out.println("The current selection is: " +CurrentSelection);
		
		// dr.findElement(By.xpath("//span[@class='selected']")).
		
		
		
		// Click Offer Ride- and check offer ride is bold or not?
		WebElement OfferRide = dr.findElement(By.xpath("//span[@id='offerride']"));
		Thread.sleep(2000);
		
		
		String FontvalueBefore = OfferRide.getCssValue("font-weight");
		System.out.println(FontvalueBefore);
		
		OfferRide.click();
		String FontvalueAfter = OfferRide.getCssValue("font-weight");
		System.out.println(FontvalueAfter);
		
		if(FontvalueBefore == FontvalueAfter) {
			System.out.println("The OfferRide is not selected");
			}
		else {
			System.out.println("The OfferRide is selected successfully");
		}
		dr.quit();
	}
}
		
		
		
		
			


