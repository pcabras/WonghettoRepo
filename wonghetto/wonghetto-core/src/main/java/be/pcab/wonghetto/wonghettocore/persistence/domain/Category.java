package be.pcab.wonghetto.wonghettocore.persistence.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Type;

/**
 * The class representing the Category DB-table. 
 * 
 * @author Paolo Cabras
 *
 */

@Entity
@Table(name="Categories")
public class Category implements Serializable {

	private static final long serialVersionUID = 2577413985926266677L;

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long categoryId;
	
	@Column
	private String name;
	
	@ManyToOne
	private User user;
	
	@OneToMany(mappedBy="category")
	@Cascade(CascadeType.DELETE)
	private List<Element> elements;
	
	public Category() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
