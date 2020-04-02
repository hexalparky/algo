import java.util.Arrays;

public class kmp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] lps = build_lps("anana#banana");
		System.out.println(Arrays.toString(lps));
		
		
	}
	
	
	//returns the longest suffix prefix array of a string
	private static int[] build_lps(String str)
	{
		int len = str.length();
		int[] lps = new int[len];
		//index of next character being looked at
		int i = 1;
		//length of the current longest proper suffix prefix
		int j = 0;
		//lps[0] always 0, start from i loop until end of string
		while(i < len)
		{
			//found a matching character, continue building the current longest pre/suf
			if(str.charAt(i) == str.charAt(j))
				lps[i++] = ++j;
			else
			{
				if(j == 0)
					lps[i++] = 0;
				//not matching and current longest is not 0, find next longest pre/suf within itself
				//will return to here and continually reduce itself if charAt i != j
				else
					j = lps[j - 1];
			}
		}
		
		return lps;
		
	}

}
