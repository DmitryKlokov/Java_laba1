import java.util.Date;
import java.util.ArrayList;

public class MakeReport2 implements IMakeReport<Report2>
{
	@Override
	public Report2 MakeReport(ArrayList<Logs> list, Date  fromDate, Date toDate,Report2 report)
	{
		int sum = 0;
		
		for(Logs element: list)
		{
			if(element.getData().after(fromDate) && element.getData().before(toDate))
			{
				sum+=element.getBytes();
			}
		}
		report.sum = sum;
		return report;
	}
}
