package by.htp.mailru.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {
	private final String BASE_URL = "https://mail.ru/";

	private static final String INPUT_LOGIN_ID = "mailbox:login";
	private static final String INPUT_PASSWORD_ELEMENT_ID = "mailbox:password";
	private static final String CHECKBOX_SAVE_DATA_ELEMENT_ID = "mailbox:saveauth";
	private static final String BUTTON_SUBMIT_ELEMENT_XPATH = "//input[@class='o-control']";

	@FindBy(id = INPUT_LOGIN_ID)
	private WebElement inputLogin;

	@FindBy(id = INPUT_PASSWORD_ELEMENT_ID)
	private WebElement inputPassword;

	@FindBy(id = CHECKBOX_SAVE_DATA_ELEMENT_ID)
	private WebElement CheckboxSaveData;

	@FindBy(xpath = BUTTON_SUBMIT_ELEMENT_XPATH)
	private WebElement buttonSubmit;

	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
	}

	public void login(String username, String password) {
		inputLogin.sendKeys(username);
		inputPassword.sendKeys(password);
		CheckboxSaveData.click();
		buttonSubmit.click();
	}

}
