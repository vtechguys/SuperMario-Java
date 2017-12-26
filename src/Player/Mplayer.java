package Player;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

import Common.Display;
import Common.gameConstants;
import Music.BackGroundMusic;
import different.inPipe;
import game.Camera;

public class Mplayer implements gameConstants {
    inPipe inpipe=new inPipe();
    public static boolean isStopFront,isStopBack;
	public static boolean isDead,isNotVisible,isReachedEnd;
	public static boolean isStanding=true;
	public static boolean isFly,isFire,isFlower,isStar,isEnterPipe;
	public static int FLOOR,xSpeed=1,ySpeed;
	//public static int FLOOR=80;
	public static int x, y,speed;
	int height,width;
	Image imageRight,imageFly,imageLeft,imageStanding,imageStanding2,imageRightPower,imageLeftPower,imageStandingPower,imageStanding2Power;
	boolean isJump;
	SpecialFeatures features=new SpecialFeatures();
	
	public Mplayer(){
		this.x=MARIO_X;
		FLOOR=gameConstants.GROUND_FLOOR;
	//	FLOOR=gameConstants.InPipeGroundFloor;
		this.y=FLOOR;
		this.speed=1;
		this.width=this.height=MARIO_SIZE;
	imageRight= new ImageIcon(Mplayer.class.getResource("mario.gif")).getImage();
	imageFly= new ImageIcon(Mplayer.class.getResource("marioFly.png")).getImage();
    imageLeft=new ImageIcon(Mplayer.class.getResource("marioLeft.gif")).getImage();
    imageStanding=new ImageIcon(Mplayer.class.getResource("marioStanding.png")).getImage();
    imageStanding2=new ImageIcon(Mplayer.class.getResource("marioStanding2.png")).getImage();
   // imageRightPower= new ImageIcon(Mplayer.class.getResource("marioRightPower.gif")).getImage();
//	imageLeftPower=new ImageIcon(Mplayer.class.getResource("marioLeftPower.gif")).getImage();
  //  imageStandingPower=new ImageIcon(Mplayer.class.getResource("marioPower1.png")).getImage();
    //imageStanding2Power=new ImageIcon(Mplayer.class.getResource("marioPower2.png")).getImage();
    
	}
	
	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void drawPlayer(Graphics2D g){
		if(Camera.isInPipe){
			inpipe.checkPrecision();
		}
		if(!Mplayer.isNotVisible)
		{if(!Mplayer.isReachedEnd)
			{
			//if(!this.isStar&&!this.isFlower)
		
		{if(isFly){
			g.drawImage(imageFly,x,y,width-30,height,null);
		}
		else if(isStanding&&Camera.speed>=0&&xSpeed>=0){
			g.drawImage(imageStanding,x,y,width,height,null);	
		}
		else if(isStanding&&Mplayer.x<=100&&xSpeed<=0){
			g.drawImage(imageStanding2,x,y,width,height,null);	
		}
		else if(Camera.speed>=0&&xSpeed>0)
		g.drawImage(imageRight,x,y,width,height,null);
		else
			g.drawImage(imageLeft,x,y,width,height,null);
		}
//			else{
//				if(isFly){
//				g.drawImage(imageFly,x,y,width-30,height,null);
//			}
//			else if(isStanding&&Camera.speed>=0&&xSpeed>=0){
//					g.drawImage(imageStanding2Power,x,y,width,height,null);	
//				}
//				else if(isStanding&&Mplayer.x<=100&&xSpeed<=0){
//					g.drawImage(imageStandingPower,x,y,width,height,null);	
//				}
//				else if(Camera.speed>=0&&xSpeed>0)
//				g.drawImage(imageRightPower,x,y,width,height,null);
//				else
//					g.drawImage(imageLeftPower,x,y,width,height,null);
//				
//			}
			
			}
		else
			g.drawImage(imageRight,x,y,width,height,null);
		}
		
		
		if(Display.FLOWER-(int)Display.TIME<25)                              //time for firing
		{	if(isFire){                                                     //isFire condition
			features.fire(g,Mplayer.y);
		}}
		else
		{
			Mplayer.isFlower=false;
		}
		if(Display.STAR-(int)Display.TIME>5){
			Mplayer.isStar=false;
		}
	}
	public void jump() {
		if(!isJump){//BackGroundMusic.playSuperJump();                         //music
			this.ySpeed=-35;
			y+=ySpeed;
			isJump=true;
		}
		
		
	}
	public void fall(){
		
		if(!isFly)                        //for not applying gravity when flying
		{if(this.y<FLOOR){
			
			ySpeed+=gameConstants.GRAVITY;
			y+=ySpeed;
			if(y>=FLOOR)
			y=FLOOR;
		//	System.out.println(y);
		}
		else if(this.y>=FLOOR){
			isJump=false;
			
		}}
	}
    public void enter(){                                                                   
    	if(isEnterPipe){
    		if(this.y<368){
    			ySpeed+=gameConstants.GRAVITY;
    			y+=ySpeed;	
    		}
    		else{
    			if(!Camera.outOfPipe)
    			Camera.isInPipe=true;
   
    		}
    	}
    }
    public void takeOff(){
    	if(isFly&&Mplayer.y>=50){
    		Mplayer.y-=4;
    		
    	}
    }
    public void moveLeft(){
    	xSpeed=-4;
    	if(!Mplayer.isStopBack&&!Camera.isInPipe)
    	this.x+=(xSpeed);
    	else if(Camera.isInPipe&&!inPipe.isStopBack){
    		this.x+=(xSpeed);
    	}
    }
    public void moveRight(){
    	xSpeed=4;
    	if(Camera.isInPipe&&!inPipe.isStopFront)
    		this.x+=xSpeed;
    	else if(!Camera.isInPipe&&!Mplayer.isStopFront){
    		this.x+=xSpeed;
    	}
    
//    	System.out.println(x);
    }
    
    
public void checkBack(int camX){
	
    	if(Mplayer.x==-24)
    		Mplayer.isStopBack=true;
    	else{
    		Mplayer.isStopBack=false;
    	}
    }

  public void checkFront(int camX){
	
    	if(Mplayer.x==100){
    		Mplayer.isStopFront=true;
    	}
    	else{
    	Mplayer.isStopFront=false;
    	}
      }
}
