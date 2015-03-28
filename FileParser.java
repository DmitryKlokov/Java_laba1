package java_laba1;

import java.util.ArrayList;

public class FileParser implements IFileParser 
{
	private IParser parser;//  = new Parser();
	private IWriter writer; // = new Writer();
	public FileParser(IParser parser, IWriter writer )
	{
		this.parser = parser;
		this.writer = writer;
	}
	public void parse(String args1, String args2)
	{
		IReader reader = new Reader();
		ArrayList<String> text= reader.read_file("c:/access_log_Aug95", Integer.parseInt(args1), Integer.parseInt(args2) );
		ArrayList<Logs> pars = parser.parsing(text);
		writer.recordWrite("c:/универ/test.txt", pars); 		
	}
}
