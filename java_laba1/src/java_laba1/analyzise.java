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
		  pars a = new pars();
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
		  a.setRequest(p[5].substring(1)+" "+p[6]+" "+p[7].substring(0, p[7].length()-1));
		  a.setReply(Integer.parseInt(p[8]));
		  a.setBytes(Long.parseLong(p[9]));
		  pars_list.add(a);
	  }	

	  public static ArrayList<pars> pars_list = new ArrayList<pars>();
	  
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
				  Parsing(str);
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
		  ArrayList<pars> uj = new ArrayList<pars>();
		  System.out.print("\n\n");
		  
		  read("c:/access_log_Aug95",Integer.parseInt(args[0]),Integer.parseInt(args[1]));
		  
		  write("c:/access_log_Aug95");
		  Show();
		  
		  System.out.print("\n\nконец" );
	  }
}
	

