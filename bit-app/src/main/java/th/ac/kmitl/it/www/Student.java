package th.ac.kmitl.it.www;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * The persistent class for the contact database table.
 * 
 */
@Entity(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "student_id", nullable = false)
    private String studentId;

    @Column(name = "password", nullable = false)
	private String password;

	public Student() {

	}
	public Integer getId() {
		return this.id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

	public String getStudentId() {
		return this.studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
    }
    
    public void printInfo(){
		System.out.println("Id:" + this.id);
		System.out.println("Student ID:" + this.studentId);
		System.out.println("Password:" + this.password);
    }
}