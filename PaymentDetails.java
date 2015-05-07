package SeleniumMaven.NetFlixUIAutomation;

import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentDetails {
	
	private WebDriver driver;
		
	@FindBy(className = "radio_widget")
	private WebElement paymentTypeBar;

	@FindBy(id = "firstName-CC")
	private WebElement firstNameField;
	
	@FindBy(id = "lastName-CC")
	private WebElement lastNameField;
	
	@FindBy(id = "zipcode")
	private WebElement zipCodeField;
	
	@FindBy(name = "expirationMonth")
	private WebElement expMonthDropDown;
	
	@FindBy(name = "expirationYear")
	private WebElement expYearDropDown;
	
	@FindBy(name = "securityCode")
	private WebElement secCodeField;
	
	@FindBy(name = "cardNumber")
	private WebElement cardNumberField;
	
	@FindBy(className = "terms-checkbox")
	private WebElement temsCheckBox;
	
	@FindBy(css="button.blue.btnlg")
	private WebElement startMembershipBtn;
	
	@FindBy(className = "errormsg")
	private WebElement errorMsgArea;

	public PaymentDetails(WebDriver driver){
		this.driver = driver;
	}


	public PaymentDetails displayPaymentDetailsFields(){
		paymentTypeBar.click();
		return this;
	}

	
	public PaymentDetails enterFirstName(String fName){
		firstNameField.clear();
		firstNameField.sendKeys(fName);
		return this;		
	}
	
	
	public PaymentDetails enterLastName(String lName){
		lastNameField.clear();
		lastNameField.sendKeys(lName);
		return this;		
	}
	
	public PaymentDetails enterCardNumber(String cardNum){
		cardNumberField.sendKeys(cardNum);
		return this;		
	}
	
	public PaymentDetails enterZipCode(String zipCode){
		zipCodeField.sendKeys(zipCode);
		return this;		
	}
	
	public PaymentDetails selectExpMonth(String expMonth){

    	Select select = new Select(expMonthDropDown);
    	select.selectByVisibleText(expMonth);
		return this;		
	}
	
	public PaymentDetails selectExpYear(String expYear){
    	Select select = new Select(expYearDropDown);
    	select.selectByVisibleText(expYear);
		return this;		
	}
	
	public PaymentDetails enterSecCode(String secCode){
		secCodeField.sendKeys(secCode);
		return this;		
	}
	
	public PaymentDetails checkTerms(){
		temsCheckBox.click();
		return this;		
	}
	
	public PaymentDetails generateInvalidEntryError(){
		startMembershipBtn.click();
		return this;
	}
	
	public void verifyInvalidPaymentDetailError(){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		String notValidPaymentDetails0 ="There appears to be a problem with the payment method you are trying to use.";
	//	String notValidPaymentDetails2 ="A valid card number must be entered into the form.";
		
		wait.until(ExpectedConditions.visibilityOf(errorMsgArea));
		AssertJUnit.assertEquals(errorMsgArea.getText(), notValidPaymentDetails0);
	}

}
