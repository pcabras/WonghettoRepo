package be.pcab.wonghetto.wonghettocore.model;

import org.apache.commons.io.FileUtils;

import javafx.beans.property.SimpleStringProperty;

public class CategoryElementModel {
	

	private SimpleStringProperty name;
	
	private SimpleStringProperty path;
	
	private SimpleStringProperty size;
	
	public CategoryElementModel() {
		
		name = new SimpleStringProperty();
		path = new SimpleStringProperty();
		size = new SimpleStringProperty();
	}

	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set(name);
	}

	public String getPath() {
		return path.get();
	}

	public void setPath(String path) {
		this.path.set(path);
	}

	public String getSize() {
		return size.get();
	}

	public void setSize(long size) {
		
		this.size.set(FileUtils.byteCountToDisplaySize(size));
	}
	
	
}
