import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import controller.EventItemHelper;
import model.EventItem;

/**
 * @author Nick - ntambroson CIS175 - Fall 2021 Oct 14, 2021
 */

public class StartProgram {

	static Scanner in = new Scanner(System.in);
	static EventItemHelper eih = new EventItemHelper();
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/d/yyyy");

	private static void addAnItem() {
		// TODO Auto-generated method stub
		System.out.print("Enter the event date(mm/dd/yyyy): ");
		String date = in.nextLine();
		LocalDate eventDate = LocalDate.parse(date, formatter);
		System.out.print("Enter an event type: ");
		String eventType = in.nextLine();
		System.out.print("Enter the event name: ");
		String eventName = in.nextLine();

		EventItem toAdd = new EventItem(eventType, eventName, eventDate);
		eih.insertItem(toAdd);

	}

	private static void deleteAnItem() {
		// TODO Auto-generated method stub
		System.out.print("Enter the date(mm/dd/yyy) of event to delete: ");
		String date = in.nextLine();
		LocalDate eventDate = LocalDate.parse(date, formatter);
		System.out.print("Enter the event type to delete: ");
		String eventType = in.nextLine();
		System.out.print("Enter the event name to delete: ");
		String eventName = in.nextLine();

		EventItem toDelete = new EventItem(eventType, eventName, eventDate);
		eih.deleteItem(toDelete);

	}

	private static void editAnItem() {
		// TODO Auto-generated method stub
		System.out.println("How would you like to search for an event? ");
		System.out.println("1 : Search by event type");
		System.out.println("2 : Search by event name");
		System.out.println("3 : Search by event date");
		int searchBy = in.nextInt();
		in.nextLine();
		List<EventItem> foundItems;
		if (searchBy == 1) {
			System.out.print("Enter the event type: ");
			String eventType = in.nextLine();
			foundItems = eih.searchForEventByType(eventType);
		} else if (searchBy == 2) {
			System.out.print("Enter the event name: ");
			String eventName = in.nextLine();
			foundItems = eih.searchForEventByName(eventName);

		} else {
			System.out.print("Enter the event date: ");
			String date = in.nextLine();
			LocalDate eventDate = LocalDate.parse(date, formatter);
			foundItems = eih.searchForEventByDate(eventDate);

		}

		if (!foundItems.isEmpty()) {
			System.out.println("Found Results.");
			for (EventItem e : foundItems) {
				System.out.println(e.getId() + " : " + e.toString());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			EventItem toEdit = eih.searchForEventById(idToEdit);
			System.out.println("Retrieved " + toEdit.getEventName() + " from event type " + toEdit.getEventType()
					+ " date: " + toEdit.getEventDate());
			System.out.println("1 : Update event type");
			System.out.println("2 : Update event name");
			System.out.println("3 : Update event date");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New event type: ");
				String newEventType = in.nextLine();
				toEdit.setEventType(newEventType);
			} else if (update == 2) {
				System.out.print("New event name: ");
				String newEventName = in.nextLine();
				toEdit.setEventName(newEventName);
			} else if (update == 3) {
				System.out.print("New event date: ");
				String date = in.nextLine();
				LocalDate newEventDate = LocalDate.parse(date, formatter);
				toEdit.setEventDate(newEventDate);
			}

			eih.updateEvent(toEdit);

		} else {
			System.out.println("---- No results found");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();

	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Welcome to our event list! ---");
		while (goAgain) {
			System.out.println("*  Select an option:");
			System.out.println("*  1 -- Add an event");
			System.out.println("*  2 -- Edit an event");
			System.out.println("*  3 -- Delete an event");
			System.out.println("*  4 -- View the event list");
			System.out.println("*  5 -- Exit the program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addAnItem();
			} else if (selection == 2) {
				editAnItem();
			} else if (selection == 3) {
				deleteAnItem();
			} else if (selection == 4) {
				viewTheList();
			} else {
				eih.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}

		}

	}

	private static void viewTheList() {
		// TODO Auto-generated method stub
		List<EventItem> allItems = eih.showAllItems();
		for (EventItem singleItem : allItems) {
			System.out.println(singleItem.returnEventDetails());
		}

	}

}