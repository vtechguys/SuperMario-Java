package Draw;

import java.awt.Graphics2D;

import javax.swing.ImageIcon;

import Bonus.BonusItems;
import Common.gameConstants;
import Music.BackGroundMusic;
import Player.Mplayer;
import game.Camera;

public class questionMarks extends Sprite {
	BonusItems item=new BonusItems();// question marks hasA bonusItem
	//String nameBonus;
	int Y;
	public questionMarks(int x,int y,String name,String name2){
		
		this.x=x;
		Y=this.y=y;
		h=w=50;
		speed=5;
		image= new ImageIcon(Mplayer.class.getResource(name)).getImage();
		image2=new ImageIcon(Mplayer.class.getResource(name2)).getImage();
	//	bonus=new ImageIcon(Mplayer.class.getResource(bonusImage)).getImage();
	//	nameBonus=bonusImage;
		
	}
	
	
	public void drawQuestioinMarks(Graphics2D g,int i){
		prepareItems.isPresentQuesMark[i]=(this.checkCollision(this.x,Mplayer.x+25, this.y, Mplayer.y+25,i,13));//check collision returns false is collision is from down
		//g.drawImage(bonus, x,Y,w,h,null);	
		if(prepareItems.isPresentQuesMark[i])
		g.drawImage(image, x,y,w,h,null);
		else{
			g.drawImage(image2, x,y,w,h,null);	
			this.item.drawBonus(x,y,w,h,g,i);
			//this.bonusAppear(i,g);
			}
		
	}
	public void left(int camSpeed){
		if(Camera.isStop==false)
		{speed=(Math.abs(camSpeed)+8);
		//speed = gameConstants.CAMERA_SPEED+8;
		}
		else{
			speed=0;
		}
		move();
		
	}
	public void right(int camSpeed){
	   if(Camera.isStop==false)
		{speed=-(camSpeed+8);}
	    //System.out.println("camspeed"+speed+" "+camSpeed);
		//speed = -(gameConstants.CAMERA_SPEED+8);
	   else{
		   speed=0;
	   }
		move();
		
	}
 //void bonusAppear(int i,Graphics2D g){
//	 if(!nameBonus.equals("coin.gif")){
		
	//	 while(!(y-Y==50)){
	//		Y-=1; 
			
		//	System.out.println(bonus);
	//	 }
	// }
	 
 //}


}
