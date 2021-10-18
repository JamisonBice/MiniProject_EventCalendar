package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EventItem;
import model.EventSort;
import model.ListDetails;

/**
 * Servlet implementation class CreateNewListServlet
 */
@WebServlet("/createNewListServlet")
public class CreateNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateNewListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		EventItemHelper lih = new EventItemHelper();
		String listName = request.getParameter("listName");
		String eventSortName = request.getParameter("eventSortName");

		String[] selectedItems = request.getParameterValues("allItemsToAdd");
		List<EventItem> selectedItemsInList = new ArrayList<EventItem>();

		if (selectedItems != null && selectedItems.length > 0) {
			for (int i = 0; i < selectedItems.length; i++) {
				EventItem g = lih.searchForEventById(Integer.parseInt(selectedItems[i]));
				selectedItemsInList.add(g);
			}
		}

		EventSort eventSort = new EventSort(eventSortName);

		ListDetails ld = new ListDetails(listName, eventSort);

		ld.setListOfItems(selectedItemsInList);

		ListDetailsHelper ldh = new ListDetailsHelper();
		ldh.insertNewListDetails(ld);

		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
