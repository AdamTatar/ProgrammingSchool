import java.sql.SQLException;
import java.util.List;

public interface StudentDao {


	Student insertStudent(Student student);
	Student updateStudent(Student student);
	boolean deleteStudent(Student student);

	List<Student> getAllStudents() throws SQLException;
	Student getStudentById(Integer studentId);
	
}
