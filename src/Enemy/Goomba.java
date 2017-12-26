package Enemy;

import java.awt.Graphics2D;

import javax.swing.ImageIcon;

import Common.Display;
import Common.gameConstants;
import Draw.prepareItems;
import Music.BackGroundMusic;
import Player.Mplayer;
import Player.SpecialFeatures;
import game.Camera;

public class Goomba extends EnemyParent{

	public Goomba(int x,int y,int speed,int boundary1,int boundary2,int identifier){
		this.identifier=identifier;
		this.boundary2=boundary2;
		this.boundary1=boundary1;
		this.x=x;
		this.y=y;
		this.floor=y;
		this.speedOwn=speed;
		this.imageName="enemy1.gif";
		this.height=this.width=50;
		this.img=new ImageIcon(Mplayer.class.getResource(imageName)).getImage();
	}
	public void drawGoomba(Graphics2D g){int temp=0;
		if(!this.die)
		temp=this.checkCollision(Mplayer.x+25, Mplayer.y+25, this.x, this.y);
		if(temp==1)	
		{//BackGroundMusic.playEnemyDie();                                                //music
		this.die=true;
		Display.SCORE+=150;}
		else if(temp==2)
			Mplayer.isDead=true;
		else if(temp==3){
			this.floor=700;
		}
		if(!this.die)
		{g.drawImage(img,x,y,width,height,null);
		this.fall();}
		if(this.x>=boundary2||this.x<=boundary1)
			speedOwn*=-1;
		moveOwn();
		collision(SpecialFeatures.x,SpecialFeatures.y,this.x,this.y);
	}
	void collision(int fireX,int fireY,int goombaX,int goombaY){
		if(fireY>goombaY &&fireY<(goombaY+50)){
			if(Math.abs(fireX-goombaX)<=18&&SpecialFeatures.xSpeed>=0){
			//	BackGroundMusic.playEnemyDie();                                         //music
				Display.SCORE+=150;
				Mplayer.isFire=false;
				SpecialFeatures.flag=true;
				this.reset();
				this.floor=700;
			}
			else if(Math.abs(fireX-goombaX)<=50&&SpecialFeatures.xSpeed<=0){
				//BackGroundMusic.playEnemyDie();                                       //music
				Display.SCORE+=150;
				Mplayer.isFire=false;
				SpecialFeatures.flag=true;
				this.reset();
				this.floor=700;
				
			}
		}
		
	}
	void reset(){                           //for changing the position of bullet so that other enemies donot die
	if(Camera.speed>0)
		SpecialFeatures.x=Mplayer.x+60;
		else
			SpecialFeatures.x=Mplayer.x+10;
	
	}
	void changeFloor(){//for bringing down the goomba's      
		this.fallingLeftFirstFloor();
		this.fallingRightFirstFloor();
		this.fallingLeftSecondFloor();
	
		
		
	}
	void fallingLeftSecondFloor(){
		if(!prepareItems.isPresentBrick[15]&&this.x<=boundary1+60&&this.floor+50==gameConstants.SECOND_FLOOR){
			this.floor=516;
			this.boundary1-=570;
		}
	else if(!prepareItems.isPresentBrick[14]&&this.x<=boundary1+40&&this.floor+50==gameConstants.SECOND_FLOOR){
			this.floor=516;
			this.boundary1-=560;
		}
		if(this.x<=boundary1+100&&this.x>=boundary1&&this.floor==516&&this.identifier==5){
			this.floor=700;
		}
		
	}
	void fallingLeftFirstFloor(){
		if(!prepareItems.isPresentBrick[3]&&this.x<=boundary1+40&&this.floor+50==gameConstants.FIRST_FLOOR){
			this.floor=516;
			this.boundary1-=360;
		}
		if(this.x<=boundary1+60&&this.x>=boundary1&&this.floor==516&&this.identifier==4){
			this.floor=700;
		}
		
	}
	void fallingRightFirstFloor(){
		if(!prepareItems.isPresentBrick[4]&&this.x>=boundary2-40&&this.floor+50==gameConstants.FIRST_FLOOR){
			this.floor=516;
			this.boundary2+=360;
		}
		
		
		if(this.x>=boundary2-60&&this.floor==516&&this.identifier==4){
			this.floor=700;
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
	
	void fall(){
		if(this.y>=670)
			this.die=true;
		this.changeFloor();
		if(this.y<this.floor){
			
			ySpeed+=gameConstants.GRAVITY;
			y+=ySpeed;
			if(y>=this.floor)
			y=this.floor;
		//	System.out.println(y);
		}
		
	}
	
	
}
