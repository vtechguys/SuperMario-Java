package Bonus;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import Player.Mplayer;

abstract public class Star {
	String name="star.png";
	public abstract void check(Graphics2D g);
	Image image= new ImageIcon(Mplayer.class.getResource(name)).getImage();

}
