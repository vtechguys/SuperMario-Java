package game;

import java.awt.Toolkit;

import javax.swing.JFrame;

import Common.gameConstants;
import Music.BackGroundMusic;



public class gameFrame extends JFrame implements gameConstants{
	public gameFrame() {
		setTitle("Super Mario");
		setVisible(true);
		setSize(GWIDTH, GHEIGHT);
		setLocationRelativeTo(null);
		setResizable(false);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void LoadBoard()
	{
		Board board=new Board();
		this.add(board);
		board.bindEvent();
	}

	public static void main(String[] args) {
	
		// TODO Auto-generated method stub
          gameFrame game=new gameFrame();
      	Toolkit.getDefaultToolkit().sync();
      //BackGroundMusic.mp31.play();
    //  BackGroundMusic.mp31.setRepeat(true);
          game.LoadBoard();
       
	}

}
