package Player;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import Common.Display;
import Music.BackGroundMusic;
import game.Camera;

public class SpecialFeatures {
	public static boolean flag=true;//for initializing only once
	public static int x,y;
	public static int xSpeed;
	int ySpeed;
//Mplayer has special features
	Image fire;
	
	
	public SpecialFeatures() {
	fire=new ImageIcon(Mplayer.class.getResource("fire.png")).getImage();
	ySpeed=18;
		
	}
	public void fire(Graphics2D g,int y){
		 if(flag)
		{this.initialise(y);
		}
	    g.drawImage(fire,x,SpecialFeatures.y,18,18,null);
			if(SpecialFeatures.y>Mplayer.FLOOR+64||SpecialFeatures.y<Mplayer.y+20)
				ySpeed*=-1;
		x=move(x,xSpeed);
		SpecialFeatures.y=move(SpecialFeatures.y,ySpeed);
		
		if(Display.FIRE-(int)Display.TIME>1)
		{Mplayer.isFire=false;
		flag=true;}
		
	}
	int move(int coordinate,int speed){
		coordinate+=speed;
		return coordinate;
	}
	void initialise(int y){
		//BackGroundMusic.playMarioFire();                                       //music
	
		this.y=y+25;
		if(Mplayer.xSpeed>0)
		{xSpeed=30;
		x=Mplayer.x+60;
		}
		else
			{
				xSpeed=-30;
				x=Mplayer.x+10;
				}
		flag=false;
	}
}
