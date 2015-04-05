import java.util.ArrayList;
import java.util.Date;

public class MakeReport3 implements IMakeReport<Report3>
{
	@Override
	public Report3 MakeReport(ArrayList<Logs> list, Date  fromDate, Date toDate,Report3 report)
	{		
		Logs l = new Logs();
		int max=0;
		for(Logs element: list)
		{
			if(element.getData().after(fromDate) && element.getData().before(toDate)&&max<element.getBytes())
			{
				max = (int) element.getBytes();
				l = element;
			}
		}
		report.l = l;
		return report;
	}
}
