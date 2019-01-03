package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;



public class Main extends Application {
	public static HashTable books = new HashTable();
	public static HashTable chars = new HashTable();
	
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
	
	static Integer[] sortString(String[] args) {
		Integer[] index = new Integer[args.length];
		boolean swapped = true;

		for (int i = 0; i < args.length; i++) {	
			index[i] = i;		// INITIALIZING INTEGER ARRAY
		}
		while (swapped == true) {
			swapped = false;
			for (int i = 0; i < args.length-1; i++) // LOOPS THROUGH TITLES
			{
				if (args[i].charAt(0) > args[i + 1].charAt(0) ) // COMPARES LETTERS/IF NEED TO SWITCH IT DOES
				{
					String temp = args[i];
					int tempInt = index[i];
					index[i] = (index[(i + 1)]);
					args[i] = (args[(i + 1)]);
					index[(i + 1)] = tempInt;
					args[(i + 1)] = temp;	
					swapped = true;
					break;
				}
			}	
		}
		return index;
	}

	static Integer[] sortInt(Integer[] args) {
		Integer[] index = new Integer[args.length];
		boolean swapped = true;
		
		for (int i = 0; i < args.length; i++) {
			index[i] = i; // INITIALIZING INTEGER ARRAY
		}
		while (swapped == true) {
			swapped = false;
			for (int i = 0; i < (args.length-1); i++) // LOOPS THROUGH TITLES
			{
				if (args[i] > args[i + 1]) 
				{
					int temp = args[i];
					args[i] = args[i + 1];
					args[i + 1] = temp;
					swapped = true;
					break;
				}
			}
		}
		return args;
	}
}
