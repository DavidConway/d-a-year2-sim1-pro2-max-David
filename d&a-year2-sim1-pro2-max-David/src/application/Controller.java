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
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;

public class Controller {
	public Book activeBook;
	public Character activeChar;

	@FXML
	private Menu file;
	@FXML
	private Menu edit;
	@FXML
	private Menu help;
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
    private TextField filterName;

    @FXML
    private TextField filterGender;
    
    //GRIDS TO ADD TO
    @FXML
    private AnchorPane bookPane;
    @FXML
    private Pane bookCharPane;
    @FXML
    private Pane characterPane;

    @FXML
    private Pane charBookPane;
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
    	bookScrollPane.setMinViewportHeight(Screen.getPrimary().getBounds().getHeight());	//Setting up scrollpane
    	bookScrollPane.setFitToHeight(true);
    	updateBookGrid();
    	updateCharGrid();
    	
    	file.getItems().clear();				//Adding menu items 
    	MenuItem save = new MenuItem("Save");
		file.getItems().add(save);
		save.setOnAction(e -> save());
		MenuItem load = new MenuItem("Load");
		file.getItems().add(load);
		load.setOnAction(e ->load());
    	
    	edit.getItems().clear();
    	MenuItem reset = new MenuItem("Reset System");
		edit.getItems().add(reset);
		reset.setOnAction(e -> clear());
		
    	
    	
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
    	Book newBook = new Book(textTitle.getText(), textAuthor.getText(), textPublisher.getText(), pubYear, pageCount, textGenre.getText(), textPlot.getText(), Main.books.size());
    	choiceBook.getItems().add(newBook);//adds the new book to the choice book
    	Main.books.add(newBook);
    	updateBookGrid();
    }

    @FXML
    void addCharOnClick(ActionEvent event) {
    	Character newChar = new Character(textName.getText(), textGender.getText(), textDescription.getText(), Main.chars.size());
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
    	if(textEditPublisher.getText() != null) {
    		activeBook.setPublisher(textEditPublisher.getText());
    	}
    	updateBookGrid();
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
    	updateBookGrid();
    }
    
    //METHODS FOR GRIDDING
    
    void addToGrid(Pane grid, int index, int hash, String... args){
    	
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
	        			updateBookGrid();
	        			textEditTitle.setText(activeBook.getTitle());
	        		    textEditAuthor.setText(activeBook.getAuthor());
	        		    textEditYear.setText(Integer.toString(activeBook.getPubYear()));
	        		    textEditLength.setText(Integer.toString(activeBook.getNumOfPages()));
	        		    textEditGenre.setText(activeBook.getGenre());
	        		    textEditPlot.setText(activeBook.getPlot());
	        		    textEditPublisher.setText(activeBook.getPublisher());
	        		}
	        		else {
	        			activeChar = (Character)Main.chars.get(hash);
	        			updateCharGrid();
	        			editTextName.setText(activeChar.getName());
	        		    editTextGender.setText(activeChar.getGender());
	        		    editTextDescription.setText(activeChar.getDescription());
	        		}
	        		
        		}
        		);
    			button.setPrefWidth(100);
    			button.setTranslateX(0);
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
    			label.setTranslateX(i * 100 -40);
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
    		Book temp = (Book)Main.books.get(i);
    		addToGrid(bookPane, (temp.getSort()), i, temp.getTitle(), temp.getAuthor(), temp.getPublisher(),temp.getGenre(), Integer.toString(temp.getPubYear()), Integer.toString(temp.getNumOfPages()));	
    	}
    	bookPane.setMinHeight(Main.books.size()*30);
    	bookCharPane.getChildren().clear();
    	if (activeBook != null)
    	{
    	for (int i = 0; i < activeBook.getList().size(); i++) {
    		int num = activeBook.getCharacters(i);
    		Character temp = (Character) Main.chars.getHash(num);
    		addToGrid(bookCharPane, i , num, temp.getName());
    	}
    	}
    	
    }
    
    void updateCharGrid()
    {
    	characterPane.getChildren().clear();
    	for (int i = 0; i < Main.chars.size(); i++) {
    		Character temp = (Character)Main.chars.get(i);
    		addToGrid(characterPane, (temp.getSort()), i, temp.getName(), temp.getGender(), temp.getDescription());	
    	}
    	charBookPane.getChildren().clear();
    	if (activeChar != null)
    	{
    		for (int i = 0; i < activeChar.getList().size(); i++) {
	    		int num = activeChar.getBook(i);
	    		Book temp = (Book) Main.books.getHash(num);
	    		addToGrid(charBookPane, i , num, temp.getTitle());
    		}
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
    void sortBooks(Integer [] numbers)
    {
    	Integer[] sort = Main.sortInt(numbers);
    	for (int i = 0; i < Main.books.size(); i++){
    		((Book) Main.books.get(sort[i])).setSort(i);
    	}
    }
    
    @FXML
    void sortPages(ActionEvent event) {
    	Integer[] pages = new Integer[Main.books.size()];
    	for (int i = 0; i < Main.books.size(); i ++){
			pages[i] = ((Book) Main.books.get(i)).getNumOfPages();
	}
	sortBooks(pages);
	updateBookGrid();
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
    	Integer[] years = new Integer[Main.books.size()];
    	for (int i = 0; i < Main.books.size(); i ++){
			years[i] = ((Book) Main.books.get(i)).getPubYear();
	}
	sortBooks(years);
	updateBookGrid();
    }
    @FXML
    void sortGender(ActionEvent event) {
    	String[] genders = new String[Main.chars.size()];
    	for (int i = 0; i < Main.chars.size(); i ++){
    			genders[i] = ((Character) Main.chars.get(i)).getGender();
    	}
    	sortCharacters(genders);
    	updateCharGrid();

    }
    private void sortCharacters(String[] strings) {
    	Integer[] sort = Main.sortString(strings);
    	for (int i = 0; i < Main.chars.size(); i++){
    		((Character) Main.chars.get(sort[i])).setSort(i);
    	}
		
	}

	@FXML
    void sortName(ActionEvent event) {
		String[] names = new String[Main.chars.size()];
    	for (int i = 0; i < Main.chars.size(); i ++){
    			names[i] = ((Character) Main.chars.get(i)).getName();
    	}
    	sortCharacters(names);
    	updateCharGrid();
    	
    }
    
    //METHODS FOR FILTERING
    @FXML
    void filterAuthor(ActionEvent event) {
    	bookPane.getChildren().clear();
    	String author = filterAuthor.getText();
    	int j = 0;
    	for (int i = 0; i < Main.books.size()-1; i ++)
    	{
    		if (((Book)Main.books.get(i)).getAuthor().equals(author))
    		{
    			addToGrid(bookPane, j, 0, ((Book)Main.books.get(i)).getTitle(), ((Book)Main.books.get(i)).getAuthor(), ((Book)Main.books.get(i)).getPublisher(), ((Book)Main.books.get(i)).getGenre(), Integer.toString(((Book)Main.books.get(i)).getPubYear()), Integer.toString(((Book)Main.books.get(i)).getNumOfPages()) );
    		}
    	}
    }

    @FXML
    void filterGenre(ActionEvent event) {
    	bookPane.getChildren().clear();
    	String genre = filterGenre.getText();
    	int j = 0;
    	for (int i = 0; i < Main.books.size()-1; i ++)
    	{
    		if (((Book)Main.books.get(i)).getGenre().equals(genre))
    		{
    			addToGrid(bookPane, j, 0, ((Book)Main.books.get(i)).getTitle(), ((Book)Main.books.get(i)).getAuthor(), ((Book)Main.books.get(i)).getPublisher(), ((Book)Main.books.get(i)).getGenre(), Integer.toString(((Book)Main.books.get(i)).getPubYear()), Integer.toString(((Book)Main.books.get(i)).getNumOfPages()) );
    		}
    	}
    }

    @FXML
    void filterLength(ActionEvent event) {
    	bookPane.getChildren().clear();
    	int NumOfPages = Integer.parseInt(filterLength.getText());
    	int j = 0;
    	for (int i = 0; i < Main.books.size()-1; i ++)
    	{
    		if (((Book)Main.books.get(i)).getNumOfPages() == NumOfPages)
    		{
    			addToGrid(bookPane, j, 0, ((Book)Main.books.get(i)).getTitle(), ((Book)Main.books.get(i)).getAuthor(), ((Book)Main.books.get(i)).getPublisher(), ((Book)Main.books.get(i)).getGenre(), Integer.toString(((Book)Main.books.get(i)).getPubYear()), Integer.toString(((Book)Main.books.get(i)).getNumOfPages()) );
    		}
    	}
    }

    @FXML
    void filterPublisher(ActionEvent event) {
    	bookPane.getChildren().clear();
    	String publisher = filterPublisher.getText();
    	int j = 0;
    	for (int i = 0; i < Main.books.size()-1; i ++)
    	{
    		if (((Book)Main.books.get(i)).getPublisher().equals(publisher))
    		{
    			addToGrid(bookPane, j, 0, ((Book)Main.books.get(i)).getTitle(), ((Book)Main.books.get(i)).getAuthor(), ((Book)Main.books.get(i)).getPublisher(), ((Book)Main.books.get(i)).getGenre(), Integer.toString(((Book)Main.books.get(i)).getPubYear()), Integer.toString(((Book)Main.books.get(i)).getNumOfPages()) );
    		}
    	}
    }

    @FXML
    void filterTitle(ActionEvent event) {
    	bookPane.getChildren().clear();
    	String title = filterTitle.getText();
    	int j = 0;
    	for (int i = 0; i < Main.books.size()-1; i ++)
    	{
    		if (((Book)Main.books.get(i)).getTitle().equals(title))
    		{
    			addToGrid(bookPane, j, 0, ((Book)Main.books.get(i)).getTitle(), ((Book)Main.books.get(i)).getAuthor(), ((Book)Main.books.get(i)).getPublisher(), ((Book)Main.books.get(i)).getGenre(), Integer.toString(((Book)Main.books.get(i)).getPubYear()), Integer.toString(((Book)Main.books.get(i)).getNumOfPages()) );
    		}
    	}
    }
    
    @FXML
    void filterYear(ActionEvent event) {
    	bookPane.getChildren().clear();
    	int year = Integer.parseInt(filterYear.getText());
    	int j = 0;
    	for (int i = 0; i < Main.books.size()-1; i ++)
    	{
    		if (((Book)Main.books.get(i)).getPubYear() == year)
    		{
    			addToGrid(bookPane, j, 0, ((Book)Main.books.get(i)).getTitle(), ((Book)Main.books.get(i)).getAuthor(), ((Book)Main.books.get(i)).getPublisher(), ((Book)Main.books.get(i)).getGenre(), Integer.toString(((Book)Main.books.get(i)).getPubYear()), Integer.toString(((Book)Main.books.get(i)).getNumOfPages()) );
    		}
    	}
    }
    @FXML
    void filterName(ActionEvent event) {
    	characterPane.getChildren().clear();
    	String name = filterName.getText();
    	int j = 0;
    	for (int i = 0; i < Main.chars.size()-1; i ++)
    	{
    		if (((Character)Main.chars.get(i)).getName().equals(name))
    		{
    			addToGrid(characterPane, j, 0, ((Character)Main.chars.get(i)).getName(), ((Character)Main.chars.get(i)).getGender(), ((Character)Main.chars.get(i)).getDescription());
    		}
    	}
    }
    @FXML
    void filterGender(ActionEvent event) {
    	characterPane.getChildren().clear();
    	String gender = filterGender.getText();
    	int j = 0;
    	for (int i = 0; i < Main.chars.size()-1; i ++)
    	{
    		if (((Character)Main.chars.get(i)).getGender().equals(gender))
    		{
    			addToGrid(characterPane, j, 0, ((Character)Main.chars.get(i)).getName(), ((Character)Main.chars.get(i)).getGender(), ((Character)Main.chars.get(i)).getDescription());
    		}
    	}
    }
    //save and clear and load
    @FXML
    void save() {
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
    void clear() {
    	Main.books.hashArray = new Hashable[10];
    	Main.chars.hashArray = new Hashable[10];
    	updateBookGrid();
    	updateCharGrid();
    }
    
    @FXML
    void load() {
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
