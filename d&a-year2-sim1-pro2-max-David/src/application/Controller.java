 package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class Controller {

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
    private AnchorPane bookPane;
    @FXML
    private Pane bookCharPane;
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
    void addBookOnClick(ActionEvent event) {// 
    	int pubYear;
    	int pageCount;
    	//trys to parse the textYear to a int and sets to 0 if it fales
    	try {
    		pubYear = Integer.parseInt(textYear.getText());
    	}
    	catch(Exception e) {
    		pubYear = 0;
    	}
    	//
    	//trys to parse the textYLenght to a int and sets to 0 if it fales
    	try {
    		pageCount = Integer.parseInt(textLength.getText());
    	}
    	catch(Exception e) {
    		pageCount = 0;
    	}
    	//
    	
    	Book newBook = new Book(textTitle.getText(), textAuthor.getText(), textPublisher.getText(), pubYear, pageCount, textGenre.getText(), textPlot.getText(), textURL.getText());
    	Main.sortedBooks.add(newBook);
    	Main.books.add(newBook);
    	updateBookGrid();
    }

    @FXML
    void addCharOnClick(ActionEvent event) {
    	Character newChar = new Character(textName.getText(), textGender.getText(), textDescription.getText());
    	Main.sortedChars.add(newChar);
    	Main.chars.add(newChar);
    	updateCharGrid();
    }

    @FXML
    void resetBookSearch(ActionEvent event) {

    }
    
    void addToGrid(AnchorPane grid, int index, String... args){
    	for (int i = 0; i < args.length; i++)
    	{
    		if (i == 0)
    		{
    			Button button = new Button(args[0]);
    			grid.getChildren().add(button);
    			button.setPrefHeight(30);
    			button.setPrefWidth(100);
    			button.setTranslateX(i * 102.2);
        		button.setTranslateY(index * 30);
        		button.getStyleClass().add("select");
    		}
    		if (i > 0)
    		{
    		Label label = new Label(args[i]);
    		label.getStyleClass().add("gridlabel");
    		grid.getChildren().add(label);

			label.setPrefWidth(100);
			label.setTranslateX(i * 102.2);
    		label.setTranslateY(index * 30);
    		
			
    		if (i > 3)
    		{
    			label.setMaxWidth(60);
    			label.setMinWidth(60);
    			label.setPrefWidth(60);
    			System.out.println("Setting width : " + 60);
    			if (i > 4)
    			{
    			label.setTranslateX(i * 102.2 -40);
        		label.setTranslateY(index * 30);
    			}
    		}
    		
    
    		/**
    		while (args[i].length()*5 > column.getWidth()) //Resizing columns if text is long
    		{
    			column.setPrefWidth(column.getWidth()+5);
    		}
    		**/
    	}}
    	
    }
    
    void updateBookGrid()
    {
    	bookPane.getChildren().clear();
    	for (int i = 0; i < Main.sortedBooks.size(); i++) {
    		Book temp = Main.sortedBooks.get(i).getContents();
    		addToGrid(bookPane, Main.sortedBooks.get(i).getIndex(), temp.getTitle(), temp.getAuthor(), temp.getPublisher(),  temp.getGenre(),Integer.toString(temp.getPubYear()), Integer.toString(temp.getNumOfPages()));
    	}
    	bookPane.setMinHeight(Main.sortedBooks.size()*30);
    }
    
    void updateCharGrid()
    {
    	for (int i = 0; i < Main.sortedChars.size(); i++) {
    		
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
    	String[] titles = new String[Main.sortedBooks.size()];
    	for (int i = 0; i < Main.sortedBooks.size(); i ++)
    	{
    		titles[i] = Main.sortedBooks.get(i).getContents().getTitle();
    	}
    	Main.sortString(titles);
    }

    @FXML
    void sortYear(ActionEvent event) {

    }
    
   
}
