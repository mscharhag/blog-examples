import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;


public class MessageFormatExample {
	
	private static ResourceBundle bundle;
	
	private static String resolveKeyToMessage(String key, Object... args) {
		String pattern = bundle.getString(key);
		return MessageFormat.format(pattern, args);
	}
	
	private static String getMessage(int numberOfComments) {
		String message = null;
		if (numberOfComments == 0) {
			message = resolveKeyToMessage("comments.no");
		} else if (numberOfComments == 1) {
			message = resolveKeyToMessage("comments.one");
		} else {
			message = resolveKeyToMessage("comments.multiple", numberOfComments);
		}
		return message;
	}
	
	
	private static String getMessageUsingChoice(int numberOfComments) {
		return resolveKeyToMessage("comments.choice", numberOfComments);
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		bundle = ResourceBundle.getBundle("messages", new Locale("en"));

		System.out.println("Manually:");
		System.out.println(getMessage(0));
		System.out.println(getMessage(1));
		System.out.println(getMessage(2));
		System.out.println(getMessage(10));
		
		System.out.println("\nChoice:");
		System.out.println(getMessageUsingChoice(0));
		System.out.println(getMessageUsingChoice(1));
		System.out.println(getMessageUsingChoice(2));
		System.out.println(getMessageUsingChoice(10));
	}
	
}
