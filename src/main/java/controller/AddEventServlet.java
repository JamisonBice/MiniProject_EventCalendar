package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EventItem;

/**
 * Servlet implementation class AddEventServlet
 */
@WebServlet("/addEventServlet")
public class AddEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddEventServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String eventDateMonth = request.getParameter("eventDateMonth");
		String eventDateDay = request.getParameter("eventDateDay");
		String eventDateYear = request.getParameter("eventDateYear");
		String eventType = request.getParameter("eventType");
		String eventName = request.getParameter("eventName");

		LocalDate eventDate;
		try {
			eventDate = LocalDate.of(Integer.parseInt(eventDateYear), Integer.parseInt(eventDateMonth),
					Integer.parseInt(eventDateDay));
		} catch (NumberFormatException ex) {
			eventDate = LocalDate.now();
		}

		EventItem ei = new EventItem(eventType, eventName, eventDate);
		EventItemHelper dao = new EventItemHelper();
		dao.insertItem(ei);

		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
