package logginn;

public class LogginnController {
	
	public LogginnController() {}
	
	public boolean validerPinkode(String pinkode, String korrektPin) {
		return pinkode.equals(korrektPin);
	}
	
}
