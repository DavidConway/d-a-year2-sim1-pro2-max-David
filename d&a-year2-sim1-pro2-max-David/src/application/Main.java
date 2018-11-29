package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;


public class Main extends Application {
	static HashTable books = new HashTable();
	static HashTable chars = new HashTable();
	static LinkedList<Book> sortedBooks = new LinkedList<>();
	static LinkedList<Character> sortedChars = new LinkedList<>();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane root = (Pane) FXMLLoader.load(Main.class.getResource("gui.fxml"));
			Scene scene = new Scene(root,1280,800);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	static Integer[] sortString(String[] args)
	    {
	    	Integer[] index = new Integer[args.length];
	    	boolean swapped = true;
	    	
	    	System.out.println("Length of array: "+args.length);
	    	
	    	//INITIALIZING INTEGER ARRAY
	    	
	    	for (int i = 0; i <args.length; i ++)
	    	{
	    		index[i] = i;
	    	}
	    	
	    	while(swapped == true)
	    	{
	    	swapped = false;
		    	for (int i = 0; i < args.length-1; i++)   				//LOOPS THROUGH TITLES
		    	{
		    		System.out.println("Checking title "+i+" now...");
		    		if (args[i].charAt(0) > args[i+1].charAt(0))	//COMPARES LETTERS/IF NEED TO SWITCH IT DOES
		        		{
		    			System.out.println("Determined there should be a swap between " +args[i]+ "   and: " + args[i+1]);
		    				String temp = args[i];
		    				int tempInt = index[i];
		    				args[i] = args[i+1];
		    				args [i+1] = temp;
		    				index[i] = i+1;
		    				index[i+1] = tempInt;
		    				swapped = true;
		        		}
		    		}
		    	}
	    	
	    	for (int i = 0; i <index.length; i++)
	    	{
	    		System.out.println(index[i] + i); 
	    	}
	    	
	    	return index;
	    }
}
