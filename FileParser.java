import java.util.ArrayList;

public class FileParser implements IFileParser 
{
	private IParser parser;
	private IWriter writer;
	public ArrayList<Logs> pars = new ArrayList<Logs>();
	public FileParser(IParser parser, IWriter writer )
	{
		this.parser = parser;
		this.writer = writer;
	}
	public void parse(String args1, String args2,String args3)
	{
		IReader reader = new Reader();
		ArrayList<String> text= reader.read_file(args3, Integer.parseInt(args1), Integer.parseInt(args2) );
		pars = parser.parsing(text);
		writer.recordWrite("c:/учеба/test.txt", pars); 		
	}
}