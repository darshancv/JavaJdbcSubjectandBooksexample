package subjectandbooksjdbc.dao;

import java.sql.SQLException;
import java.util.List;

import subjectandbooksjdbc.entity.Book;
import subjectandbooksjdbc.entity.Subject;
import subjectandbooksjdbc.exception.SubjectAndBooksDaoException;

public interface SubjectAndBooksDao {

	public String insertSubject(Subject subject) throws SubjectAndBooksDaoException, SQLException;

	public String insertBooks(List<Book> books) throws SubjectAndBooksDaoException, SQLException;

	public float priceWithDiscount(int bookId, float discount) throws SubjectAndBooksDaoException, SQLException ;

}
