
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class analyzise
{ 
	public static void main(String[] args)
	  {
		  IParser parser =  new Parser();
		  IWriter writer = new Writer();
		  
		  FileParser fp = new FileParser(parser , writer);		  
		  fp.parse(args[0], args[1],args[2]);
		  
		  SimpleDateFormat formate = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ssZ",Locale.ENGLISH);
		  
		  Params par = new Params();
		  
		  try 
		  {
			  System.out.println("Input Date (01/Aug/1995:00:00:12-0400)");
			  Scanner in = new Scanner(System.in);
			  par.fromDate = formate.parse( in.nextLine() );
			  System.out.print("Input Date (10/Aug/1995:00:00:12-0400)");
			  par.toDate =   formate.parse(in.nextLine()); 
			  
		  } 
		  catch (ParseException e) 
		  {
			e.printStackTrace();		 
		  }
		  System.out.print("\n\nReport "+args[2]+"\n");
		  par.list = fp.pars;
		  switch(args[3])
		  {
			  case "1":
			  {
				  Report1 rep = new Report1();
				  IMakeReport<Report1,Params> report = new MakeReport1();
				  rep = report.MakeReport(par);
				  System.out.println(rep.list);
				  break;
			  }
			  case "2":
			  {  
				  Report2 rep = new Report2();
				  IMakeReport<Report2,Params> report = new MakeReport2();
				  rep = report.MakeReport(par);
				  System.out.println(rep.sum);
				  break;
			  }
			  case "3":
			  {
				  Report3 rep = new Report3();
				  IMakeReport<Report3,Params> report = new MakeReport3();
				  rep = report.MakeReport(par);
				  System.out.println(rep.log.getBytes()+" : "+ rep.log.getRequest());
				  break;
			  }
			  default:{System.out.print("Error" );break;}
		  }
		 
	  }
}