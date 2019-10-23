package th.ac.kmitl.it.oot.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * The persistent class for the contact database table.
 * 
 */
@Entity(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
	private String password;

	public User() {

	}
	public User(Integer id, String username, String password) {
        this.id = id;
		this.username = username;
		this.password = password;
	}
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	public Integer getId() {
		return this.id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
    }
    
    public void printInfo(){
		System.out.println("Id:" + this.id);
		System.out.println("Username:" + this.username);
		System.out.println("Password:" + this.password);
    }
}