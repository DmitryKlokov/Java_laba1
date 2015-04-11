
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


public class MakeReport1 implements IMakeReport<Report1,Params>
{	
	@Override
	public Report1 MakeReport(Params param)
	{
		Report1 report = new Report1();
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(Logs element: param.list)
		{
			if(element.getData().after(param.fromDate) && element.getData().before(param.toDate))
			{
				if(map.containsKey(element.getHost()))
				{
					map.put(element.getHost(), map.get(element.getHost())+1);
				}
				else
				{
					map.put(element.getHost(), 1);
				}
			}
		}
		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>();
		list.addAll(map.entrySet());
		
			
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>()
				{
			         @Override
			         public int compare(Map.Entry<String, Integer> el1, Map.Entry<String, Integer> el2)
			         {
			        	 return el2.getValue().compareTo(el1.getValue());
			         }
		        });
		if(list.size()>5)
		{
			while(list.size()>5)
			{
				list.remove(list.size()-1);
			}
		}
		report.list = list;
		return report;
	}
}
