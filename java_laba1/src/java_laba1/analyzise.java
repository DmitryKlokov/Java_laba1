package java_laba1;
import java.util.Scanner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;


public class analyzise 
{
	  public static void main(String[] args) 
	  {
		  int up = Integer.parseInt(args[0]);
		  int down = Integer.parseInt(args[1]);
		  System.out.print("\n\n");
		  
		  BufferedReader myfile;
		  try
		  {
			  myfile = new BufferedReader ( new FileReader("c:/access_log_Aug95"));
			  int count=0;
			  while((myfile.readLine() )!=null && count< up)//пропуск строк
			  {
				  count++;
			  }				  
			  
			  String str=null;
			  while((str=myfile.readLine() )!=null && up<count+down)
			  {
				  up++;
				  System.out.print(str+"\n");
			  }	
		  }
		  catch(FileNotFoundException ex){}
		  catch(IOException ex){}
		  System.out.print("\n\nконец" );
	  }
}
	

