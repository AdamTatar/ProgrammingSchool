
public class Student {

	@Override
	public String toString() {
		return "Student o id = " + studentId + ", imię = " + studentName + ", nazwisko = " + studentSurname
				+ ", e-mail = " + studentEmail + ", GitHub login = " + studentLogin;
	}



	private Integer studentId;
	private String studentName ;
	private String studentSurname;
	private String studentEmail;
	private String studentLogin;	//login GitHub
	
	
	
	public Student(Integer studentId, String studentName, String studentSurname, String studentEmail,
			String studentLogin) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentSurname = studentSurname;
		this.studentEmail = studentEmail;
		this.studentLogin = studentLogin;
	}



	public Student(String studentName, String studentSurname, String studentEmail, String studentLogin) {
		super();
		this.studentName = studentName;
		this.studentSurname = studentSurname;
		this.studentEmail = studentEmail;
		this.studentLogin = studentLogin;
	}



	public Integer getStudentId() {
		return studentId;
	}



	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}



	public String getStudentName() {
		return studentName;
	}



	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}



	public String getStudentSurname() {
		return studentSurname;
	}



	public void setStudentSurname(String studentSurname) {
		this.studentSurname = studentSurname;
	}



	public String getStudentEmail() {
		return studentEmail;
	}



	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}



	public String getStudentLogin() {
		return studentLogin;
	}



	public void setStudentLogin(String studentLogin) {
		this.studentLogin = studentLogin;
	}

	
	
	
}


// bede mial jeszcze dodatkowa tabele z polaczeniem wiele - wiele student grupa.