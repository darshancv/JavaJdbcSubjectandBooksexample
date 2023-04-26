package subjectandbooksjdbc.service;

import java.util.List;

import subjectandbooksjdbc.dao.SubjectAndBooksDao;
import subjectandbooksjdbc.dao.SubjectAndBooksDaoImpl;
import subjectandbooksjdbc.entity.Book;
import subjectandbooksjdbc.entity.Subject;
import subjectandbooksjdbc.exception.SubjectAndBooksServiceException;

public class SubjectAndBookServiceImpl implements SubjectAndBooksService {
	static SubjectAndBooksDao dao=new SubjectAndBooksDaoImpl();
	
	@Override
	public String addSubject(Subject subject)  throws SubjectAndBooksServiceException {
		// TODO Auto-generated method stub
		try
		{
			
			return dao.insertSubject(subject);
		}
		catch(Exception e)
		{
			throw new SubjectAndBooksServiceException(e.getMessage(),e);
			
		}
	}

	@Override
	public String addBooks(List<Book> books) throws SubjectAndBooksServiceException {
		try
		{
			
			return dao.insertBooks(books);
		}
		catch(Exception e)
		{
			throw new SubjectAndBooksServiceException(e.getMessage(),e);
			
		}
	}

	@Override
	public float priceWithDiscount(int bookId, float discount) throws SubjectAndBooksServiceException {
		try
		{
			
			return dao.priceWithDiscount(bookId,discount);
		}
		catch(Exception e)
		{
			throw new SubjectAndBooksServiceException(e.getMessage(),e);
			
		}
	}

}
