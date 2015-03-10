package java_laba1;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class analyzise 
{
	  public static void Parsing(String str)
	  {
		  String[] p=str.split(" ");
		  Logs a = new Logs();
		  a.setHost(p[0]);
	      Date data = null;
	      SimpleDateFormat formate = new SimpleDateFormat("[dd/MMM/yyyy:HH:mm:ssZ]",Locale.ENGLISH);
		  try 
		  {
			data = formate.parse(p[3]+p[4]);
		  } 
		  catch (ParseException e) 
		  {
			e.printStackTrace();
		  }
		  a.setData(data);
		  
		  try
		  {
			  a.setReply(Integer.parseInt(p[p.length-2]));
		  }
		  catch(NumberFormatException ex){a.setReply(0);}
		  
		  try
		  {
			  a.setBytes(Integer.parseInt(p[p.length-1]));
		  }
		  catch(NumberFormatException ex){a.setBytes(0);}
		  
		  String req = "";
		  for(int i=5;i<p.length-2;i++)
		  {
			  req+=p[i]+" ";
		  }
		  a.setRequest(req.substring(1, req.length()-2));
		  pars_list.add(a);
	  }	

	  public static ArrayList<Logs> pars_list = new ArrayList<Logs>();
	  
	  public static void read(String address,int up,int down)
	  {
		 
		  try( BufferedReader myfile=new BufferedReader ( new FileReader(address)))
		  {
			  int count=0;
			  while((myfile.readLine() )!=null && count< up)//пропуск строк
			  {
				  count++;
			  }			  
			  
			  String str=null;
			  while((str=myfile.readLine() )!=null && up<count+down)
			  {
				  up++;
				  try{ Parsing(str);}
				  catch(ArrayIndexOutOfBoundsException ex){System.out.println("ArrayIndexOutOfBoundsException в строке "+up);}
				  
				  catch(StringIndexOutOfBoundsException ex){System.out.println("StringIndexOutOfBoundsException в строке "+up);}
			  }	
		  }
		  catch(FileNotFoundException ex){}
		  catch(IOException ex){}	
	  }

	  public static void Show()
	  {
		  for(int i=0;i<pars_list.size();i++)
		  {	
		  System.out.println(pars_list.get(i).getHost()+" ^ "+pars_list.get(i).getData()+" ^ "+pars_list.get(i).getRequest()+" ^ "+pars_list.get(i).getReply()+" ^ "+pars_list.get(i).getBytes());
		  }
	  }

	  public static void write(String address)
	  {
		  for(int i=0;i<pars_list.size();i++)
		  {	   
			  try(BufferedWriter myfile = new BufferedWriter(new FileWriter(address)))
			  {
				  myfile.write(pars_list.get(i).getHost()+" "+pars_list.get(i).getData()+" "+pars_list.get(i).getRequest()+" "+pars_list.get(i).getReply()+" "+pars_list.get(i).getBytes()+"\r\n");  
			  } 
			  catch (IOException e) {}
		  }		  
	  }
	  
	  public static void main(String[] args) 
	  {
		  System.out.print("\n\n");
		  
		  read("c:/access_log_Aug95",Integer.parseInt(args[0]),Integer.parseInt(args[1]));
		  
		  write("c:/универ/test.txt");
		//  Show();
		  
		  System.out.print("\n\nконец" );
	  }
}
	

