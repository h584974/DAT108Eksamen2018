package quiz;

public class QuizController {
	
	public QuizController() {}
	
	public boolean validerTittel(String tittel) {
		return tittel != null && tittel.matches("^[a-zA-Z������ ,?-]{3,80}$");
	}
	
}