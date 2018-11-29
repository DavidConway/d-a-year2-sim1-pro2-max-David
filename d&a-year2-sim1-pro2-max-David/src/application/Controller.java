 package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
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
    @FXML
    private ScrollPane bookScrollPane;
    
    //FIELDS TO EDIT BOOKS
    @FXML
    private TextField textEditTitle;
    @FXML
    private TextField textEditAuthor;
    @FXML
    private TextField textEditYear;
    @FXML
    private TextField textEditLength;
    @FXML
    private TextField textEditGenre;
    @FXML
    private TextArea textEditPlot;
    @FXML
    private TextField textEditURL;
    @FXML
    private TextField textEditPublisher;
    
    //FIELDS TO EDIT CHARACTERS
    @FXML
    private TextField editTextName;
    @FXML
    private TextField editTextGender;
    @FXML
    private TextArea editTextDescription;
    
    //FIELDS TO ADD CHAR TO BOOK
    @FXML
    private ComboBox<Book> choiceBook;

    
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
    	int sort = 0;
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
    	for (int i = 0; i < Main.books.hashArray.length; i++)
    	{
    		if (Main.books.hashArray[i] != null)
    		{
    			sort++;
    		}
    	}
    	Book newBook = new Book(textTitle.getText(), textAuthor.getText(), textPublisher.getText(), pubYear, pageCount, textGenre.getText(), textPlot.getText(), textURL.getText(), sort);
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
    void addToBookOnClick(ActionEvent event) {

    }

    @FXML
    void deleteBookOnClick(ActionEvent event) {

    }

    @FXML
    void deleteCharOnClick(ActionEvent event) {

    }

    @FXML
    void editBookOnClick(ActionEvent event) {

    }

    @FXML
    void editCharOnClick(ActionEvent event) {

    }

    @FXML
    void resetBookSearch(ActionEvent event) {

    }
    
    void addToGrid(AnchorPane grid, int index, String... args){
    	for (int i = 0; i < args.length; i++)
    	{
    		if (i == 0)
    		{
    			Button button = new Button(args[i]);
        		button.getStyleClass().add("select");
        		grid.getChildren().add(button);

    			button.setPrefWidth(100);
    			button.setTranslateX(i * 102.2);
        		button.setTranslateY(index * 30);
    		}

    		else
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
    			if (i > 4)
    			{
    			label.setTranslateX(i * 102.2 -40);
        		label.setTranslateY(index * 30);
    			}
    		}
    	}
    	}
    }
    	
    
    
    void updateBookGrid()
    {
    	bookPane.getChildren().clear();
    	for (int i = 0; i < Main.books.hashArray.length; i++) {
    		if (Main.books.hashArray[i] != null)
 			{	
    		Book temp = ((Book) Main.books.hashArray[i]);
    		addToGrid(bookPane, (temp.getSort()), temp.getTitle(), temp.getAuthor(), temp.getPublisher(),temp.getGenre(), Integer.toString(temp.getPubYear()), Integer.toString(temp.getNumOfPages()));
 			}	
    	}
    	bookPane.setMinHeight(Main.books.hashArray.length*30);
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
    	String[] titles = new String[Main.books.hashArray.length];
    	int size = 0;
    	for (int i = 0; i < Main.books.hashArray.length; i ++)
    	{
    		System.out.println("Loop number: "+ i + "    Length of array: " + Main.books.hashArray.length);
    		if (((Book) Main.books.hashArray[i]) != null)
    		{
    			titles[i] = ((Book) Main.books.hashArray[i]).getTitle();
    			System.out.println("Found title: "+ titles[i]);
    			size ++;
    		}
    	}
    	String[] finalTitles = new String[size];
    	int temp = 0;
    	for (int i = 0; i < Main.books.hashArray.length; i ++)
    	{
    		System.out.println("Loop number: "+ i + "    Length of array: " + Main.books.hashArray.length);
    		if (((Book) Main.books.hashArray[i]) != null)
    		{
    			finalTitles[temp] = titles[i];
    			temp++;
    		}
    	}
    	
    	System.out.println(""+Main.sortString(finalTitles));
    	Integer[] sort = Main.sortString(finalTitles);
    	int j = 0;
    	System.out.println(sort);
    	for (int i = 0; i < Main.books.hashArray.length; i++)
    	{
    		if (Main.books.hashArray[i] != null)
    		{
    			((Book) Main.books.hashArray[i]).setSort(sort[j]);
    			System.out.println("Setting book index: "+ i +"    name: " +((Book) Main.books.hashArray[i]).getTitle() + "    to location: "+ sort[i-1]);
    			j++;
    		}
    	}
    	updateBookGrid();
    }

    @FXML
    void sortYear(ActionEvent event) {

    }
    
   
}
