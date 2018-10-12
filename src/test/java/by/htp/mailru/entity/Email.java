package by.htp.mailru.entity;

public class Email {

	private String recepientEmail;
	private String subject;
	private String textMessage;
	private String timeOfSending;
	private boolean deliveryNotification;

	public Email() {

	}

	public Email(String recepientEmail, String subject, String textMessage, boolean deliveryNotification) {
		this.recepientEmail = recepientEmail;
		this.subject = subject;
		this.textMessage = textMessage;
		this.deliveryNotification = deliveryNotification;
	}

	public Email(String recepientEmail, String subject, String textMessage, String timeOfSending,
			boolean deliveryNotification) {
		super();
		this.recepientEmail = recepientEmail;
		this.subject = subject;
		this.textMessage = textMessage;
		this.timeOfSending = timeOfSending;
		this.deliveryNotification = deliveryNotification;
	}

	public String getRecepientEmail() {
		return recepientEmail;
	}

	public void setRecepientEmail(String recepientEmail) {
		this.recepientEmail = recepientEmail;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTextMessage() {
		return textMessage;
	}

	public void setTextMessage(String textMessage) {
		this.textMessage = textMessage;
	}

	public String getTimeOfSending() {
		return timeOfSending;
	}

	public void setTimeOfSending(String timeOfSending) {
		this.timeOfSending = timeOfSending;
	}

	public boolean isDeliveryNotification() {
		return deliveryNotification;
	}

	public void setDeliveryNotification(boolean deliveryNotification) {
		this.deliveryNotification = deliveryNotification;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (deliveryNotification ? 1231 : 1237);
		result = prime * result + ((recepientEmail == null) ? 0 : recepientEmail.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		result = prime * result + ((textMessage == null) ? 0 : textMessage.hashCode());
		result = prime * result + ((timeOfSending == null) ? 0 : timeOfSending.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Email other = (Email) obj;
		if (deliveryNotification != other.deliveryNotification)
			return false;
		if (recepientEmail == null) {
			if (other.recepientEmail != null)
				return false;
		} else if (!recepientEmail.equals(other.recepientEmail))
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		if (textMessage == null) {
			if (other.textMessage != null)
				return false;
		} else if (!textMessage.equals(other.textMessage))
			return false;
		if (timeOfSending == null) {
			if (other.timeOfSending != null)
				return false;
		} else if (!timeOfSending.equals(other.timeOfSending))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Email recepientEmail: " + recepientEmail + ", subject: " + subject + ". TextMessage: " + textMessage
				+ ". TimeOfSending: " + timeOfSending + ", deliveryNotification: " + deliveryNotification + "]";
	}

}
