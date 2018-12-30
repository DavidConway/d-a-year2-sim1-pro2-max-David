 package application;


import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

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
    	updateBookGrid();
    	updateCharGrid();
    }
    //METHODS FOR ADD/REMOVING/EDITING
    
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
    	Book newBook = new Book(textTitle.getText(), textAuthor.getText(), textPublisher.getText(), pubYear, pageCount, textGenre.getText(), textPlot.getText(), textURL.getText(), Main.books.size());
    	choiceBook.getItems().add(newBook);//adds the new book to the choice book
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
    	activeChar.addToBook(choiceBook.getValue());//adds the charicter to a book and a book to a character
    	choiceBook.getValue().addChar(activeChar);
    }

    @FXML
    void deleteBookOnClick(ActionEvent event) {
    	boolean removed = false;
    	//gose trow all boobs to see if it is the selected book then removes it
    	
    	for(Hashable c: Main.books.hashArray) {
    		
    		if(c == activeBook) {
    			choiceBook.getItems().remove(activeBook);
    			Main.books.hashArray[c.getHashNum()] = null;
    			updateBookGrid();
    			
    			removed = true;
    		}
    		else if (removed == true && c != null) {
    			c.setSort((c.getSort())-1);//adgusts the positions of sucseeding books
    			updateBookGrid();
    		}
    	}

    }

    @FXML
    void deleteCharOnClick(ActionEvent event) {
    	boolean removed = false;
    	for(Hashable c: Main.chars.hashArray) {
    		
    		if(c == activeChar) {
    			Main.chars.hashArray[c.getHashNum()] = null;
    			updateCharGrid();
    			removed = true;
    		}
    		else if (removed == true && c != null) {
    			c.setSort((c.getSort())-1);
    			updateCharGrid();
    		}
    	}
    }

    @FXML
    void editBookOnClick(ActionEvent event) {
    	if(textEditTitle.getText() != null) {
    		activeBook.setTitle(textEditTitle.getText());
    	}
    	if(textEditAuthor.getText() != null) {
    		activeBook.setAuthor(textEditAuthor.getText());
    	}
    	if(textEditYear.getText() != null) {
    		try {
    			activeBook.setPubYear(Integer.parseInt(textEditYear.getText()));
        	}
        	catch(Exception e) {
        	}
    	}
    	if(textEditLength.getText() != null) {
    		try {
    			activeBook.setNumOfPages(Integer.parseInt(textEditLength.getText()));
        	}
        	catch(Exception e) {
        	}
    	}
    	if(textEditGenre.getText() != null){
    		activeBook.setGenre(textEditGenre.getText());
    	}
    	if(textEditPlot.getText() != null){
    		activeBook.setPlot(textEditPlot.getText());
    	}
    	if(textEditURL.getText() != null){
    		activeBook.setImageUrl(textEditURL.getText());
    	}
    	if(textEditPublisher.getText() != null) {
    		activeBook.setPublisher(textEditPublisher.getText());
    	}
    }

    @FXML
    void editCharOnClick(ActionEvent event) {
    	if(editTextName.getText() != null) {
    		activeChar.setName(editTextName.getText());
    	}
    	if(editTextGender.getText() != null) {
    		activeChar.setGender(editTextGender.getText());
    	}
    	if(editTextDescription.getText() != null) {
    		activeBook.setTitle(editTextDescription.getText());
    	}
    }

    @FXML
    void resetBookSearch(ActionEvent event) {
    	filterTitle.setText(null);
    	filterAuthor.setText(null);
    	filterYear.setText(null);
    	filterPublisher.setText(null);
    	filterGenre.setText(null);
    	filterLength.setText(null);
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
    			button.setTranslateX(2);
        		button.setTranslateY(index * 30);
    		}

    		else
    		{
    		Label label = new Label(args[i]);
    		label.getStyleClass().add("gridlabel");
    		grid.getChildren().add(label);

			label.setMinWidth(100);
			label.setTranslateX(i *100);
    		label.setTranslateY(index * 30);
    		
			
    		if (i > 3)
    		{
    			label.setMaxWidth(60);
    			label.setMinWidth(60);
    			label.setPrefWidth(60);
    			if (i > 4)
    			{
    			label.setTranslateX(i * 100 -40 + 4);
        		label.setTranslateY(index * 30);
    			}
    		}
    		}
    		Label rightSpace = new Label();
    		grid.getChildren().add(rightSpace);

    		rightSpace.setPrefWidth(2);
    		rightSpace.setTranslateX(i * 100 + 4);
    		rightSpace.setTranslateY(index * 30);
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
    void sortPublisher(ActionEvent event) {
    	String[] publishers = new String[Main.books.size()];
    	for (int i = 0; i < Main.books.size(); i ++){
    			publishers[i] = ((Book) Main.books.get(i)).getPublisher();
    	}
    	sortBooks(publishers);
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
    
    //save and clear and load
    @FXML
    void save(ActionEvent event) {
    	try {
			FileOutputStream outBook = new FileOutputStream(new File("./d&a-year2-sim1-pro2-max-David/src/Books.xml"));
			XMLEncoder encoB = new XMLEncoder(outBook);
			encoB.writeObject(Main.books.hashArray);
			encoB.close();
			outBook.close();
			
			FileOutputStream outChar = new FileOutputStream(new File("./d&a-year2-sim1-pro2-max-David/src/Characters.xml"));
			XMLEncoder encoC = new XMLEncoder(outChar);
			encoC.writeObject(Main.chars.hashArray);
			encoC.close();
			outChar.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void clear(ActionEvent event) {
    	Main.books.hashArray = new Hashable[10];
    	Main.chars.hashArray = new Hashable[10];
    	updateBookGrid();
    	updateCharGrid();
    }
    
    @FXML
    void load(ActionEvent event) {
    	try {
			FileInputStream inBook = new FileInputStream(new File("./d&a-year2-sim1-pro2-max-David/src/Books.xml"));
			XMLDecoder decoB = new XMLDecoder(inBook);
			Main.books.hashArray =  (Hashable[])decoB.readObject();
			decoB.close();
			inBook.close();
			
			FileInputStream inChar = new FileInputStream(new File("./d&a-year2-sim1-pro2-max-David/src/Characters.xml"));
			XMLDecoder decoC = new XMLDecoder(inChar);
			Main.chars.hashArray =  (Hashable[])decoC.readObject();
			decoC.close();
			inChar.close();
			updateBookGrid();
			updateCharGrid();

		} catch (IOException e) {
			System.out.println("erroer");
		}
    }
		   
}
