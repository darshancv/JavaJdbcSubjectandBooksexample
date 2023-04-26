package subjectandbooksjdbc.client;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import subjectandbooksjdbc.entity.Book;
import subjectandbooksjdbc.entity.Subject;
import subjectandbooksjdbc.exception.SubjectAndBooksAppException;
import subjectandbooksjdbc.exception.SubjectAndBooksServiceException;
import subjectandbooksjdbc.service.SubjectAndBookServiceImpl;
import subjectandbooksjdbc.service.SubjectAndBooksService;

public class SubjectAndBooksApp {
	public static SubjectAndBooksService subjectAndBookService = new SubjectAndBookServiceImpl();

	public static void main(String[] args) throws SubjectAndBooksAppException {
		Scanner sc = new Scanner(System.in);
		try {
			boolean isContinue = true;
			do {
				int option = displayMenu();
				switch (option) {
				case 1:
					String message = addSubject();
					System.out.println(message);
					break;
				case 2:
					String result = addBooks();
					System.out.println(result);
					break;
				case 3:
					break;
				case 5:
					System.out.println("Enter the book id");
					int bookId = sc.nextInt();
					System.out.println("Enter the discount in percentage:");
					float discount = sc.nextFloat();
					float priceAfterDiscount = subjectAndBookService.priceWithDiscount(bookId, discount);
					System.out.println("Price of the book after Discount:" + priceAfterDiscount + "\n");

					break;
				case 6:
					System.out.println("bye, Thank You");
					isContinue = false;
					break;
				default:
					System.out.println("invalid:");
				}
			} while (isContinue);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static String addBooks() throws SQLException {
		Scanner sc = new Scanner(System.in);
		String result = "";
		System.out.println("Enter the number of books:");
		int count = sc.nextInt();
		List<Book> books = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			System.out.println("Enter the SubjectId:");
			int subjectId = sc.nextInt();
			System.out.println("enter book id:");
			int bookId = sc.nextInt();
			System.out.println("enter book name:");
			sc.nextLine();
			String bookName = sc.nextLine();
			System.out.println("enter book price:");
			long price = sc.nextLong();
			Book book = new Book(bookId, bookName, price, subjectId);
			books.add(book);
		}
		try {
			result = subjectAndBookService.addBooks(books);

		} catch (SubjectAndBooksServiceException e) {
			e.printStackTrace();
		}
		return result;

	}

	private static int displayMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the choice:");
		System.out.println("1. Add Subjects");
		System.out.println("2. Add Books for a particular subject");
		System.out.println("3. Display all books by subject name");
		System.out.println("4. Display subjects by book name");
		System.out.println("5. calculate discount to the given book id");
		System.out.println("6. Exit");

		int option = sc.nextInt();

		return option;

	}

	private static String addSubject() throws SQLException {
		Scanner sc = new Scanner(System.in);
		String message = "";
		System.out.println("Enter the subject details:");
		System.out.println("Enter the id of the subject:");
		int subId = sc.nextInt();
		System.out.println("enter the name of the subject:");
		sc.nextLine();
		String subName = sc.nextLine();
		Subject subject = new Subject(subId, subName);
		try {
			message = subjectAndBookService.addSubject(subject);
		} catch (SubjectAndBooksServiceException e) {
			e.printStackTrace();
		}

		return message;
	}

}
