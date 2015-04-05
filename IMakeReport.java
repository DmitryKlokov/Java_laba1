import java.util.ArrayList;
import java.util.Date;

public interface IMakeReport<T>
{
	public void MakeReport(ArrayList<Logs> list, Date  fromDate, Date toDate);
	public T ReturnReport();
}
