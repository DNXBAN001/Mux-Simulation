package application;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
*
*@author Bandile Danxa
*/
public class MultiplexerView
{
	private static final double WIDTH = 200;
	private static final double HEIGHT = 240;
	private MultiplexerModel model;
	
	
	/**
	 * 
	 */
	public MultiplexerView() 
	{
		this.model = new MultiplexerModel(); //create an object of MutiplexerModel
	}
	
	/**
	 * 
	 * @return model of type MultiplexerModel
	 */
	public MultiplexerModel getModel()
	{
		return model;
	}

	/**
	 * @return 
	 * 
	 */
	public Canvas drawMultiplexer()
	{
		Canvas container = new Canvas(WIDTH,HEIGHT);
		GraphicsContext g = container.getGraphicsContext2D();
		
		//Font font = Font.font("Comic", 14);
		g.setFill(Color.RED);
		//g.setFont(font); g.setLineWidth(3);
		
	
		//draw Inputs
		drawBody(g); 
		drawInputA(g);
		drawInputB(g);
		drawInputC(g);
		drawInputD(g);
		drawSelectA(g);
		drawSelectB(g);
		
		drawOutput(g);
		
		
		
	    /* update INPUTS / Selects */
		//font = Font.font("Arial", FontWeight.BOLD,16);
		//g.setFont(font);
		
	    updateInputs(g);
	    updateSelector(g);
	     
	    /* update OUTPUTS*/
	    updateOutput(g);
	    
	   return container;
	}

	/**
	 * @param g
	 */
	private void drawBody(GraphicsContext g)
	{
		g.fillPolygon(new double[]{50, 150, 150,50},new double[] {0,30,170,200},4);
		g.setFill(Color.WHITE);
	}

	/**
	 * @param g
	 */
	private void drawOutput(GraphicsContext g)
	{
		g.strokeLine(150,100,200,100); 
		g.fillText("Q",185,115);
	}
	
	/**
	 * @param g
	 */
	private void updateSelector(GraphicsContext g)
	{
		g.setStroke(Color.BLUE);
		if(model.AND(model.NOT(State.a),model.NOT(State.b))) g.strokeLine(50,40,150,100); 
		
		if(model.AND(model.NOT(State.a), State.b)) g.strokeLine(50,80,150,100);
		
		if(model.AND(model.NOT(State.b),State.a)) 	g.strokeLine(50,120,150,100);
		
		if(model.AND(State.a, State.b)) g.strokeLine(50,160,150,100);
		
	}
	/**
	 * @param g
	 */
	private void drawInputD(GraphicsContext g) 
	{
		g.strokeLine(0,160,50,160); // INPUT A
		g.fillText("D",3,175);
	}

	/**
	 * @param g
	 */
	private void drawInputC(GraphicsContext g) 
	{
		g.strokeLine(0,120,50,120); // INPUT A
		g.fillText("C",3,135);
	}

	/**
	 * @param g
	 */
	private void drawInputB(GraphicsContext g)
	{
		g.strokeLine(0,80,50,80); // INPUT B
		g.fillText("B",3,95);
	}

	/**
	 * @param g
	 */
	private void drawInputA(GraphicsContext g) 
	{
		g.setFill(Color.RED);
		g.strokeLine(0,40,50,40); // INPUT A
		g.fillText("A",3,55);
	}
	
	/**
	 * @param g
	 */
	private void drawSelectA(GraphicsContext g) 
	{
		g.strokeLine(83,190,83,240); // Select a
		g.fillText("a",86,235);
	}
	
	/**
	 * @param g
	 */
	private void drawSelectB(GraphicsContext g) 
	{
		g.strokeLine(116,180,116,240); // Select b
		g.fillText("b",119,235);
	}
	
	/**
	 * @param g
	 */
	private void updateOutput(GraphicsContext g)
	{
		setColor(g,State.Q);
		drawText(g,State.Q,155,95); 	// display output Q
	}
	
	/**
	 * 
	 * @param g
	 */
	private void updateInputs(GraphicsContext g) 
	{
		setColor(g,State.A);
		drawText(g,State.A,40,35); 	// display input A
		
		setColor(g,State.B);
	    drawText(g,State.B,40,75); 	// display input B
	    
	    setColor(g,State.C);
	    drawText(g,State.C,40,115); 	// display input C
	    
	    setColor(g,State.D);
	    drawText(g,State.D,40,155); 	// display input D
	    
	    setColor(g,State.a);
	    drawText(g,State.a,70,210); 	// display select a
	    
	    setColor(g,State.b);
	    drawText(g,State.b,103,210); 	// display select b
	}

	/**
	 * @param g
	 */
	private void drawText(GraphicsContext g,State state,int x, int y) 
	{
		g.fillText(this.model.isBitStatus(state)? "1":"0",x,y);
	}
	/**
	 * This method is for setting color of the bits depending on its state, if bit status is 0 then make it Black, else Green 
	 * @param g
	 * @param state
	 */
	private void setColor(GraphicsContext g, State state)
	{
		if(this.model.isBitStatus(state)) g.setFill(Color.GREEN); else g.setFill(Color.BLACK);
	}

}// end of class Multiplexer


