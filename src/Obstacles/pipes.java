package Obstacles;

import Common.gameConstants;
import Player.Mplayer;

public class pipes{boolean isPipeCollision;
//	public boolean isCollision(int referenceX,int pipeX){
//		System.out.println("pipe"+ pipeX+" player "+referenceX);
//		if(pipeX-referenceX==gameConstants.MARIO_SIZE){
//			System.out.println("reached here");
//			return true;
//		}
//		
//		return false;
//	}

	
	public boolean checkPipeCollision(int x){
		
		int yPlayer=Mplayer.y;
		if((x>=744 &&x<=788)||(x>=2904 &&x<=2948)||(x>=3160 &&x<=3204))
		{	smallPipe sp=new smallPipe(){
			@Override
			public boolean check()
			{if(yPlayer<=floor){
				//set floor as floor
				//System.out.println("yplayer="+yPlayer+"floor"+floor);
				Mplayer.FLOOR=floor;
				return false;
			}
			else{//System.out.println("yplayer="+yPlayer+"floor"+floor);
				return true;
			}}
		};
		isPipeCollision=sp.check();
		}
		else if(x>=904 &&x<=948){
			mediumPipe mp=new mediumPipe() {
				@Override
				public boolean check()
				{if(yPlayer<=floor){
					//set floor as floor
					Mplayer.FLOOR=floor;
					return false;
				}
				else{
					return true;
				}
				}
			};
			isPipeCollision=mp.check();
		}
		else if((x>=1032 &&x<=1076)||(x>=1208 &&x<=1252)){
			largePipe lp=new largePipe() {
				@Override
				public boolean check()
				{if(yPlayer<=floor){
					//set floor as floor
					Mplayer.FLOOR=floor;
					return false;
				}
				else{
					return true;
				}
				}
			};
			isPipeCollision=lp.check();
		}
		else{
			Mplayer.FLOOR=468;;
		isPipeCollision=false;}
		return isPipeCollision;
	}
}
