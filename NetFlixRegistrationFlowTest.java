package SeleniumMaven.NetFlixUIAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class NetFlixRegistrationFlowTest {

	private WebDriver driver;

	@Test
	public void registrationFlowInvalidCreditCardMessageTest() throws InterruptedException {

		driver.get("https://www.netflix.com/");
		

		pageHome startFreeMonth=PageFactory.initElements(driver, pageHome.class);
		CreateAccount register = startFreeMonth.clickOnStartYourFreeMonthbtn();
		register.clickContinueBtn();
		register.enterEmailAddress("net1234@1234.com");
		register.enterPassword("09876543");
		PaymentDetails paymentDetails = register.clickRegisterButton();
		paymentDetails.displayPaymentDetailsFields();
		paymentDetails.enterFirstName("Net");
		paymentDetails.enterLastName("Flix");
		paymentDetails.enterZipCode("94122");
		paymentDetails.enterCardNumber("44004422450656004");
		paymentDetails.selectExpMonth("Jan (1)");
		paymentDetails.selectExpYear("2020");
		paymentDetails.enterSecCode("123");
		paymentDetails.checkTerms();
		paymentDetails.generateInvalidEntryError();
		paymentDetails.verifyInvalidPaymentDetailError();
	}

	@BeforeMethod
	public void setup(){
		driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();
	}

//	@AfterMethod
//	public void tearDown(){
//		driver.quit();
//	}
}
