
import javax.swing.JButton;

public class Panel {

	private JButton b;
	private int xPos;
	private int yPos;
	private int boardNumber;
	private int nextPosition;
	
	public Panel(JButton b, int xPos, int yPos, int boardNumber, int nextPosition){
		this.b = b;
		this.xPos = xPos;
		this.yPos = yPos;
		this.boardNumber = boardNumber;
		this.nextPosition = nextPosition;
	}
	public int getNextPosition(){
		return nextPosition;
	}
	
	public JButton getButton(){
		return b;
	}
	
	public void setButton(JButton b){
		this.b = b;
	}
	public int getXPos(){
		return xPos;
	}
	
	public void setXPos(int xPos){
		this.xPos = xPos;
	}
	public int getYPos(){
		return yPos;
	}
	
	public void setYPos(int yPos){
		this.yPos = yPos;
	}
	public int getBoardNumber(){
		return boardNumber;
	}
	
	public void seBoardNumber(int boardNumber){
		this.boardNumber = boardNumber;
	}
	
	
}

