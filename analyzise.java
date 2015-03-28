package java_laba1;
public class analyzise
{ 
	public static void main(String[] args) 
	  {
		  System.out.print("\n\n");
		  IParser parser =  new Parser();
		  IWriter writer = new Writer();
		  
		  FileParser f = new FileParser(parser , writer);
		  f.parse(args[0], args[1]);
		  System.out.print("\n\nконец" );
	  }
}
	

