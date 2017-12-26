package Bonus;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import Common.gameConstants;
import Music.BackGroundMusic;
import Player.Mplayer;

public class Coins {public static boolean isCoin;
     public static int I,X;
	 boolean isUp;
	 int ySpeed,H,W,Y;
     Image image;
     public Coins(){
    	 
     }
	 public Coins(int y ,int w,int h){
		 image= new ImageIcon(Mplayer.class.getResource("coins.gif")).getImage();
		    
			this.Y=y;
			this.H=h;
			this.W=w;	
			
			up();
	 }	

	public  void check(Graphics2D g){		
		
		g.drawImage(image,X,Y,W,H,null);
	//	System.out.println(Y);
	//	this.fall();
		
	}
	public void up() {
		if(!isUp){
		//	System.out.println("called");
			ySpeed=-13;
			Y+=ySpeed;
			isUp=true;
		}}
	
	
	public void fall(){int temp;
	if(I<8)
		temp=gameConstants.COIN_FIRST_FLOOR_MAX;
	else
		temp=gameConstants.COIN_SECOND_FLOOR_MAX;
		//System.out.println(Y);
			if(Y>temp){	
				//System.out.println("called");
				ySpeed+=1;
				Y+=ySpeed;
				if(Y<=temp)
				{	//System.out.println("called");
					Coins.isCoin=false;  //if i remove this coin moves with player
				BonusItems.isTaken[I]=true;//for making the coin invisible
				}
				
			//	System.out.println(y);
			}
			else if(Y<=temp){
				isUp=false;
				
			}
			
		}

		
	

}
