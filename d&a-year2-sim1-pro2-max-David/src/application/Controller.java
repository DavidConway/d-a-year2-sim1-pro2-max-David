 package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class Controller {
	//LISTS TO USE
	LinkedList<Book> books = new LinkedList<>();
	LinkedList<Book> chars = new LinkedList<>();

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
    
    //GRIDS TO ADD TO
    @FXML
    private Pane bookPane;
    @FXML
    private Pane characterPane;
    
    //SORTING BUTTONS
    @FXML
    private Button titleButton;
    @FXML
    private Button authorButton;
    @FXML
    private Button yearButton;
    @FXML
    private Button genreButton;
    @FXML
    private Button pagesButton;
   
    @FXML
    void addBookOnClick(ActionEvent event) {

    }

    @FXML
    void addCharOnClick(ActionEvent event) {

    }

    @FXML
    void resetBookSearch(ActionEvent event) {

    }
    
    void addToGrid(Pane grid, int index, String... args){
    	for (int i = 0; i < args.length; i++)
    	{
    		double temp = 0;
    		Label label = new Label(args[i]);
    		grid.getChildren().add(label);
    		label.setTranslateX(temp);
    		label.setTranslateY(index * 30);
    		temp = temp+label.getWidth();
    		/**
    		while (args[i].length()*5 > column.getWidth()) //Resizing columns if text is long
    		{
    			column.setPrefWidth(column.getWidth()+5);
    		}
    		**/
    	}
    }
    
    void updateBookGrid()
    {
    	for (int i = 0; i < books.size(); i++) {
    		Book temp = books.get(i).getContents();
    		addToGrid(bookPane, books.get(i).getIndex(), temp.getTitle(), temp.getAuthor(), Integer.toString(temp.getPubYear()), temp.getGenre(), Integer.toString(temp.getNumOfPages()));
    	}
    }
    
    void updateCharGrid()
    {
    	for (int i = 0; i < chars.size(); i++) {
    		
    	}
    }
    

    @FXML
    void sortAuthor(ActionEvent event) {

    }

    @FXML
    void sortGenre(ActionEvent event) {

    }

    @FXML
    void sortPages(ActionEvent event) {

    }

    @FXML
    void sortTitle(ActionEvent event) {

    }

    @FXML
    void sortYear(ActionEvent event) {

    }

}
