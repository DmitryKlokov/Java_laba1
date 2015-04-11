

public class MakeReport3 implements IMakeReport<Report3,Params>
{
	@Override
	public Report3 MakeReport(Params param)
	{	
		Report3 report = new Report3();
		Logs log = new Logs();
		int max=0;
		for(Logs element: param.list)
		{
			if(element.getData().after(param.fromDate) && element.getData().before(param.toDate)&&max<element.getBytes())
			{
				max = (int) element.getBytes();
				log = element;
			}
		}
		report.log = log;
		return report;
	}
}
