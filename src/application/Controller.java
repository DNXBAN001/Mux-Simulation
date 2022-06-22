package application;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
*
*@author Bandile Danxa
*/
public class Controller extends Scene implements EventHandler<KeyEvent>
{
	
	private static final double HEIGHT = 350;
	private static final double WIDTH = 350;
	private Pane pane;
	private MultiplexerView multiplexer ;
	private Canvas canvas;

	/**
	 * 
	 */
	public Controller() 
	{
		super(new Pane());
		this.createContent();
		super.setRoot(this.pane);
		this.setOnKeyPressed(this);
	}
	
	/**
	 * 
	 */
	private void createContent() 
	{
		pane =  new Pane();
		pane.setPrefSize(WIDTH, HEIGHT);
		this.multiplexer = new MultiplexerView();
		populateGUI();
	}

	/**
	 * 
	 */
	private void populateGUI() {
		this.pane.getChildren().clear();
		this.drawMenu();
		this.canvas = multiplexer.drawMultiplexer();
		this.canvas.relocate(100,100);
		this.pane.getChildren().addAll(canvas);
	}
	
	/**
	 * 
	 */
	private void drawMenu()
	{
		Rectangle funtionA = new Rectangle(25,5,20,20);
		Text textA = new Text(29,20,"F1"); textA.setFill(Color.WHITE);
		Text inputA = new Text(50,20,"Set / Clear Input A");
		this.pane.getChildren().addAll(funtionA,textA,inputA);
		
		Rectangle funtionB = new Rectangle(25,30,20,20);
		Text textB = new Text(29,45,"F2"); textB.setFill(Color.WHITE);
		Text inputB = new Text(50,45,"Set / Clear Input B");
		this.pane.getChildren().addAll(funtionB,textB,inputB);
		
		Rectangle funtionC = new Rectangle(25,55,20,20);
		Text textC = new Text(29,70,"F3"); textC.setFill(Color.WHITE);
		Text inputC = new Text(50,70,"Set / Clear Input C");
		this.pane.getChildren().addAll(funtionC,textC,inputC);
		
		Rectangle funtionD = new Rectangle(25,80,20,20);
		Text textD = new Text(29,95,"F4"); textD.setFill(Color.WHITE);
		Text inputD = new Text(50,95,"Set / Clear Input D");
		this.pane.getChildren().addAll(funtionD,textD,inputD);
		
		Rectangle fctSelectA = new Rectangle(200,5,20,20);
		Text txtSelectA = new Text(204,20,"F5"); txtSelectA.setFill(Color.WHITE);
		Text txtinputA = new Text(225,20,"Set / Clear Select A");
		this.pane.getChildren().addAll(fctSelectA,txtSelectA,txtinputA);
		
		Rectangle fctSelectB = new Rectangle(200,30,20,20);
		Text txtSelectB = new Text(204,45,"F6"); txtSelectB.setFill(Color.WHITE);
		Text txtinputB = new Text(225,45,"Set / Clear Select B");
		this.pane.getChildren().addAll(fctSelectB,txtSelectB,txtinputB);
		
	}

	@SuppressWarnings("incomplete-switch")
	@Override
	public void handle(KeyEvent e) 
	{
		
		switch(e.getCode())
		{
		case F1:
				this.multiplexer.getModel().toggleBit(State.A);
			break;
		case F2:
			this.multiplexer.getModel().toggleBit(State.B);
			break;
		case F3:
			this.multiplexer.getModel().toggleBit(State.C);
			break;
		case F4:
			this.multiplexer.getModel().toggleBit(State.D);
			break;
		case F5:
			this.multiplexer.getModel().toggleBit(State.a);
			break;
		case F6:
			this.multiplexer.getModel().toggleBit(State.b);
			break;
	}
	this.populateGUI();
		
	}
}
