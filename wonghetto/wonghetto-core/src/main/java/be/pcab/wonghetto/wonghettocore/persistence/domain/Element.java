package be.pcab.wonghetto.wonghettocore.persistence.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The class representing the Element DB-table.
 * 
 * @author Paolo Cabras
 *
 */

@Entity
@Table(name="Elements")
public class Element implements Serializable {

	private static final long serialVersionUID = -2489095605646326536L;

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long elementId;
	
	@Column
	private String name;
	
	@Column
	private String path;
	
	@Column
	private String size;
	
	@ManyToOne
	private Category category;
	
	public Element() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public long getElementId() {
		return elementId;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
