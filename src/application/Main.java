package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

/**
*
*@author Bandile Danxa
*/
public class Main extends Application{
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		launch(args);
	}
	
	/**
	 * 
	 */
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		Controller controller = new Controller();
		primaryStage.setScene(controller);
		primaryStage.setTitle("Multiplexer Simulation");
		primaryStage.show();
		
	}

}
