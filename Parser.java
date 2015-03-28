package java_laba1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Parser implements IParser
{
	public ArrayList<Logs> parsing(ArrayList<String> strs)
	  {
		ArrayList<Logs> lgs = new  ArrayList<Logs>();
		for(int k=0;k<strs.size();k++)
		{
			  String[] p=strs.get(k).split(" ");
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
			  lgs.add(a);
		 }
		 return lgs;
	  }
}
