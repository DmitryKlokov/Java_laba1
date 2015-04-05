import java.util.ArrayList;
import java.util.Date;

public interface IMakeReport<T>
{
	public T MakeReport(ArrayList<Logs> list, Date  fromDate, Date toDate, T report);
}
