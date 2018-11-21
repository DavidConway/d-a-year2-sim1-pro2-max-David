package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
	//MAIN LIST
	LinkedList<Book> books = new LinkedList<>();

	//FIELDS FOR ADD BOOKS
    @FXML
    private TextField textTitle;
    @FXML
    private TextField textAuthor;
    @FXML
    private TextField textPublisher;
    @FXML
    private TextField textYear;
    @FXML
    private TextField textLength;
    @FXML
    private TextArea textPlot;
    @FXML
    private TextField textGenre;
    @FXML
    private TextField textURL;
    
    //FIELDS FOR ADDING CHARACTERS
    @FXML
    private TextField textName;
    @FXML
    private TextField textGender;
    @FXML
    private TextArea textDescription;

    //FIELDS FOR FILTERING BOOKS
    @FXML
    private TextField filterTitle;
    @FXML
    private TextField filterAuthor;
    @FXML
    private TextField filterPublisher;
    @FXML
    private TextField filterYear;
    @FXML
    private TextField filterLength;
    @FXML
    private TextField filterGenre;
    
    
    @FXML
    void addBookOnClick(ActionEvent event) {

    }

    @FXML
    void addCharOnClick(ActionEvent event) {

    }

    @FXML
    void resetBookSearch(ActionEvent event) {

    }

}
