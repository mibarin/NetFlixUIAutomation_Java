package SeleniumMaven.NetFlixUIAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class pageHome {
	
	private WebDriver driver;
	private WebDriverWait wait;
		
	@FindBy(name = "start")
	private WebElement startYourFreeMonthBtn;


	public pageHome(WebDriver driver){
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
		System.out.println("in pageHome constructor");
	}


	public CreateAccount clickOnStartYourFreeMonthbtn(){
		wait.until(ExpectedConditions.visibilityOf(startYourFreeMonthBtn));
		startYourFreeMonthBtn.click();
//		driver.findElement(By.className("blue")).click();
		return PageFactory.initElements(driver, CreateAccount.class);
	}

}
