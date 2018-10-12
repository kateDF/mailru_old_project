package by.htp.mailru;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import by.htp.mailru.steps.Steps;

public class LoginTest {
	private static final String USERNAME = "autesttest";
	private static final String EMAIL_DOMAIN = "@mail.ru";
	private static final String PASSWORD = "test12345";

	private Steps steps;

	@BeforeClass
	public void setUp() {
		steps = new Steps();
		steps.initBrowser();
	}

	@Test(description = "login to mail.ru")
	public void oneCanLoginMailRu() throws InterruptedException {
		steps.loginMailRu(USERNAME, PASSWORD);
		Assert.assertTrue(steps.getLoggetUserEmail(USERNAME + EMAIL_DOMAIN));
	}

	@AfterClass
	public void stopBrowser() throws InterruptedException {
		steps.closeDriver();
	}
}
