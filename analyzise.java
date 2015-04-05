import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class analyzise
{ 
	public static void main(String[] args)
	  {
		  System.out.print("\n\n");
		  IParser parser =  new Parser();
		  IWriter writer = new Writer();
		  
		  FileParser f = new FileParser(parser , writer);		  
		  f.parse(args[0], args[1]);
		  
		  Date fromDate =  null;
		  Date toDate = null;
		  SimpleDateFormat formate = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ssZ",Locale.ENGLISH);
		  try 
		  {
			  fromDate = formate.parse("01/Aug/1995:00:00:12-0400");
			  toDate =   formate.parse("01/Aug/1995:00:00:32-0400"); 
			  
		  } 
		  catch (ParseException e) 
		  {
			e.printStackTrace();		 
		  }
		  System.out.print("\n\nReport 1" );
		  MakeReport1 mr1 =  new MakeReport1();
		  mr1.MakeReport(f.pars,fromDate,toDate);
		  
		  System.out.print("\n\nReport 2: " );
		  MakeReport2 mr2 =  new MakeReport2();
		  mr2.MakeReport(f.pars,fromDate,toDate);
		  
		  System.out.print("\n\nReport 3: " );
		  MakeReport3 mr3 =  new MakeReport3();
		  mr3.MakeReport(f.pars,fromDate,toDate);
		  
		 
	  }
}