import java.util.*;
public class Reverse{
	public static void main(String[] args){
		String msg = "hi adam yo";
		char[] ia = msg.toCharArray();
		reverse(ia);
	}
	private static void reverse(char[] ia){
		String temp = "";
		String ret = "";
		for(char c : ia){
			temp = temp+c;
		}
		StringTokenizer st = new StringTokenizer(temp);
		int totalTokens = st.countTokens();
		for(int i = 0; i < totalTokens; i++){
			ret = st.nextToken() + " " + ret;
		}
		char[] charArray = ret.toCharArray();
		for(int j = 0; j < charArray.length; j++){
			System.out.print(charArray[j]);
		}
		System.out.println("");	
	}
}