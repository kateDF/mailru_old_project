package by.htp.mailru.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import by.htp.mailru.entity.Email;

public class CreateEmailPage extends AbstractPage {

	private static final String BASE_URL = "https://e.mail.ru/compose/";

	private static final String TEXT_AREA_RECEPIENT_XPATH = "//textarea[@tabindex='4']";
	private static final String TEXT_AREA_SUBJECT_XPATH = "//input[@name='Subject']";
	private static final String WIDGET_DELIVERY_NOTIFICATION_XPATH = "//div[@data-blockid='receipt']";
	private static final String TIME_OF_SENDING = "tinymce";
	private static final String TEXT_AREA_MESSAGE_ID = "tinymce";
	private static final String BUTTON_SEND_MESSAGE_XPATH = "//div[@class='b-toolbar']/div[2]/div/div";

	@FindBy(xpath = TEXT_AREA_RECEPIENT_XPATH)
	private WebElement textAreaRecepient;

	@FindBy(xpath = TEXT_AREA_SUBJECT_XPATH)
	private WebElement textAreaSubject;

	@FindBy(xpath = WIDGET_DELIVERY_NOTIFICATION_XPATH)
	private WebElement widgetDeliveryNotification;

	private WebElement buttonSendMessage = null;

	private WebElement containerForFrameTextAreaMessage = null;
	private WebElement textAreaMessage = null;

	public CreateEmailPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {
		// this if prevent reopening the same page
		if (!driver.getCurrentUrl().startsWith(BASE_URL)) {
			driver.navigate().to(BASE_URL);
		}
	}

	public void createEmail(Email emailMessage) {

		textAreaRecepient.sendKeys(emailMessage.getRecepientEmail());
		textAreaSubject.sendKeys(emailMessage.getSubject());
		if (emailMessage.isDeliveryNotification()) {
			widgetDeliveryNotification.click();
		}

		containerForFrameTextAreaMessage = driver
				.findElement(By.xpath("//table[@class='mceLayout']/tbody/tr/td/iframe"));
		driver.switchTo().frame(containerForFrameTextAreaMessage);

		textAreaMessage = driver.findElement(By.id(TEXT_AREA_MESSAGE_ID));
		textAreaMessage.clear();
		textAreaMessage.sendKeys(emailMessage.getTextMessage());

		driver.switchTo().defaultContent();

		buttonSendMessage = driver.findElement(By.xpath(BUTTON_SEND_MESSAGE_XPATH));
		buttonSendMessage.click();
	}

}
