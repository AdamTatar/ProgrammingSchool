import java.util.List;

public interface StudentDao {


	Student insertStudent(Student student);
	Student updateStudent(Student student);
	boolean deleteStudent(Student student);

	List<Student> getAllStudents();
	Student getById(Integer studentId);
	
}
