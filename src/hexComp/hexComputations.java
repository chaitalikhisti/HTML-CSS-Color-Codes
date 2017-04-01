package hexComp;

public class hexComputations 
{
	public String[] strArray = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
	public String a = "0"; public String b = "0"; public String c = "0";
	public String d = "0"; public String e = "0"; public String f = "0";
	public int tempIntA, tempIntB, tempIntC, tempIntD, tempIntE;
	public String outputString;
	
	public String hexComp(int givenI)
	{
		/* for 0 to 15, values of F vary from 0 to F */
		if (0 <= givenI && givenI <= 15)
		{
			f = setF(givenI);
		}
		/* for 16 to 31, values of E vary from 0 to F and so do values of F */
		if (16 <= givenI && givenI <= 255)
		{
			tempIntE = 1;
			e = setE(givenI);
			int convertIntF = givenI % 16;
			f = setF(convertIntF);
		}
		/* for 256 to 4095, values of D vary from 0 to F and so do values of E and F */
		if (256 <= givenI && givenI <= 4095)
		{
			tempIntD = 1;
			d = setD(givenI);
			int convertIntE = givenI % 256;
			tempIntE = 0;
			e = setE(convertIntE);
			int convertIntF = givenI % 16;
			f = setF(convertIntF);			
		}
		/* for 4096 to 65535, values of C vary from 0 to F and so do values of D, E and F */
		if (4096 <= givenI && givenI <= 65535)
		{
			tempIntC = 1;
			c = setC(givenI);
			int convertIntD = givenI % 4096;
			tempIntD = 0;
			d = setD(convertIntD);
			int convertIntE = givenI % 256;
			tempIntE = 0;
			e = setE(convertIntE);
			int convertIntF = givenI % 16;
			f = setF(convertIntF);			
		}
		/* for 65536 to 1048575, values of B vary from 0 to F and so do values of C, D, E and F */
		if (65536 <= givenI && givenI <= 1048575)
		{
			tempIntB = 1;
			b = setB(givenI);
			int convertIntC = givenI % 65536;
			tempIntC = 0;
			c = setC(convertIntC);
			int convertIntD = givenI % 4096;
			tempIntD = 0;
			d = setD(convertIntD);
			int convertIntE = givenI % 256;
			tempIntE = 0;
			e = setE(convertIntE);
			int convertIntF = givenI % 16;
			f = setF(convertIntF);			
		}
		/* for 1048575 to 16777215, values of A vary from 0 to F and so do values of B, C, D, E and F */
		if (1048576 <= givenI && givenI <= 16777215)
		{
			tempIntA = 1;
			a = setA(givenI);
			int convertIntB = givenI % 1048576;
			tempIntB = 0;
			b = setB(convertIntB);
			int convertIntC = givenI % 65536;
			tempIntC = 0;
			c = setC(convertIntC);
			int convertIntD = givenI % 4096;
			tempIntD = 0;
			d = setD(convertIntD);
			int convertIntE = givenI % 256;
			tempIntE = 0;
			e = setE(convertIntE);
			int convertIntF = givenI % 16;
			f = setF(convertIntF);			
		}
		/* outputString = "hex = #"+a+b+c+d+e+f; */
		outputString = a+b+c+d+e+f;
		return outputString;	
	}
	
	public String setA(int forA)
	{
		if ((forA/1048576) == tempIntA)
		{
			if(tempIntA <= 15)
			{
				a = strArray[tempIntA];
				//System.out.println("forA: " +forA+ " tempIntA : " +tempIntA+ " & a = strArray[tempIntA] = " +a);
			}
		}
		else
		{
			tempIntA++;
			a = setA(forA);
		}
		return a;
	}
	
	public String setB(int forB)
	{
		if ((forB/65536) == tempIntB)
		{
			if(tempIntB <= 15)
			{
				b = strArray[tempIntB];
				//System.out.println("forB: " +forB+ " tempIntB : " +tempIntB+ " & b = strArray[tempIntB] = " +b);
			}
		}
		else
		{
			tempIntB++;
			b = setB(forB);
		}
		return b;
	}
	
	public String setC(int forC)
	{
		if ((forC/4096) == tempIntC)
		{
			if(tempIntC <= 15)
			{
				c = strArray[tempIntC];
				//System.out.println("forC: " +forC+ " tempIntC : " +tempIntC+ " & c = strArray[tempIntC] = " +c);
			}
		}
		else
		{
			tempIntC++;
			c = setC(forC);
		}
		return c;
	}
	
	public String setD(int forD)
	{
		if ((forD/256) == tempIntD)
		{
			if(tempIntD <= 15)
			{
				d = strArray[tempIntD];
				//System.out.println("forD: " +forD+ " tempIntD : " +tempIntD+ " & d = strArray[tempIntD] = " +d);
			}
		}
		else
		{
			tempIntD++;
			d = setD(forD);
		}
		return d;
	}
	
	public String setE(int forE)
	{
		if ((forE/16) == tempIntE)
		{
			if(tempIntE <= 15)
			{
				e = strArray[tempIntE];
				//System.out.println("forE: " +forE+ " & e = tempIntE = " +tempIntE);
			}
		}
		else
		{
			tempIntE++;
			e = setE(forE);
		}
		return e;
	}
	
	public String setF(int forF)
	{
		f = strArray[forF];
		//System.out.println("forF: " +forF+ " & f = "+f);
		return f;
	}
	/*
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		hexComputations hex = new hexComputations(16777215);
	}
	*/
}
