package quiz;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/quiz", name = "quiz")
public class Quiz extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private final QuizController controller = new QuizController();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String innlogget = (String)request.getSession().getAttribute("innlogget");
		
		if(innlogget != null && innlogget.equals("true")) {
			request.getRequestDispatcher("WEB-INF/quiz.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("WEB-INF/logginn.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String tittel = request.getParameter("tittel");
		
		if(controller.validerTittel(tittel)) {
			String alternativerStr = getServletContext().getInitParameter("alternativer");
			List<String> alternativer = Arrays.asList(alternativerStr.split(","));
			request.getSession().setAttribute("alternativer", alternativer);
			request.getSession().setAttribute("tittel", tittel);
		}
		
		response.sendRedirect("quiz");
	}

}
