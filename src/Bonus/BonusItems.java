package Bonus;

import java.awt.Graphics2D;

import Common.Display;
import Music.BackGroundMusic;
import Player.Mplayer;

public class BonusItems {	

   
	public static Coins coin;
	int animation[]={1805,2055,2168,4790,6145,6295,6445,9208,
			2105,5555,6295,7238,7288};
	public static boolean isTaken[]=new boolean[14];
	public void drawBonus(int x,int y,int w,int h,Graphics2D g,int i){
	if(i==2 && (!isTaken[i])){
		
		Rocket rocket=new Rocket() {                            //for the rocket
			
			@Override
			public void check(Graphics2D g) {
				g.drawImage(image, x,y-50,w,h,null);
				isTaken[i]=isCollision(Mplayer.x, x, Mplayer.y,y-50);
				if(isTaken[i])
				Mplayer.isFly=true;
				Display.FLY=(int)Display.TIME;
				if(Mplayer.isFly)
				this.actionOnCollision();
			}
		};
	rocket.check(g);
	}
	else if(i==3 && (!isTaken[i])){                               //for the star
		Star star=new Star() {
			
			@Override
			public void check(Graphics2D g) {
				g.drawImage(image, x,y-50,w,h,null);
				isTaken[i]=isCollision(Mplayer.x, x, Mplayer.y,y-50);
				if(isTaken[i]){
					Mplayer.isStar=true;
					Display.STAR=(int)Display.TIME;
				}
			}
		};
		star.check(g);
	}
	else if(i==8 && (!isTaken[i])){                                //for the flower
		Flower flower=new Flower() {
		
			@Override
			public void check(Graphics2D g) {
			
				g.drawImage(image, x,y-50,w,h,null);
				isTaken[i]=isCollision(Mplayer.x, x, Mplayer.y,y-50);
				if(isTaken[i]){
					Mplayer.isFlower=true;
					Display.FLOWER=(int)Display.TIME;
				}
				
			}
		};
		flower.check(g);
	}
	else if(!(isTaken[i])){                                      //for all the coins
	Coins.isCoin=true;
	Coins.X=x;
	Coins.I=i;
	}}			
		
		
	
	
	
	public boolean isCollision(int marioX,int bonusX,int marioY,int bonusY){
		if((Math.abs(marioY-bonusY)<50)&&(Math.abs(marioX-bonusX)<=50)){
			Display.SCORE+=150;
		//	BackGroundMusic.playBonusTaken();                                          music
			return true;
		}
		else return false;
	}

}
