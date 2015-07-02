package be.pcab.wonghetto.wonghettoserver.persistence.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Element implements Serializable {

	private static final long serialVersionUID = -2489095605646326536L;

	@Id
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
	
	
}
