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
		  System.out.print("\n\nReport "+args[2]+"\n");
		  switch(args[2])
		  {
			  case "1":
			  {
				  IMakeReport<Report1> report = new MakeReport1();
				  report.MakeReport(f.pars,fromDate,toDate);
				  Report1 rep = report.ReturnReport();
				  System.out.println(rep.list1);
				  break;
			  }
			  case "2":
			  {  
				  IMakeReport<Report2> report = new MakeReport2();
				  report.MakeReport(f.pars,fromDate,toDate);
				  Report2 rep = report.ReturnReport();
				  System.out.println(rep.sum);
				  break;
			  }
			  case "3":
			  {
				  IMakeReport<Report3> report = new MakeReport3();
				  report.MakeReport(f.pars,fromDate,toDate);
				  Report3 rep = report.ReturnReport();
				  System.out.println(rep.l.getBytes()+" : "+ rep.l.getRequest());
				  break;
			  }
			  default:{System.out.print("Error" );break;}
		  }
		 
	  }
}