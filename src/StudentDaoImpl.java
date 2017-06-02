
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
// wyświetlać informację ile jest w bazie studentów, ile grup i ile rozwiązań

public class StudentDaoImpl implements StudentDao {
	
    private static final String INSERT_STUDENT_QUERY = "INSERT INTO student(studentName, studentSurname, studentEmail, studentLogin) VALUES(?, ?, ?, ?);";
    private static final String UPDATE_STUDENT_QUERY = "UPDATE student SET studentName = ?, studentSurname = ?, studentEmail = ?, studentLogin = ? WHERE studentId = ?;";
    private static final String DELETE_STUDENT_QUERY = "DELETE FROM student WHERE studentId = ?;";
    private static final String GET_ALL_STUDENTS_QUERY = "SELECT * FROM student ORDER BY studentId DESC LIMIT 8;";
    private static final String GET_STUDENT_BY_ID_QUERY = "SELECT * FROM student WHERE studentId = ?;";
	
	
	public static Connection createConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/coderslab?serverTimezone=UTC&useSSL=false&useUnicode=true&characterEncoding=UTF-8", "root", "coderslab");
	}
	
	
	@Override
	public Student insertStudent(Student student) {

		try (Connection connection = createConnection();
				PreparedStatement insertStatement = connection.prepareStatement(INSERT_STUDENT_QUERY,
						PreparedStatement.RETURN_GENERATED_KEYS)) {
			insertStatement.setString(1, student.getStudentName());
			insertStatement.setString(2, student.getStudentSurname());
			insertStatement.setString(3, student.getStudentEmail());
			insertStatement.setString(4, student.getStudentLogin());
			Integer result = insertStatement.executeUpdate();
			if (result != 1) {
				throw new RuntimeException("Dodanie studenta nie powiodło się! " + result);
			}
			try (ResultSet generatedKeys = insertStatement.getGeneratedKeys()) {
				if (generatedKeys.first()) {
					return getStudentById(generatedKeys.getInt(1));
				} else {
					throw new RuntimeException("Generated key was not found");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	@Override
	public Student updateStudent(Student student) {
		try (Connection connection = createConnection();
				PreparedStatement updateStatement = connection.prepareStatement(UPDATE_STUDENT_QUERY)) {
			updateStatement.setString(1, student.getStudentName());
			updateStatement.setString(2, student.getStudentSurname());
			updateStatement.setString(3, student.getStudentEmail());
			updateStatement.setString(4, student.getStudentLogin());
			updateStatement.setInt(5, student.getStudentId());
			if (updateStatement.executeUpdate() != 1) {
				throw new RuntimeException("Zmiana danych studenta nie powiodła się! ");
			}
			return getStudentById(student.getStudentId());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteStudent(Student student) {

		try (Connection connection = createConnection();
				PreparedStatement deleteStatement = connection.prepareStatement(DELETE_STUDENT_QUERY)) {
			deleteStatement.setInt(1, student.getStudentId());
			Integer result = deleteStatement.executeUpdate();
			if (result != 1) {
				throw new RuntimeException("Usunięcie studenta nie powiodło się! " + result);
			}
			else{
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Student> getAllStudents() throws SQLException {

		List<Student> result = new ArrayList<>();
		try (Connection connection = createConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_STUDENTS_QUERY);
				ResultSet resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				Integer studentId = resultSet.getInt("studentId");
				String studentName = resultSet.getString("studentName");
				String studentSurname = resultSet.getString("studentSurname");
				String studentEmail = resultSet.getString("studentEmail");
				String studentLogin = resultSet.getString("studentLogin");
				result.add(new Student(studentId, studentName, studentSurname, studentEmail, studentLogin));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public Student getStudentById(Integer studentId) {
		try (Connection connection = createConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GET_STUDENT_BY_ID_QUERY)) {

			preparedStatement.setInt(1, studentId);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				studentId = resultSet.getInt("studentId");
				String studentName = resultSet.getString("studentName");
				String studentSurname = resultSet.getString("studentSurname");
				String studentEmail = resultSet.getString("studentEmail");
				String studentLogin = resultSet.getString("studentLogin");
				return (new Student(studentId, studentName, studentSurname, studentEmail, studentLogin));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}