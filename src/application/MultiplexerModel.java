package application;

import java.util.BitSet;

/**
*
*@author Bandile Danxa
*/
public class MultiplexerModel
{
	private static final int N_BITS = 7;
	private BitSet mulplx = new BitSet(N_BITS);
	
	/**
	 * 
	 */
	public void toggleBit(State bit) 
	{
		if(bit != State.Q) 
		{// Q shouldn't be changed. It's however inputs depended.
			mulplx.flip(bit.ordinal());  
		}
		setOutput();
	}
	
	/**
	 * 
	 * @param firstBit
	 * @param secBit
	 * @return
	 */
	public boolean AND(State firstBit, State secBit)
	{
		return mulplx.get(firstBit.ordinal()) & mulplx.get(secBit.ordinal());
	}
	
	/**
	 * 
	 * @param firstBit
	 * @param bool
	 * @param secBit
	 * @return
	 */
	public boolean AND(State firstBit, boolean bool, State secBit)
	{
		return mulplx.get(firstBit.ordinal()) & mulplx.get(secBit.ordinal()) & bool;
	}
	
	/**
	 * 
	 * @param firstBit
	 * @param bool
	 * @param secBit
	 * @return
	 */
	public boolean AND(boolean firstBit, boolean bool, State secBit) 
	{
		return firstBit & mulplx.get(secBit.ordinal()) & bool;
	}
	
	 /* 
	 * @param firstBit
	 * @param secBit
	 * @param thirdBit
	 * @return
	 */
	public boolean AND(State firstBit, State secBit,State thirdBit)
	{
		return mulplx.get(firstBit.ordinal()) & mulplx.get(secBit.ordinal()) & mulplx.get(thirdBit.ordinal());
	}
	
	/**
	 * 
	 * @param firstBit
	 * @param secBit
	 * @return
	 */
	public boolean AND(boolean firstBit, boolean secBit) 
	{
		return firstBit & secBit;
	}
	
	/**
	 * 
	 * @param bool
	 * @param secBit
	 * @return
	 */
	public boolean AND(boolean bool, State secBit) 
	{
		return bool & mulplx.get(secBit.ordinal());
	}
	
	/**
	 * 
	 * @param firstBit
	 * @param secBit
	 * @return
	 */
	public boolean OR(State firstBit, State secBit) 
	{
		return mulplx.get(firstBit.ordinal()) | mulplx.get(secBit.ordinal());
	}
	
	
	/**
	 * 
	 * @param firstBit
	 * @param secBit
	 * @return
	 */
	public boolean XOR(State firstBit, State secBit) 
	{
		return mulplx.get(firstBit.ordinal()) ^ mulplx.get(secBit.ordinal());
	}
	
	/**
	 * 
	 * @param bit
	 * @return
	 */
	public boolean NOT(State bit) 
	{
		return !mulplx.get(bit.ordinal());
	}
	
	/**
	 * 
	 * @param first
	 * @param sec
	 * @return
	 */
	public boolean NOT(State first,State sec) 
	{
		return !mulplx.get(first.ordinal()) & !mulplx.get(sec.ordinal());
	}
	
	/**
	 * 
	 * @param bool
	 * @return
	 */
	public boolean NOT(boolean bool) 
	{
		return !bool;
	}
	
	/**
	 * 
	 * @param firstBit
	 * @param secBit
	 * @return
	 */
	public boolean NAND(State firstBit, State secBit) 
	{
		return !AND(firstBit,secBit);
	}
	
	/**
	 * 
	 * @param firstBit
	 * @param secBit
	 * @return
	 */
	public boolean NOR(State firstBit, State secBit) 
	{
		return !OR(firstBit,secBit);
	}
	
	/**
	 * 
	 * @param firstBit
	 * @param secBit
	 * @return
	 */
	public boolean XNOR(State firstBit, State secBit) 
	{
		return !XOR(firstBit,secBit);
	}

	/**
	 * 
	 */
	private void setOutput() 
	{
		mulplx.set(State.Q.ordinal(),(AND(NOT(State.a),NOT(State.b),State.A)) | 
				(AND(State.b,NOT(State.a) ,State.B)) | 
				(AND(State.a, NOT(State.b), State.C)) | 
				(AND(State.a,State.b,State.D)));
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isBitStatus(State bit)
	{
		return mulplx.get(bit.ordinal()); 
	}
	
	/**
	 * 
	 */
	public void resetAdder()
	{
	  mulplx.clear();
	}

}
