package different;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import Common.Display;
import Common.gameConstants;
import Music.BackGroundMusic;
import Player.Mplayer;

public class CoinsAdditional {
	int x;
	int y;
	int ySpeed=-35;
	boolean isTaken,isVisible=true;
	Image image;

	public CoinsAdditional(int x,int y){
		this.x=x;
		this.y=y;
		image=new ImageIcon(Mplayer.class.getResource("coins.gif")).getImage();
	}

	public void drawCoins(Graphics2D g){
		
		if(isVisible){
			g.drawImage(image, this.x, this.y,50,50,null);
		}
		if(!this.isTaken)
		{
		this.collision(Mplayer.x+25, Mplayer.y+25, this.x, this.y);}
		else{
			rise();
		}
	}

	void collision(int marioX,int marioY,int coinX,int coinY){
		if(Math.abs(marioX-coinX)<50&&Math.abs(marioY-coinY)<100){
			//BackGroundMusic.playCoin();                                       music
			Display.SCORE+=100;
			Display.COINS++;
			this.isTaken=true;	
		}
	}
	void rise(){
		if(this.y>gameConstants.InPipeBrickFloor-70)
		{ySpeed+=gameConstants.GRAVITY;
		this.y+=ySpeed;
		}
		else{
			isVisible=false;
		}
	}
	
}
