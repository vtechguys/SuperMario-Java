package different;

import Common.gameConstants;
import Music.BackGroundMusic;
import Player.Mplayer;
import game.Camera;

public class inPipe {
	public static boolean isStopFront;
	public static boolean isStopBack;
	public static int Floor;
	int x[]={268,318,368,418,468,518,568,618,668,718};
	CoinsAdditional [] coins=new CoinsAdditional[10];
	public inPipe() {
		for(int i=0;i<10;i++){
			coins[i]=new CoinsAdditional(this.x[i], gameConstants.InPipeBrickFloor+50);
		}
	}
	
	public void checkPrecision(){
		if(Mplayer.x<56){
			
			inPipe.isStopBack=true;
		}
		else if(Mplayer.x>964){
			
			inPipe.isStopFront=true;
		}
		else if(Mplayer.y>gameConstants.InPipeBrickFloor){
			if(Mplayer.x<728&&Mplayer.x>455){
				
				inPipe.isStopBack=true;
			}
			else if(Mplayer.x>204&&Mplayer.x<228)
				{	
				inPipe.isStopFront=true;}
			else if(Mplayer.y>gameConstants.InPipePipeFloor){
				if(Mplayer.x>824)
					{//BackGroundMusic.playPipe();                                    music
					Camera.isInPipe=false;
					Camera.outOfPipe=true;
					Mplayer.isEnterPipe=false;
					}
				else
					inPipe.isStopFront=false;	
			}
			else {
				inPipe.isStopBack=inPipe.isStopFront=false;
			}
		}
	
		else{
			inPipe.isStopBack=inPipe.isStopFront=false;
		}
		
		
		if(Mplayer.x>204&&Mplayer.x<728&&Mplayer.y<=gameConstants.InPipeBrickFloor){
			Mplayer.FLOOR=gameConstants.InPipeBrickFloor;
		}
		else if(Mplayer.x>824&&Mplayer.y<=gameConstants.InPipePipeFloor){
			Mplayer.FLOOR=gameConstants.InPipePipeFloor;
		}
		else{
			Mplayer.FLOOR=gameConstants.InPipeGroundFloor;
		}
		
		
	}

	public CoinsAdditional[] getCoins() {
		return coins;
	}
	

}
