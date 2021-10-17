import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.ListDetailsHelper;
import model.ListDetails;
import model.EventItem;
import model.EventSort;

/**
 * @author Jamison Bice - jdbice
 * CIS175 - Fall 2021
 * Oct 16, 2021
 */

//Useful for table setups
public class ListDetailsTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EventSort testSort = new EventSort("Test1 ");
		ListDetailsHelper ldh = new ListDetailsHelper();
		EventItem test1 = new EventItem("Test Type", "Test name", LocalDate.now());
		EventItem test2 = new EventItem("Test type 2", " test name 2", LocalDate.now());
		List<EventItem> testEI = new ArrayList<EventItem>();
		testEI.add(test1);
		testEI.add(test2);
		ListDetails testList = new ListDetails("Test2",testSort);
		testList.setListOfItems(testEI);
		ldh.insertNewListDetails(testList);
		List<ListDetails> allLists = ldh.getLists();
		for (ListDetails a : allLists) {
			System.out.println(a.toString());
		}
	}

}
