import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

	
	//dodać connection i robic metody
	
	
	
	@Override
	public Student insertStudent(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteStudent(Student student) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student getById(Integer studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
	
	
	

}



//	class MySqlUserDao implements StudentDao {
//	
//		private static final String FIND_ALL_USERS = "SELECT * FROM users";
//		private static final String INSERT_USER_QUERY = "INSERT INTO users (name, surname, email, password) VALUES (?, ?, ?, ?);";
//		private static final String UPDATE_USER_QUERY = "UPDATE users SET id = ?, name = ?, surname = ?, email = ?, password = ? where id = ?";
//		private static final String INSERT_SOLUTION_QUERY = "INSERT INTO solution (created, updated, descritpion, users_id) VALUES (?, ?, ?, ?);";
//		private String jdbcUrl;
//		private String password;
//		private String user;
//	
//		public MySqlUserDao(String jdbcUrl, String user, String password) {
//			super();
//			this.jdbcUrl = jdbcUrl;
//			this.password = password;
//			this.user = user;
//		}
//	
//		private Connection createConnection() throws SQLException {
//			return DriverManager.getConnection(jdbcUrl, user, password);
//		}
//	
//		@Override
//		public User insert(User user) {
//			try (Connection connection = createConnection();
//					PreparedStatement insertStatement = connection.prepareStatement(INSERT_USER_QUERY,
//							PreparedStatement.RETURN_GENERATED_KEYS)) {
//				insertStatement.setString(1, user.getName());
//				insertStatement.setString(2, user.getSurname());
//				insertStatement.setString(3, user.getEmail());
//				insertStatement.setString(4, user.getPassword());
//				int result = insertStatement.executeUpdate();
//				if (result != 1) {
//					throw new RuntimeException("Execute updated returned " + result);
//				}
//				try (ResultSet generatedKeys = insertStatement.getGeneratedKeys()) {
//					if (generatedKeys.first()) {
//						user.setId(generatedKeys.getInt(1));
//						return user;
//					} else {
//						throw new RuntimeException("Generated key was not found");
//					}
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//	
//			return null;
//		}
//	
//		@Override
//		public List<User> findAll() {
//	
//			List<User> list = new ArrayList<>();
//			try (Connection connection = createConnection();
//					PreparedStatement findStatement = connection.prepareStatement(FIND_ALL_USERS)) {
//				try (ResultSet resultSet = findStatement.executeQuery()) {
//					while (resultSet.next()) {
//						User user = new User();
//						user.setName(resultSet.getString(2));
//						user.setSurname(resultSet.getString(3));
//						user.setEmail(resultSet.getString(4));
//						user.setPassword(resultSet.getString(5));
//						list.add(user);
//	
//					}
//	
//				}
//	
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	
//			return list;
//		}
//	
//		public void updateUser(Integer id, String name, String surname, String email, String password) {
//	
//			try (Connection connection = createConnection();
//					PreparedStatement updateStatement = connection.prepareStatement(UPDATE_USER_QUERY)) {
//	
//				updateStatement.setInt(1, id);
//				updateStatement.setInt(6, id);
//				updateStatement.setString(2, name);
//				updateStatement.setString(3, surname);
//				updateStatement.setString(4, email);
//				updateStatement.setString(5, password);
//				updateStatement.executeUpdate();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	
//		}
//	
//		
//		//dla solution insert i find by id
//	//	create table solution (
//	//			id INT NOT NULL AUTO_INCREMENT,
//	//			created DATETIME,
//	//			updated DATETIME,
//	//			description TEXT,
//	//			users_id INT,
//	//			PRIMARY KEY (id),
//	//			FOREIGN KEY (users_id) REFERENCES users(id)
//	//			);
//	//	
//	//		private static final String INSERT_SOLUTION_QUERY = "INSERT INTO solution (created, updated, descritpion, users_id) VALUES (?, ?, ?, ?);";
//	
//		@Override
//		public Solution insertSolution(Solution solution) {
//			try (Connection connection = createConnection();
//					PreparedStatement insertStatement = connection.prepareStatement(INSERT_SOLUTION_QUERY,
//							PreparedStatement.RETURN_GENERATED_KEYS)) {
//				
//	//			Date.from(LocalDateTime.now().toInstant(ZoneOffset.ofHours(2)))
//				
//	//			new java.sql.Date()		//tu trzeba naprawić z datami,
//				// potem stworzyć stringa z updatem
//				
//	//			insertStatement.setDate(1, solution.getCreated());
//	//			insertStatement.setDate(2, solution.getUpdated());
//				insertStatement.setString(3, solution.getDescription());
//				insertStatement.setInt(4, solution.getUsers_id());
//				int result = insertStatement.executeUpdate();
//				if (result != 1) {
//					throw new RuntimeException("Execute solution update returned " + result);
//				}
//				try (ResultSet generatedKeys = insertStatement.getGeneratedKeys()) {
//					if (generatedKeys.first()) {
//						solution.setId(generatedKeys.getInt(1));
//						return solution;
//					} else {
//						throw new RuntimeException("Generated key was not found");
//					}
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//	
//			return null;
//		}
//	}
//		