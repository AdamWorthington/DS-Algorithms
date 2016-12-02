public class SquareRoot{
	public int findSquareRoot(int square){
		return fsrHelper(square, square);
	}
	private int fsrHelper(int curr, int num){
		int half = curr/2;
		if(curr * curr == num){
			return curr;
		}
		else if(curr*curr < num){
			return -1;
		}
		else{
			return fsrHelper(half, num);
		}
	}

}