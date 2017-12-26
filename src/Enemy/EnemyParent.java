package Enemy;

import java.awt.Image;

import Common.gameConstants;
import Music.BackGroundMusic;
import Player.Mplayer;



public abstract class EnemyParent {
	int x;
	int y;
	int ySpeed;
	int width;
	int height;
	int speed;
	int speedOwn;
	int floor;
	int identifier;
	boolean die;
	int boundary1,boundary2;
	String imageName;
	Image img;
	

public void move(){
	//System.out.println("x"+x+"speed"+speed);
	boundary1+=speed;
	boundary2+=speed;
	x+=speed;
}
public void moveOwn(){
	x+=speedOwn;
}
public int checkCollision(int marioX,int marioY,int goombaX,int goombaY){
	int value=0;
	if(Math.abs(marioX-goombaX)<=49&&Math.abs(marioY-goombaY)<=60&&Mplayer.ySpeed>0&&(Mplayer.ySpeed<37||Mplayer.ySpeed>48)&&Mplayer.ySpeed>=33){
    value=1;
   // System.out.println("mY"+marioY+"gY"+goombaY+"mX"+marioX+"gX"+goombaX+"sp"+Mplayer.ySpeed);
  //  System.out.println("called1");
    }
	else if(marioY<=goombaY)//condition for side collision
	{   
		if(Math.abs(marioY-goombaY)<50 && Math.abs(marioX-goombaX)<=50)
		{  if(!Mplayer.isStar)
			{//System.out.println("mY"+marioY+"gY"+goombaY+"mX"+marioX+"gX"+goombaX+"sp"+Mplayer.ySpeed);
			value=2;}
		else {
			value=3;
			//BackGroundMusic.playEnemyDie();
			
		}
		//System.out.println("called2");
		}
	}
	else{
		if(Math.abs(marioY-goombaY)<=10&& Math.abs(marioX-goombaX)<=50)
			{if(!Mplayer.isStar)
				value=2;
			else {value=3;
			//BackGroundMusic.playEnemyDie();
		
			}
			//System.out.println("called3");
			}
		//0 returned when nothing if 1 goomba killed 2 mario killed
	}
   
	return value;
}



}