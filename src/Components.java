
public class Components {

	public Components Instance = null;
	
	public static char[][] board ;

	public static char turn;
	
	public static int position;
	
	public static char[] completedQuadrants;
		
	public Components(){
		board = new char[][]{{' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' '},
				{' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' '},
				{' ',' ',' ',' ',' ',' ',' ',' ',' '}};
		
		turn = 'O';
		
		Components.completedQuadrants = new char[]{' ',' ',' ',' ',' ',' ',' ',' ',' '};
		
		Components.position = -1;
	}
	
	
	public void addToken(int x, int y){
		
		board[x][y] = turn;
		
	}
	
	public static char setTurn(char token){
		if(token == 'X'){
			return 'O';
		}
		else return 'X';
		
	}
	
	public static String charToString(char c){
		String s = "";
		s += c;
		return s;
	}
	public static boolean didOWin(char[] b){
		if((b[0] == 'O' && b[1] == 'O' && b[2] == 'O') || (b[3] == 'O' && b[4] == 'O' && b[5] == 'O') || (b[6] == 'O' && b[7] == 'O' && b[8] == 'O') || (b[0] == 'O' && b[3] == 'O' && b[6] == 'O')
				|| (b[1] == 'O' && b[4] == 'O' && b[7] == 'O') || (b[2] == 'O' && b[5]  == 'O'&& b[8] == 'O') || (b[0] == 'O' && b[4] == 'O' && b[8] == 'O') 
				|| (b[2] == 'O' && b[4] == 'O' && b[6] == 'O')){return true;}
			
		return false;
		
	}
	
	public static boolean didXWin(char[] b){
		if((b[0] == 'X' && b[1] == 'X' && b[2] == 'X') || (b[3] == 'X' && b[4] == 'X' && b[5] == 'X') || (b[6] == 'X' && b[7] == 'X' && b[8] == 'X') || 
				(b[0] == 'X' && b[3]  == 'X'&& b[6] == 'X')	|| (b[1]  == 'X'&& b[4] == 'X' && b[7] == 'X') || 
				(b[2] == 'X' && b[5] == 'X' && b[8] == 'X') || (b[0]  == 'X'&& b[4] == 'X' && b[8] == 'X') || (b[2] == 'X' && b[4]  == 'X'&& b[6] == 'X')){return true;}
			
		return false;
		
	}
	
}
