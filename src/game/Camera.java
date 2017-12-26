package game;

import Common.Display;
import Common.gameConstants;
import Obstacles.Collision;
import Obstacles.pipes;
import Obstacles.smallPipe;
import Player.Mplayer;

public class Camera implements gameConstants{
	public static boolean isStop,isInPipe,outOfPipe;//used for stopping bricks and question marks
	public static int x=CAMERA_SPEED;
	//private int x=1410;
//	private int x=FLOOR;
	public static int speed=CAMERA_SPEED;
	private boolean backEnd=false;
	private boolean frontEnd=false;
	private boolean isStopFront;
	private boolean isStopBack;
	//private boolean frontEndPipe=false;
	Collision detect=new Collision();
	
	private void check(){
		//System.out.println(x);
	
		if(!Camera.isInPipe)
		{if(speed>0)
		{isStopFront=detect.isCollision(this.x);//linked with class collision where all types of collisions are being checked
		isStopBack=false;
		}
		else if(speed<0)
			{isStopBack=detect.isCollision(this.x);
			isStopFront=false;
		}
		//for limiting background image
		if(x<CAMERA_SPEED)
			this.backEnd=true;
		else if(x>(3840-(IMAGE_WIDTH)-CAMERA_SPEED))
			this.frontEnd=true;
		else{
			this.backEnd=false;
			this.frontEnd=false;
		}
		if(Display.FLY-(int)Display.TIME>4)
		//if(Display.FLY-(int)Display.TIME>20)
			Mplayer.isFly=false;                    //for removing the flying condition
//		smallPipe sp=new pipes();
//		if(sp.isCollision(x,744+MARIO_SIZE)){
//			this.frontEndPipe=true;
//			//System.out.println("reached here");
//		}
	}}
	
	public void moveCamera(){
		this.check();
		if(this.backEnd||this.isStopBack)
		{ if(speed>0)
			{x = x + speed;
			isStop=false;}
		else isStop=true;
		}
		else if(this.frontEnd||this.isStopFront)
		{if(speed<0)
			{x = x + speed;
			isStop=false;}
		else isStop=true;
		}
		else
			{x=x+speed;
			isStop=false;}
		//System.out.println(x);
	}
	public boolean isStopBack() {
		return isStopBack;
	}

	public boolean isStopFront() {
		return isStopFront;
	}

	public void setStopFront(boolean isStopFront) {
		this.isStopFront = isStopFront;
	}

	public void setStopBack(boolean isStopBack) {
		this.isStopBack = isStopBack;
	}

	public void left(){
		Mplayer.isStanding=false;
		speed = -CAMERA_SPEED;
		moveCamera();
	}
	public void right(){
		Mplayer.isStanding=false;
		speed = CAMERA_SPEED;
		moveCamera();
	}
	public int getX(){
		return x;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	

}
