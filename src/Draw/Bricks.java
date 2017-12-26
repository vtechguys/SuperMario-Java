package Draw;

import java.awt.Graphics2D;

import javax.swing.ImageIcon;

import Common.gameConstants;
import Music.BackGroundMusic;
import Player.Mplayer;
import game.Camera;

public class Bricks extends Sprite{
public Bricks(int x,int y,String name){
	this.x=x;
	this.y=y;
	h=w=50;
	speed=5;
	image= new ImageIcon(Mplayer.class.getResource(name)).getImage();
	
}

public void drawBrick(Graphics2D g,int i){
	prepareItems.isPresentBrick[i]=(this.checkCollision(this.x, Mplayer.x+25, this.y, Mplayer.y+25,i,30));//check collision returns false is collision is from down
	
	//System.out.println(prepareItems.isRemove[i]);
	g.drawImage(image, x,y,w,h,null);
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

}
