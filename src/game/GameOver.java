package game;

import Common.Display;
import Player.Mplayer;

public class GameOver {
	private static boolean isTrue;
	public static boolean isOver()
	{if((Mplayer.y<680||Camera.isInPipe||Camera.outOfPipe)&&!Mplayer.isDead&&Display.TIME>0){
		isTrue=false;
	}
	else{
		isTrue=true;
	}
	
	return isTrue;
	}
}
