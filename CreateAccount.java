package SeleniumMaven.NetFlixUIAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CreateAccount {
	
	private WebDriver driver;
	private WebDriverWait wait;
		
	@FindBy(id = "email")
	private WebElement emailAddressField;

	@FindBy(id = "password")
	private WebElement passwordField;
	
	@FindBy(id="regFormButton")
	private WebElement regFormBtn;
	
	@FindBy(id="cont_tiers_button")
	private WebElement continueBtn;

	public CreateAccount(WebDriver driver){
		this.driver = driver;
	}
	
	public CreateAccount clickContinueBtn(){
		if(continueBtn.isDisplayed()){
			continueBtn.click();
		}
		return this;
	}


	public CreateAccount enterEmailAddress(String email){
		emailAddressField.sendKeys(email);
		return this;
	}

	public CreateAccount enterPassword(String passwd){
		passwordField.sendKeys(passwd);
		return this;
	}
	
	public PaymentDetails clickRegisterButton(){
		regFormBtn.click();
		return PageFactory.initElements(driver, PaymentDetails.class);
	}
}
