import java.util.List;

import controller.EventSortHelper;
import model.EventSort;

/**
 * @author Nick - ntambroson CIS175 - Fall 2021 Oct 16, 2021
 */

public class EventSortTester {
	public static void main(String[] args) {
		EventSort dec = new EventSort("December");
		EventSort music = new EventSort("Music");
		EventSortHelper esh = new EventSortHelper();

		esh.insertEventSort(dec);
		esh.insertEventSort(music);

		List<EventSort> allEventSorts = esh.showAllEventSorts();
		for (EventSort a : allEventSorts) {
			System.out.println(a.toString());
		}

	}
}
