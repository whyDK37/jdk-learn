package util.spi;

public class PushNotificationServiceProvider implements MessageServiceProvider {

	public void sendMessage(String message) {
		System.out.println("Sending Push Notification with Message = "+message);
	}

}