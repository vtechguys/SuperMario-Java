package Draw;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import Player.Mplayer;
import game.Camera;

public class pipeImages{
	public static int x1;
	int x2;                            //1 for long and 2 for short
	int y1,y2;
	int speed;
	Image longPipe,shortPipe;
	public pipeImages() {
		longPipe=new ImageIcon(Mplayer.class.getResource("longPipe.jpg")).getImage();
		shortPipe=new ImageIcon(Mplayer.class.getResource("shortPipe.jpg")).getImage();
		this.x1=3790;
		this.x2=8875;
		this.y2=470;
        this.y1=369;
		}
	public void drawImagesOverlap(Graphics2D g){
		g.drawImage(longPipe, this.x1, this.y1,84,196,null);
		g.drawImage(shortPipe, this.x2, this.y2,84,84,null);
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
	public void move(){
		//System.out.println("x"+x+"speed"+speed);
		
		x1+=speed;
		x2+=speed;
	}

}
