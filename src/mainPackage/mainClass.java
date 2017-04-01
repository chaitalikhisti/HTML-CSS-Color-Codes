package mainPackage;

import java.io.*; //for file operations

import hexComp.hexComputations;
import rgbComp.rgbComputations;

public class mainClass 
{
	private static String str = " ";
	private static String str1 = "0, 1, 2, 3, 4, 5, 6, 7, 8, 9, A, B, C, D, E, F";
	private static String str2 = "0, 1, A";
	private static int r, g, b;
	private static int arrLength, totalComp;
	private static int a, c, d, e, f;
	private static File file;
	//private static BufferedWriter writer;
	private static PrintWriter out;
	
	
	public static void rgbCombinations() throws IOException
	{
		for (r = 0; r < 256; r++)
		{
			for (g = 0; g < 256; g++)
			{
				for (b = 0; b < 256; b++)
				{
					str = "(r, g, b): (" +r+", "+g+", "+b+")";
					//System.out.println(str);
					totalComp++;
				}
			}
		}
		System.out.println("Total Computations for rgbCombinations() : " +totalComp);
	}
	public static void hexCombinations() throws IOException
	{
		String[] strArray = str1.split(", ");
		//System.out.println(Arrays.toString(strArray));
		//System.out.println(strArray.length);
		arrLength = strArray.length;
		for (a = 0; a < arrLength; a++)
		{
			for (b = 0; b < arrLength; b++)
			{
				for (c = 0; c < arrLength; c++)
				{
					for (d = 0; d < arrLength; d++)
					{
						for (e = 0; e < arrLength; e++)
						{
							for (f = 0; f < arrLength; f++)
							{
								str = "strArray["+a+", "+b+", "+c+", "+d+", "+e+", "+f+"] : ";
								String tempStr = strArray[a]+strArray[b]+strArray[c]+strArray[d]+strArray[e]+strArray[f];
								str += tempStr;
								//System.out.println(str);
								totalComp++;
							}
						}
					}
				}
			}
		}
		System.out.println("Total Computations for hexCombinations() : " +totalComp);
	}
	
	public static void toFile(String writeToFile) throws IOException
	{
		/*
		file = new File("colors.txt");
		file.createNewFile();
		BufferedWriter colorWriter = new BufferedWriter(new FileWriter(file));
		colorWriter.write(writeToFile);
		colorWriter.newLine();
		//colorWriter.flush();
		colorWriter.close();
		*/
		/*
		// Create a BufferedWriter around a FileWriter.
        // ... Write to an output text file.
        writer = new BufferedWriter(new FileWriter("output.txt"));
        // Write these lines to the file.
        // ... We call newLine to insert a newline character.
        writer.write(writeToFile);
        writer.newLine();
        //writer.write("DOG");
        //writer.newLine();
        //writer.write("BIRD");
        //writer.close();
         */
		// Demonstrates standard code to write a text file.
		 // Given a filename, writes lines 0, 1, 2, ...999
		 // to a text file with that name.
		 try 
		 {
			 // Create a PrinterWriter for the file (built on BufferedWriter
			 // and FileWriter).
			 // (PrinterWriter responds to print() and println() like System.out)
			 file = new File("log.txt");
			out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
			 // Print the text we want to the file
			 for (int i=0; i<1000; i++) 
			 {
				 out.println(i);
			 }
			 //out.close();
		 }
		 catch (IOException except) 
		 {
			 except.printStackTrace();
		 }
	}
	
	public static void main(String[] args) throws IOException 
	{
		try 
		 {
			 file = new File("log.txt");
			out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
			/* for (int j = 0; j <= 16777215; j += 5) */
			for (int j = 0; j <= 1675; j += 5)				
			{
				rgbComputations rgb = new rgbComputations();
				String rgbString = rgb.rgbComp(j);
				hexComputations hex = new hexComputations();
				String hexString = hex.hexComp(j);
				String outputString = rgbString+ " " +hexString;
				//System.out.println(outputString);
				out.println(outputString);
			}
			out.close();
			System.out.println("Completed!");
		 }
		 catch (IOException except) 
		 {
			 except.printStackTrace();
		 }
	}
}
