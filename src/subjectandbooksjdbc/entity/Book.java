package subjectandbooksjdbc.entity;

public class Book {
	private int bookId;
	private String bookName;
	private long price;
	private int subjectId;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(int bookId, String bookName, long price, int subjectId) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.price = price;
		this.subjectId = subjectId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

}
