package subjectandbooksjdbc.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import subjectandbooksjdbc.entity.Book;
import subjectandbooksjdbc.entity.Subject;
import subjectandbooksjdbc.exception.SubjectAndBooksDaoException;
import subjectandbooksjdbc.utility.SubjectAndBooksUtility;

public class SubjectAndBooksDaoImpl implements SubjectAndBooksDao {

	@Override
	public String insertSubject(Subject subject) throws SubjectAndBooksDaoException, SQLException {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		connection = SubjectAndBooksUtility.getConnection();
		if (connection != null) {
			System.out.println("Connectted");
		}
		String result = "";
		String query = "insert into subjects values(?,?)";
		try {
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, subject.getSubjectId());
			pstmt.setString(2, subject.getName());
			int insertion = pstmt.executeUpdate();
			if (insertion > 0) {
				result = "Insertion done";

			}

		} catch (SQLException e) {
			throw new SubjectAndBooksDaoException("sql exception");
		} finally {
			SubjectAndBooksUtility.closeDB(connection);
		}
		return result;

	}

	@Override
	public String insertBooks(List<Book> books) throws SubjectAndBooksDaoException, SQLException {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		connection = SubjectAndBooksUtility.getConnection();
		if (connection != null) {
			System.out.println("Connectted");
		}
		String result = "";
		String query = "insert into books values(?,?,?,?)";
		try {
			PreparedStatement pstmt = connection.prepareStatement(query);
			int i = 0;
			for (Book book : books) {
				pstmt.setInt(1, book.getBookId());
				pstmt.setString(2, book.getBookName());
				pstmt.setLong(3, book.getPrice());
				pstmt.setInt(4, book.getSubjectId());
				pstmt.executeUpdate();
				i++;
			}
			if (i == books.size()) {
				result = "Inserted";
			}

		} catch (SQLException e) {
			throw new SubjectAndBooksDaoException("sql exception");
		} finally {
			SubjectAndBooksUtility.closeDB(connection);
		}
		return result;

	}

	@Override
	public float priceWithDiscount(int bookId, float discount) throws SubjectAndBooksDaoException, SQLException {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		connection = SubjectAndBooksUtility.getConnection();
		if (connection != null) {
			System.out.println("Connectted");
		}
		float totalPrice = 0;
		String name = "";
		long price;
		try {
			String query = "{CALL calculateDiscount(?,?,?,?,?)}";
			CallableStatement s = connection.prepareCall(query);
			s.setInt(1, bookId);
			s.setFloat(2, discount);

			s.registerOutParameter(3, Types.VARCHAR);
			s.registerOutParameter(4, Types.VARCHAR);
			s.registerOutParameter(5, Types.VARCHAR);
			s.executeUpdate();
			totalPrice = s.getFloat(3);
			name = s.getString(4);
			price = s.getLong(5);
			System.out.println("Book Name: " + name);
			System.out.println("Book Price Without Discount: " + price);
		} catch (SQLException e) {
			throw new SubjectAndBooksDaoException("sql exception");
		} finally {
			SubjectAndBooksUtility.closeDB(connection);
		}
		return totalPrice;

	}

}
