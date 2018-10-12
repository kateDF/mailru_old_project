package by.htp.mailru;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import by.htp.mailru.entity.Email;
import by.htp.mailru.page.ConfirmationPage;
import by.htp.mailru.page.CreateEmailPage;
import by.htp.mailru.page.EmailMainPage;
import by.htp.mailru.page.SentEmailPage;
import by.htp.mailru.steps.Steps;

public class SendEmailTest {

	private static final String USERNAME = "autesttest";
	private static final String EMAIL_DOMAIN = "@mail.ru";
	private static final String PASSWORD = "test12345";
	private static final String EMAIL_RECEPIENT = "vi_no@ya.ru";
	private static final String EMAIL_SUBJECT = "Auto message task";
	private static final String EMAIL_MESSAGE = "Auto generate message on mail.ru with Selenium WebDriver";
	private static final boolean DELIVERY_NOTIFICATION = true;
	private static final String CONFIRMATION_MESSAGE = "Ваше письмо отправлено";

	private Steps steps;

	@BeforeClass
	public void setUp() {
		steps = new Steps();
		steps.initBrowser();
		EmailMainPage emailMainPage = steps.loginMailRu(USERNAME, PASSWORD);
	}

	@Test(description = "send email")
	public void oneCanSendEmail() throws InterruptedException {

		Email emailMessage = new Email(EMAIL_RECEPIENT, EMAIL_SUBJECT, EMAIL_MESSAGE, DELIVERY_NOTIFICATION);

		CreateEmailPage createEmailPage = steps.navigateToCreateEmailForm();
		ConfirmationPage confirmationPage = steps.createMessage(emailMessage);
		System.out.println(emailMessage.getTimeOfSending());

		Assert.assertTrue(confirmationPage.getConfirmationToSendEmail().contains(CONFIRMATION_MESSAGE));
		Assert.assertEquals(confirmationPage.getConfirmationRecepient(), EMAIL_RECEPIENT);

		SentEmailPage sentEmailPage = steps.navigateToSentEmailPage();
		Assert.assertTrue(sentEmailPage.hasOutboxMessage(emailMessage));
	}

	@AfterClass
	public void stopBrowser() throws InterruptedException {
		steps.closeDriver();
	}

}
