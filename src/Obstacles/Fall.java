package Obstacles;

import Common.gameConstants;
import Player.Mplayer;
import game.Camera;

public class Fall {
	public void fallDown(int x){
		if(((x>=1412&&x<=1436)||(x>=1682&&x<=1724)||(x>=2741&&x<=2773))&&(Mplayer.y>=120)){
			Mplayer.FLOOR=865;
		}
		if(Mplayer.y>468&&!Camera.isInPipe&&!Camera.outOfPipe){
			Mplayer.FLOOR=865;
		}
		if(Camera.outOfPipe){
			Mplayer.x=100;
			Mplayer.y=371;;
			Mplayer.FLOOR=371;
			Camera.outOfPipe=false;
			
		}
		
	}

}
