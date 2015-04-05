import java.util.ArrayList;
import java.util.Date;

public class MakeReport3 
{
	public void MakeReport(ArrayList<Logs> list, Date  fromDate, Date toDate)
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
		System.out.println("size "+max+" : "+l.getRequest());
	}
}
