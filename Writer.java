import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Writer implements IWriter
{
	public void recordWrite(String address, ArrayList<Logs> pars_list)
	  {		  	   
			  try(BufferedWriter myfile = new BufferedWriter(new FileWriter(address)))
			  {
				  for(int i=0;i<pars_list.size();i++)
				  {
					  myfile.write(pars_list.get(i).getHost()+" "+pars_list.get(i).getData()+" "+pars_list.get(i).getRequest()+" "+pars_list.get(i).getReply()+" "+pars_list.get(i).getBytes()+"\r\n"); 
				  }
			  } 
			  catch (IOException e) {}	  
	  }
}