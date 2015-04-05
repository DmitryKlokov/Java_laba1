import java.util.Date;
import java.util.ArrayList;

public class MakeReport2 implements IMakeReport<Report2>
{
	Report2 report = new Report2();
	@Override
	public void MakeReport(ArrayList<Logs> list, Date  fromDate, Date toDate)
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
	}
	@Override
	public Report2 ReturnReport()
	{
		return report;
	}
}
