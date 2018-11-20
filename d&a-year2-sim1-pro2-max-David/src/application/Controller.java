package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
	
	//FIELDS FOR ADDING A BOOK
	@FXML
	private TextField textTitle;
	@FXML
	private TextField textAuthor;
	@FXML
	private TextField textYear;
	@FXML
	private TextField textPages;
	@FXML
	private TextField textGenre;
	@FXML
	private TextArea textPlot;
	
	//FIELDS FOR ADDING A CHARACTER TO LIST
	@FXML
	private TextField textName;
	@FXML
	private TextField textGender;
	@FXML
	private TextArea textDescription;

	@FXML
	void addBookOnClick(ActionEvent event) {

	}

	@FXML
	void addCharOnClick(ActionEvent event) {

	}

}



