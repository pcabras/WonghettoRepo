package be.pcab.wonghetto.wonghettocore.model;

import java.util.ArrayList;
import java.util.List;

public class CategoryModel {

	private List<CategoryElementModel> elementModels;
	
	private String name;

	public CategoryModel() {
		
		elementModels = new ArrayList<CategoryElementModel>();
		
	}
	
	public List<CategoryElementModel> getElementModels() {
		return elementModels;
	}

	public void setElementModels(List<CategoryElementModel> elementModels) {
		this.elementModels = elementModels;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
