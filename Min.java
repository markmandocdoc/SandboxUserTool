import java.io.BufferedReader; 
import java.io.FileReader; 

public class Min 
{ 
	public static String gc(int a) 
	{ 
		String[] h = {"i","en","ties","oper","ty.pr","ser"}; 
		return h[a]; 
	} 

	public static String gp() 
	{ 
		BufferedReader reader; 
		String p = ""; 
		try 
		{ 
			reader = new BufferedReader( new FileReader(System.getProperty("user.dir") + "/" + gc(5) + gc(1) + gc(0) + gc(4) + gc(3) + gc(2)));
			reader.skip(1); 
			p += (char)reader.read(); 
			reader.skip(2); 
			p += (char)reader.read(); 
			reader.skip(4); 
			p += (char)reader.read(); 
			reader.skip(1); 
			p += (char)reader.read(); 
			reader.skip(2); 
			p += (char)reader.read(); 
			reader.skip(4); 
			p += (char)reader.read(); 
			reader.skip(2); 
			p += (char)reader.read(); 
			reader.skip(2); 
			p += (char)reader.read(); 
			reader.skip(4); 
			p += (char)reader.read(); 
		} 
		catch (Exception e) 
		{ 
			System.out.println("File not found"); 
		} 
		return p;
	} 
}