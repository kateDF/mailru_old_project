package by.htp.mailru;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import by.htp.mailru.entity.Email;
import by.htp.mailru.page.CreateEmailPage;
import by.htp.mailru.page.EmailMainPage;
import by.htp.mailru.steps.Steps;

public class SendEmailWithoutRecepientEmailTest {

	private static final String USERNAME = "autesttest";
	private static final String EMAIL_DOMAIN = "@mail.ru";
	private static final String PASSWORD = "test12345";
	private static final String EMAIL_RECEPIENT = "";
	private static final String EMAIL_SUBJECT = "Auto message task2";
	private static final String EMAIL_MESSAGE = "Auto generate message on mail.ru with Selenium WebDriver";
	private static final boolean DELIVERY_NOTIFICATION = true;

	private Steps steps;

	@BeforeClass
	public void setUp() {
		steps = new Steps();
		steps.initBrowser();
		EmailMainPage emailMainPage = steps.loginMailRu(USERNAME, PASSWORD);
	}

	@Test(description = "send email")
	public void twoCanSendEmail() throws InterruptedException {

		Email emailMessage = new Email(EMAIL_RECEPIENT, EMAIL_SUBJECT, EMAIL_MESSAGE, DELIVERY_NOTIFICATION);

		CreateEmailPage createEmailPage = steps.navigateToCreateEmailForm();
		Assert.assertTrue(steps.createMessageWithoutRecepientEmail(emailMessage));

	}

	@AfterClass
	public void stopBrowser() throws InterruptedException {
		steps.closeDriver();
	}

}
