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
import javafx.stage.Screen;

public class Controller {
	public Book activeBook;
	public Character activeChar;

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
    void initialize()
    {
    	bookScrollPane.setMinViewportHeight(Screen.getPrimary().getBounds().getHeight());
    	bookScrollPane.setFitToHeight(true);
    }
    //METHODS FOR ADD/REMOVING/EDITING
    
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
    	Book newBook = new Book(textTitle.getText(), textAuthor.getText(), textPublisher.getText(), pubYear, pageCount, textGenre.getText(), textPlot.getText(), textURL.getText(), Main.books.size());
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
    	boolean removed = false;
    	for(Hashable c: Main.books.hashArray) {
    		
    		if(c == activeBook) {
    			Main.books.hashArray[c.getHashNum()] = null;
    			updateBookGrid();
    			removed = true;
    		}
    		else if (removed == true && c != null) {
    			c.setSort((c.getSort())-1);
    			updateBookGrid();
    		}
    	}

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
    
    
    //METHODS FOR GRIDDING
    
    void addToGrid(AnchorPane grid, int index, int hash, String... args){
    	for (int i = 0; i < args.length; i++)
    	{
    		if (i == 0)
    		{
    			Button button = new Button(args[i]);
        		button.getStyleClass().add("select");
        		grid.getChildren().add(button);
        		button.setOnAction(e -> {
	        		if(grid == bookPane){
	        			activeBook=(Book)Main.books.get(hash);
	        		}
	        		else {
	        			activeChar = (Character)Main.chars.get(hash);
	        		}
        		}
        		);
    			button.setPrefWidth(100);
    			button.setTranslateX(i * 102.3);
        		button.setTranslateY(index * 30);
    		}

    		else
    		{
    		Label label = new Label(args[i]);
    		label.getStyleClass().add("gridlabel");
    		grid.getChildren().add(label);

			label.setPrefWidth(100);
			label.setTranslateX(i * 102.3);
    		label.setTranslateY(index * 30);
    		
			
    		if (i > 3)
    		{
    			label.setMaxWidth(60);
    			label.setMinWidth(60);
    			label.setPrefWidth(60);
    			if (i > 4)
    			{
    			label.setTranslateX(i * 102.3 -40);
        		label.setTranslateY(index * 30);
    			}
    		}
    		}
    	}
    }
    	
    
    
    void updateBookGrid()
    {
    	bookPane.getChildren().clear();
    	for (int i = 0; i < Main.books.size(); i++) {
    		System.out.println("Size:  "+Main.books.size());
    		Book temp = (Book)Main.books.get(i);
    		System.out.println(temp.getTitle());
    		addToGrid(bookPane, (temp.getSort()), i, temp.getTitle(), temp.getAuthor(), temp.getPublisher(),temp.getGenre(), Integer.toString(temp.getPubYear()), Integer.toString(temp.getNumOfPages()));	
    	}
    	bookPane.setMinHeight(Main.books.size()*30);
    }
    
    void updateCharGrid()
    {
    	for (int i = 0; i < Main.sortedChars.size(); i++) {
    		
    	}
    }
    

    //METHODS FOR SORTING
    
    @FXML
    void sortAuthor(ActionEvent event) {
    	String[] authors = new String[Main.books.size()];
    	for (int i = 0; i < Main.books.size(); i ++){
    			authors[i] = ((Book) Main.books.get(i)).getAuthor();
    	}
    	sortBooks(authors);
    	updateBookGrid();

    }

    @FXML
    void sortGenre(ActionEvent event) {
    	String[] genre = new String[Main.books.size()];
    	for (int i = 0; i < Main.books.size(); i ++){
    			genre[i] = ((Book) Main.books.get(i)).getGenre();
    	}
    	sortBooks(genre);
    	updateBookGrid();
    }

    void sortBooks(String [] strings)
    {
    	Integer[] sort = Main.sortString(strings);
    	for (int i = 0; i < Main.books.size(); i++){
    		((Book) Main.books.get(sort[i])).setSort(i);
    	}
    }
    
    @FXML
    void sortPages(ActionEvent event) {

    }

    @FXML
    void sortTitle(ActionEvent event) {
    	String[] titles = new String[Main.books.size()];
    	for (int i = 0; i < Main.books.size(); i ++){
    			titles[i] = ((Book) Main.books.get(i)).getTitle();
    	}
    	sortBooks(titles);
    	updateBookGrid();
    }

    @FXML
    void sortYear(ActionEvent event) {

    }
    
    //METHODS FOR FILTERING
    @FXML
    void filterAuthor(ActionEvent event) {

    }

    @FXML
    void filterGenre(ActionEvent event) {

    }

    @FXML
    void filterLength(ActionEvent event) {

    }

    @FXML
    void filterPublisher(ActionEvent event) {

    }

    @FXML
    void filterTitle(ActionEvent event) {

    }
    @FXML
    void filterYear(ActionEvent event) {

    }
		   
}
