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
	static int[] sortString(String[] args)
	    {
	    	int[] index = new int[args.length];
	    	
	    	//INITIALIZING INTEGER ARRAY
	    	
	    	for (int i = 0; i <args.length; i ++)
	    	{
	    		index[i] = i;
	    	}
	    	
	    	String[] temp = new String[args.length];
	    	
	    											
	    	for (int k = 0; k < args.length; k ++)						//LOOPS THE MAXIMUM NUMBER OF TIME/LENGTH OF LIST
	    	{							
		    	for (int i = 0; i < args.length; i++)   				//LOOPS THROUGH TITLES
		    	{
		    		for (int j = 0; j < args[i].length(); j ++)			//LOOPS THROUGH LETTERS IN TITLES
		    		{
		    			if (args[i].charAt(j) < args[i+1].charAt(j))	//COMPARES LETTERS/IF NEED TO SWITCH IT DOES
		        		{
		    				temp[i] = args[i+1];
		    				temp [i+1] = args[i];
		    				index[i] = i+1;
		    				index[i+1] = i;
		    				break;
		        		}
		    		}
		    	}
	    	}
	    	return index;
	    }
}
