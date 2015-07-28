package be.pcab.wonghetto.wonghettoserver.persistence.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * The class representing the User DB-table. 
 * 
 * 
 * @author Paolo Cabras
 *
 */

@Entity
@Table(name="Users")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3874940128069324700L;
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long userId;
	
	@Column
	private String userName;
	
	@Column
	private String password;
	
	@OneToMany(mappedBy="user")
	private List<Category> categories;
	
	public User() {
		
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getUserId() {
		return userId;
	}
	
	

}
