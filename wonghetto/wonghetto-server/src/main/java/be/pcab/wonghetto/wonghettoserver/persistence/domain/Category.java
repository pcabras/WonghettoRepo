package be.pcab.wonghetto.wonghettoserver.persistence.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * The class representing the Category DB-table. 
 * 
 * @author Paolo Cabras
 *
 */

@Entity
public class Category implements Serializable {

	private static final long serialVersionUID = 2577413985926266677L;

	@Id
	private long categoryId;
	
	@Column
	private String name;
	
	@ManyToOne
	private User user;
	
	@OneToMany(mappedBy="category")
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
	
	
}
