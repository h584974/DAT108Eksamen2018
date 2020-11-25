package logginn;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/logginn", name="logginn")
public class Logginn extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private final LogginnController controller = new LogginnController();
	private String korrektPin;
	
	public void init() {
		korrektPin = getServletConfig().getInitParameter("korrektPin");
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String feilmelding = (String)request.getSession().getAttribute("feilmelding");
		String innlogget = (String)request.getSession().getAttribute("innlogget");
		
		if(innlogget != null && innlogget.equalsIgnoreCase("true")) {
			response.sendRedirect("quiz");
		}
		else {
			request.getSession().invalidate();
			request.setAttribute("feilmelding", feilmelding);
			request.getRequestDispatcher("WEB-INF/logginn.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String pinkode = request.getParameter("pinkode");
		if(controller.validerPinkode(pinkode, korrektPin)) {
			request.getSession().setAttribute("innlogget", "true");
			response.sendRedirect("quiz");
		}
		else {
			request.getSession().setAttribute("innlogget", "false");
			request.getSession().setAttribute("feilmelding", "Feil pinkode oppgitt");
			response.sendRedirect("logginn");
		}
	}

}
