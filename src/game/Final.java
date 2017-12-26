package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import Common.gameConstants;
import Music.BackGroundMusic;
import Player.Mplayer;

public class Final {
	int x,y;
	int speed;
	Image flag;
	boolean isFlagFall,flagSound,temp;
	Final(){
		this.x=10520;
		//this.y=75;
		this.y=75;
		flagSound=true;
		flag= new ImageIcon(Mplayer.class.getResource("flag.png")).getImage();
	}
	void flagFall(){
	this.y+=16;	
	}
    void marioMove(){
    	if(Mplayer.x<380)
    	Mplayer.x+=4;
    	else {
    	Mplayer.isNotVisible=true;
    	}
    }
	void drawFlag(Graphics2D g){
		g.drawImage(flag,x,y,50,50,null);
		if(Camera.x>(3840-(gameConstants.IMAGE_WIDTH)-gameConstants.CAMERA_SPEED)){
			Mplayer.isReachedEnd=true;
			if(this.y<467){
				if(flagSound){
			//		BackGroundMusic.playFlagPole();
					flagSound=false;
				}
				flagFall();
			}
			else {isFlagFall=true;}
			
			if(isFlagFall){
				if(!temp)
				{	//BackGroundMusic.mp31.stop();                             //music
			//	BackGroundMusic.playLevelComplete();
				this.temp=true;}
				marioMove();
			}
			
		}
	}
	
	
	public void left(int camSpeed){
		if(Camera.isStop==false)
		{speed=(Math.abs(camSpeed)+8);
		}
		else{
			speed=0;
		}
		move();
		
	}
	private void move() {
		x+=speed;
		
	}

	public void right(int camSpeed){
	   if(Camera.isStop==false)
		{speed=-(camSpeed+8);}
	      else{
		   speed=0;
	   }
		move();
		
	}
	
	

	
	
}
