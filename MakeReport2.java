import java.util.Date;
import java.util.ArrayList;

public class MakeReport2 
{
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
		System.out.println(sum);
	}
}
