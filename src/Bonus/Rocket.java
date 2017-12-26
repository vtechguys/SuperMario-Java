package Bonus;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.Timer;

import Common.gameConstants;
import Player.Mplayer;
import game.Camera;

abstract public class Rocket {
	String name="rocket.png";
	Image image= new ImageIcon(Mplayer.class.getResource(name)).getImage();
	public abstract void check(Graphics2D g);
	//Timer timer;
	public void actionOnCollision(){
		
		//while(Camera.x<=1470){
	//	timer(KeyEvent.VK_RIGHT,50);	
		//}
	//	System.out.println(Camera.x);
		//if(!(Camera.x<=1470))
		//Mplayer.isFly=false;
	}
}
