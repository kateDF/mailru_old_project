package by.htp.mailru.steps;

import java.time.LocalTime;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import by.htp.mailru.driver.DriverSingleton;
import by.htp.mailru.entity.Email;
import by.htp.mailru.page.ConfirmationPage;
import by.htp.mailru.page.CreateEmailPage;
import by.htp.mailru.page.EmailMainPage;
import by.htp.mailru.page.MainPage;
import by.htp.mailru.page.SentEmailPage;

public class Steps {

	private WebDriver driver;

	public void initBrowser() {
		driver = DriverSingleton.getDriver();
	}

	public void closeDriver() {
		DriverSingleton.closeDriver();
	}

	public EmailMainPage loginMailRu(String username, String password) {
		MainPage mainPage = new MainPage(driver);
		mainPage.openPage();
		mainPage.login(username, password);
		return new EmailMainPage(driver);
	}

	public CreateEmailPage navigateToCreateEmailForm() throws InterruptedException {
		EmailMainPage emailMainPage = new EmailMainPage(driver);
		Thread.sleep(7000);
		emailMainPage.openCreateEmailPage();

		CreateEmailPage createEmailPage = new CreateEmailPage(driver);
		return createEmailPage;
	}

	public ConfirmationPage createMessage(Email emailMessage) {
		CreateEmailPage createEmailPage = new CreateEmailPage(driver);
		createEmailPage.openPage();
		createEmailPage.createEmail(emailMessage);

		LocalTime time = LocalTime.now();
		emailMessage.setTimeOfSending(time.toString().substring(0, 5));

		ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		return confirmationPage;
	}

	public boolean createMessageWithoutRecepientEmail(Email emailMessage) {
		CreateEmailPage createEmailPage = new CreateEmailPage(driver);
		createEmailPage.openPage();
		createEmailPage.createEmail(emailMessage);

		Alert alert = driver.switchTo().alert();
		if (alert != null) {
			return true;
		}
		return false;
	}

	public SentEmailPage navigateToSentEmailPage() throws InterruptedException {
		ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		Thread.sleep(3000);
		confirmationPage.navigateToSentEmailsPage();

		SentEmailPage sentEmailPage = new SentEmailPage(driver);
		return sentEmailPage;
	}

	public boolean getLoggetUserEmail(String userEmail) {
		EmailMainPage emailMainPage = new EmailMainPage(driver);
		String actualUserEmail = emailMainPage.getLoggetUserEmail();
		return userEmail.equals(actualUserEmail);
	}

	public boolean getConfirmation(String confirmationMessage) {
		ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		String actualMessage = confirmationPage.getConfirmationToSendEmail();
		return actualMessage.contains(confirmationMessage);
	}

	public boolean getConfirmationRecepient(String confirmationRecepient) {
		ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		String actualRecepient = confirmationPage.getConfirmationRecepient();
		return confirmationRecepient.equals(actualRecepient);
	}

}
