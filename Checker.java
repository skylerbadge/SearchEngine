import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Checker
{
	public static void main ( String args [])
	{
		BufferedReader br = null;
		SearchEngine se = new SearchEngine();

		try {
			String actionString;
			br = new BufferedReader(new FileReader("actions.txt"));

			while ((actionString = br.readLine()) != null) {
				se.performAction(actionString);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
                //r.print();

	}
}