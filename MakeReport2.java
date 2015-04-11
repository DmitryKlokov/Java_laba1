

public class MakeReport2 implements IMakeReport<Report2,Params>
{
	@Override
	public Report2 MakeReport(Params param)
	{
		Report2 report = new Report2();
		int sum = 0;
		
		for(Logs element: param.list)
		{
			if(element.getData().after(param.fromDate) && element.getData().before(param.toDate))
			{
				sum+=element.getBytes();
			}
		}
		report.sum = sum;
		return report;
	}
}
