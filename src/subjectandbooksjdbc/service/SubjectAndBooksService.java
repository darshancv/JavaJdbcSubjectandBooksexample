package subjectandbooksjdbc.service;

import java.util.List;

import subjectandbooksjdbc.entity.Book;
import subjectandbooksjdbc.entity.Subject;
import subjectandbooksjdbc.exception.SubjectAndBooksServiceException;

public interface SubjectAndBooksService {

	public String addSubject(Subject subject) throws SubjectAndBooksServiceException;

	public String addBooks(List<Book> books) throws SubjectAndBooksServiceException;

	public float priceWithDiscount(int bookId, float discount)throws SubjectAndBooksServiceException ;

}
