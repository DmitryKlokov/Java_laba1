import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reader implements IReader
{
	@SuppressWarnings("finally")
	public  ArrayList<String> read_file (String address,int up,int down)
	  {
		ArrayList<String> strs= new ArrayList<String>();
		  try( BufferedReader myfile=new BufferedReader ( new FileReader(address)))
		  {
			  int count=0;
			  while((myfile.readLine() )!=null && count< up)//������� �����
			  {
				  count++;
			  }			  
			  
			  String str=null;
			  while((str=myfile.readLine() )!=null && up<count+down)
			  {
				  up++;
				  try
				  { 
					  strs.add(str);
				  }
				  catch(ArrayIndexOutOfBoundsException ex){System.out.println("ArrayIndexOutOfBoundsException � ������ "+up);}
				  
				  catch(StringIndexOutOfBoundsException ex){System.out.println("StringIndexOutOfBoundsException � ������ "+up);}
			  }	
		  }
		  catch(FileNotFoundException ex){}
		  catch(IOException ex){}	
		  finally
		  {
			  return strs;
		  }
	  }
	
}