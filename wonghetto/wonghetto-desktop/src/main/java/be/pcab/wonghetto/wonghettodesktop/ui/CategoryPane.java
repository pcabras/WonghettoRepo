package be.pcab.wonghetto.wonghettodesktop.ui;

import be.pcab.wonghetto.wonghettocore.model.CategoryElementModel;
import be.pcab.wonghetto.wonghettocore.model.CategoryModel;
import be.pcab.wonghetto.wonghettodesktop.event.EventHolder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


public class CategoryPane extends TitledPane {

	private VBox vBox;

	private CategoryModel categoryModel;

	private ObservableList<CategoryElementModel> elementModels;
	
	private TableView<CategoryElementModel> table;

	public CategoryPane(CategoryModel categoryModel) {

		this.categoryModel = categoryModel;

		elementModels = FXCollections.observableArrayList();

		setText(this.categoryModel.getName());

		buildPane();

	}

	private void buildPane() {

		// CREATE BUTTONS PANE

		Button addButton = new Button("add");
		addButton.setOnAction(EventHolder.getAddCategoryElementHandler());

		Button removeButton = new Button("remove");
		removeButton.setOnAction(EventHolder.getRemoveCategoryElementHandler());

		FlowPane flowPane = new FlowPane(Orientation.HORIZONTAL);
		flowPane.getChildren().add(addButton);
		flowPane.getChildren().add(removeButton);

		// CREATE TABLE PANE

		TableColumn<CategoryElementModel, String> fileNameColumn = new TableColumn<CategoryElementModel, String>(
				"File Name");
		fileNameColumn
				.setCellValueFactory(new PropertyValueFactory<CategoryElementModel, String>(
						"name"));

		TableColumn<CategoryElementModel, String> pathColumn = new TableColumn<CategoryElementModel, String>(
				"Path");
		pathColumn
				.setCellValueFactory(new PropertyValueFactory<CategoryElementModel, String>(
						"path"));

		TableColumn<CategoryElementModel, String> sizeColumn = new TableColumn<CategoryElementModel, String>(
				"Size");
		sizeColumn
				.setCellValueFactory(new PropertyValueFactory<CategoryElementModel, String>(
						"size"));

		/*TableView<CategoryElementModel>*/ table = new TableView<CategoryElementModel>(
				elementModels);

		table.setEditable(true);
		table.setItems(elementModels);

		fileNameColumn.prefWidthProperty().bind(
				table.widthProperty().divide(3));
		pathColumn.prefWidthProperty().bind(
				table.widthProperty().divide(3));
		sizeColumn.prefWidthProperty().bind(
				table.widthProperty().divide(3));
		
		table.getColumns().add(fileNameColumn);
		table.getColumns().add(pathColumn);
		table.getColumns().add(sizeColumn);

		Pane tablePane = new Pane();
		tablePane.getChildren().add(table);

		table.prefWidthProperty().bind(tablePane.widthProperty());

		vBox = new VBox();
		vBox.getChildren().add(flowPane);
		vBox.getChildren().add(tablePane);

		this.setContent(vBox);

	}

	public TableView<CategoryElementModel> getTable(){
		
		return table; 
	}
}
