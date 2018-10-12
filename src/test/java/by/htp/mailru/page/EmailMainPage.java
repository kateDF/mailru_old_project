package by.htp.mailru.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmailMainPage extends AbstractPage {

	private static final String BASE_URL = "https://e.mail.ru/messages/inbox/?back=1";

	private static final String BUTTON_CREATE_EMAIL_XPATH = "//*[@id='b-toolbar__left']/div/div/div[2]/div/a";
	private static final String USER_EMAIL_ACTUAL_ID = "PH_user-email";

	private WebElement buttonCreateEmail;
	private WebElement userEmailActual;

	public EmailMainPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void openPage() {
		// this if prevent reopening the same page
		if (!BASE_URL.equals(driver.getCurrentUrl())) {
			driver.navigate().to(BASE_URL);
		}
	}

	public void openCreateEmailPage() {
		buttonCreateEmail = driver.findElement(By.xpath(BUTTON_CREATE_EMAIL_XPATH));
		buttonCreateEmail.click();
	}

	public String getLoggetUserEmail() {
		userEmailActual = driver.findElement(By.id(USER_EMAIL_ACTUAL_ID));
		System.out.println(userEmailActual.getText());
		return userEmailActual.getText();
	}

}
