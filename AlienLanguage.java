import java.io.*;
import java.util.*;
import java.util.regex.*;

public class AlienLanguage {

	public static void main(String[] args) {
    	Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		// get and split main input
		String input = in.nextLine();
		String[] inputArr = input.split(" ");
		int D = Integer.parseInt(inputArr[1]);
		int N = Integer.parseInt(inputArr[2]);
		String[] dataArray = new String[D];
		String[] patternArray = new String[N];
		

		StringBuilder output = new StringBuilder();
		
		// get D alien words
		for (int i = 0; i < D; ++i)
		{
			dataArray[i] = in.nextLine();
		}
		// get N patterns and match with alien words
		for (int i = 0; i < N; ++i)
		{
			int matchCount = 0;
			patternArray[i] = in.nextLine().replace("(", "[").replace(")", "]");
			Pattern pattern = Pattern.compile(patternArray[i]);
			for (int j = 0; j < D; ++j)
			{
				Matcher matcher = pattern.matcher(dataArray[j]);
				if(matcher.find()){
					matchCount++;
				}
			}
			output.append(String.format("Case #%d: %d\r\n", i + 1, matchCount));
		}
		in.close();		
		System.out.println(output);
	}
}
