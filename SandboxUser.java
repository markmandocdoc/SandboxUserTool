import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class SandboxUser {

	/*********************Initialization Variables***********************/
	private static int sandboxId = 0;
	private static String toolUrl = "http://boxofmarkers.com/tools/whalerock/users/?";

	/********************************************************************
	 * Description: Generate current sandbox email
	 * Param: String t
	 * Returns: int sandbox ID
	 * Status: Complete
	 ********************************************************************/
	public static String getSandboxEmail(String t)
	{	
		String email = "qa-" + getSandboxId(t) + "@wri.com";
		System.out.println("Attempting to use Sandbox User: " + email);
		return email;
	}
	
	/********************************************************************
	 * Description: Get current sandbox ID from tool
	 * Param: String t
	 * Returns: int sandbox ID
	 * Status: Complete
	 ********************************************************************/
	public static int getSandboxId(String t)
	{
		URL tool;
		try
		{
			tool = new URL(toolUrl+"a=g&p="+Min.gp()+"&t="+t);
			BufferedReader in = new BufferedReader(new InputStreamReader(tool.openStream()));

			String inputLine;
			if ((inputLine = in.readLine()) != null)
			{
				sandboxId = Integer.parseInt(inputLine);
			}
			in.close();
		} 
		catch (Exception e)
		{
			System.out.println("Error: Could not get sandbox ID");
		}

		return sandboxId;
	}
	
	/********************************************************************
	 * Description: Move to next sandbox ID
	 * Param: String t
	 * Returns: int sandbox ID
	 * Status: Complete
	 ********************************************************************/
	public static boolean goToNextId(String t)
	{
		URL tool;
		try
		{
			tool = new URL(toolUrl+"a=p&t="+t+"&p="+ Min.gp());
			BufferedReader in = new BufferedReader(new InputStreamReader(tool.openStream()));
			in.close();
			System.out.println("Success! Moving to new sandbox user.");
		} 
		catch (Exception e)
		{
			System.out.println("Error: Could not connect to sandbox tool");
			return false;
		}

		return true;
	}
	
}