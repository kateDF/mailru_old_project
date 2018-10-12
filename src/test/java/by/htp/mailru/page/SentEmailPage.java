package by.htp.mailru.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import by.htp.mailru.entity.Email;

public class SentEmailPage extends AbstractPage {

	private static final String BASE_URL = "https://e.mail.ru/messages/sent/";
	private static final String MESSAGE_ELEMENTS_XPATH = "//*[@id='b-letters']/div/div[5]/div/div[@class='b-datalist__body']/div/div/a/div[@class='b-datalist__item__panel']";
	private static final String RECEPIENT_EMAIL__IN_ELEMENT_LETTER_XPATH = "div/div[@class='b-datalist__item__addr']";
	private static final String TIME_IN_ELEMENT_LETTER_XPATH = "div/span";
	private static final String SUBJECT_IN_ELEMENT_LETTER_XPATH = "div/div/div[@class='b-datalist__item__subj']";

	public SentEmailPage(WebDriver driver) {
		super(driver);
	}

	public boolean hasOutboxMessage(Email email) {
		List<WebElement> sentLetters = driver.findElements(By.xpath(MESSAGE_ELEMENTS_XPATH));
		for (WebElement letter : sentLetters) {
			WebElement recepient = letter.findElement(By.xpath(RECEPIENT_EMAIL__IN_ELEMENT_LETTER_XPATH));
			if (email.getRecepientEmail().equals(recepient.getText())) {
				WebElement time = letter.findElement(By.xpath(TIME_IN_ELEMENT_LETTER_XPATH));
				if (email.getTimeOfSending().equals(time.getText())) {
					WebElement subject = letter.findElement(By.xpath(SUBJECT_IN_ELEMENT_LETTER_XPATH));
					if (subject == null & email.getSubject() == null) {
						return true;
					}
					if (subject.getText().contains(email.getSubject())) {
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
	}

}
