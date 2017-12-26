package Draw;

import java.awt.Image;

import Bonus.BonusItems;
import Common.Display;
import Common.gameConstants;
import Music.BackGroundMusic;
import Player.Mplayer;

public abstract class Sprite {
protected	int x,y,w,h,speed;
protected boolean isCollision;
protected boolean isVisible;
protected Image image,image2;
int remainder;
protected int xMinColl []={48,49,50,51,52,53,54,43,44,45,46,47};
actionOnCollision action=new actionOnCollision();
public void move(){
	//System.out.println("x"+x+"speed"+speed);
	
	x+=speed;
}
int prepareRemainderBricks(int i){
	switch(i){
	case 1: case 22: return 0 ;
	case 13: case 14 :case 20:case 25:case 29:return 1;
	case 23:return 2;
	case 15:case 21:case 26:return 3;
	case 2:case 24:return 4;
	case 16:case 27:return 5;
	case 5:return 6;
	case 3:case 8:case 11:case 17:case 28:return 7;
	case 0:case 6:return 8;
	case 9:case 12:case 18:return 9;
	case 7:return 10;
	case 4:case 10: case19:	return 11;
	default:return 0;
	}
}
int prepareRemainderQuesMarks(int i){
	switch(i){
	case 0:case 8: return 0;
	case 2:case 5:case 10: return 2;
	case 9: return 6;
	case 4:case 6: return 8;
	case 3:case 11: return 9;
	case 1: return 10;
	case 7:case 12: return 11;
	default: return 0;
	}
}
public boolean checkCollision(int imgX,int marioX,int imgY, int marioY,int i,int range){
	int max=0;
	//System.out.println("imgX"+imgX+"imgY"+imgY+"marioX"+marioX+"marioY"+marioY);
 //   if((i==8&&range==13))
   // System.out.println("imgY"+imgY+"marioY"+marioY);
    	//System.out.println(marioY-imgY);
   // {System.out.println("imgX-marioX"+(imgX-marioX)+" "+xMinColl[this.prepareRemainder(i)]+" "+Math.abs(imgY-marioY));}
 //   remainder=prepareRemainder(i);
	
	//if((imgX-marioX)==xMinColl[this.prepareRemainder(i,range)] && (Math.abs(imgY-marioY)<=50)){//done
		//{System.out.println("collision left");
		//this.action.setisCollision(true);
		//}
	//}
	//if((imgX-marioX)==(xMinColl[this.prepareRemainder(i,range)]-96)&& (Math.abs(imgY-marioY)<=50)){//done
		//System.out.println("collision right");
	//}
	if(range==30)
		max=14;
	else if(range==13)
		max=8;
	if((marioY-imgY)<=-64&& ((imgX-marioX)>=(xMinColl[this.prepareRemainder(i,range)]-96))&&((imgX-marioX)<=(xMinColl[this.prepareRemainder(i,range)]))){
		if(i<max)
		action.setFloor(270);
		else action.setFloor(80);
		//System.out.println(Mplayer.y);
		//System.out.println("collision up");
	}
	if(((marioY-imgY)==58||(marioY-imgY)==50)&& ((imgX-marioX)>=(xMinColl[this.prepareRemainder(i,range)]-96))&&((imgX-marioX)<=(xMinColl[this.prepareRemainder(i,range)]))){
		
		Mplayer.ySpeed=Math.abs(Mplayer.ySpeed);
	if(range==30)                                                    //music start
			{//BackGroundMusic.playBrickBreak();
			Display.SCORE+=50;}
		else if(!BonusItems.isTaken[i])
		{if(i==2||i==3||i==8){
		//	BackGroundMusic.playBonusAppear();
		}
		else{
		//	BackGroundMusic.playCoin();
			Display.COINS++;
			Display.SCORE+=100;
		}}
		else
			{//BackGroundMusic.playAfterBonus();                        //music end
			}
			return false;
	}
	else 
	{   if(range==30)
		if(prepareItems.isPresentBrick[i])
		return true;
	    if(range==13)
	    	if(prepareItems.isPresentQuesMark[i])
	    		return true;
	return false;
}}
int prepareRemainder(int i,int range){
	int remainder=0;
	if(range==30){
	remainder=this.prepareRemainderBricks(i);
		
	}
	else if(range==13){
		remainder=this.prepareRemainderQuesMarks(i);
	}
	return remainder;
}
public int getX() {
	return x;
}
public void setX(int x) {
	this.x = x;
}
public int getY() {
	return y;
}
public void setY(int y) {
	this.y = y;
}
public int getW() {
	return w;
}
public void setW(int w) {
	this.w = w;
}
public int getH() {
	return h;
}
public void setH(int h) {
	this.h = h;
}
public int getSpeed() {
	return speed;
}
public void setSpeed(int speed) {
	this.speed = speed;
}
public boolean isVisible() {
	return isVisible;
}
public void setVisible(boolean isVisible) {
	this.isVisible = isVisible;
}
public Image getImage() {
	return image;
}
public void setImage(Image image) {
	this.image = image;
}
	

}
