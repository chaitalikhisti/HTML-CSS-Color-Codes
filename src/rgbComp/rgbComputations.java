package rgbComp;

public class rgbComputations 
{
	int r, g, b = 0;
	int convertInt;
	int tempIntG;
	int tempIntR;
	String outputString;
	
	public String rgbComp(int convertInt)
	{
		//convertInt = givenI / 2;
		//System.out.println("iteration i = " +convertInt);
		/* Since we are considering operations at only even numbers, we have to take twice the limits */
		/* for 0 to 255 : only b varies from 0 to 255 (inclusive) */
		if (0 <= convertInt && convertInt <=  255)
		{
			b = setB(convertInt);
		}
		/* for 256 to 65535 : g varies from 0 to 255 (inclusive) and so does b */
		if (256 <= convertInt && convertInt <= 65535)
		{
			tempIntG = 1;
			g = setG(convertInt);
			int convertIntB = convertInt % 256;
			//System.out.println("convertIntB = " +convertIntB);
			b = setB(convertIntB);
		}
		/* for 65536 to 16777215 : r varies from 0 to 255 (inclusive) and so do g and b */
		if (65536 <= convertInt && convertInt <= 16777215)
		{
			tempIntR = 0;
			r = setR(convertInt);
			int convertIntG = convertInt % 65536;
			tempIntG = 0;
			g = setG(convertIntG);
			int convertIntB = convertInt % 256;
			//System.out.println("convertIntB = " +convertIntB);
			b = setB(convertIntB);
		}
		/* outputString = "(r, g, b): (" +r+", "+g+", "+b+")"; */
		outputString = "(" +r+", "+g+", "+b+") |";
		return outputString;
	}
	
	public int setR(int forR)
	{
		if(0<= tempIntR && tempIntR <= 255)
		{
			tempIntR++;
			if ((forR/65536) == tempIntR)
			{
				r = tempIntR;
				//System.out.println("forR: " +forR+ " & r = tempIntR = " +tempIntR);
			}
			else
			{
				tempIntR++;
				r = setR(forR);
			}
		}
		return r;
	}
	
	public int setG(int forG)
	{
		if ((forG/256) == tempIntG)
		{
			if(tempIntG <= 255)
			{
				g = tempIntG;
				//System.out.println("forG: " +forG+ " & g = tempIntG = " +tempIntG);
			}
		}
		else
		{
			tempIntG++;
			g = setG(forG);
		}
		return g;
	}
	
	public int setB(int forB)
	{
		if (0 <= forB && forB <=  255)
		{
			b = forB;
			//System.out.println("forB: " +forB+ " & b = forB = " +b);
		}
		return b;
	}
	/*
	public static void main(String[] args) 
	{
		rgbComputations rgb = new rgbComputations(16777215*2);
	}
	*/
}
